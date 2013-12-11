/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 14, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import javax.annotation.PostConstruct;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.obozek.minermonitor.client.dto.CgMinerCmdEnum;
import org.obozek.minermonitor.client.dto.CgMinerResponse;
import org.obozek.minermonitor.client.dto.StatusState;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.entities.MinerCheck;
import org.obozek.minermonitor.entities.MinerSummary;
import org.obozek.minermonitor.entities.MinerWarning;
import org.obozek.minermonitor.repository.MinerFilter;
import org.obozek.minermonitor.repository.MinerRepository;
import org.obozek.minermonitor.repository.MinerSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
@Transactional
public class MinerService {

    @Autowired
    private MinerRepository repository;
    @Autowired
    private MinerSummaryRepository minerSummary;
    @Autowired
    private TaskScheduler scheduler;
    @Autowired
    private CgMinerService cgMinerService;
    private final HashMap<Long, ScheduledFuture> scheduledMiners = new HashMap<>();
    @Value("${minerCheck.startSpread}")
    public int startTimeSpread = 2000;
    public Map<CgMinerCmdEnum, Map<Long, List<MinerResponseListener>>> listeners = new HashMap<>();

    @PostConstruct
    private void init() {
//        start miners
        List<Miner> minersToStart = repository.findStartedMiners();
        int i = 0;
        for (Miner miner : minersToStart) {
            if (!scheduledMiners.containsKey(miner.getId())) {
                DateTime date = new DateTime();
                startMinerChecking(miner, date.plusMillis(i).toDate());
                i += startTimeSpread;
            }
        }
    }

    public Miner getMiner(Long minerId) {
        return repository.findOne(minerId);
    }

    public Boolean isMinerStarted(Long minerId) {
        return scheduledMiners.get(minerId) != null;
    }

    public ScheduledFuture startMinerChecking(Miner miner) {
        return startMinerChecking(miner, new Date());
    }

    public ScheduledFuture startMinerChecking(Miner miner, Date date) {
        // todo validate miner settings
        if (CollectionUtils.isEmpty(miner.getMinerChecks())) {
            miner.setMinerChecks(new ArrayList<MinerCheck>());
            miner.getMinerChecks().add(createSummaryMinerCheck(miner));
        }
        miner.setEnabled(Boolean.TRUE);
        miner = saveMiner(miner);
        ScheduledFuture scheduled = scheduledMiners.get(miner.getId());
        if (scheduled != null) {
            scheduled.cancel(false);
        }
        scheduled = scheduler.scheduleAtFixedRate(new MinerCheckTask(miner, cgMinerService, this), date, miner.getCheckIntervalMs().longValue());
        scheduledMiners.put(miner.getId(), scheduled);
        return scheduled;
    }

    public Miner stopMinerChecking(Miner miner) {
        ScheduledFuture future = scheduledMiners.get(miner.getId());
        if (future != null) {
            future.cancel(true);
            scheduledMiners.remove(miner.getId());
        }
        miner.setEnabled(Boolean.FALSE);
        saveMiner(miner);
        return miner;
    }

    public MinerCheck createSummaryMinerCheck(Miner miner) {
        MinerCheck result = new MinerCheck();
        result.setMiner(miner);
        result.setCommand(CgMinerCmdEnum.summary);
        result.setEnabled(Boolean.TRUE);
        // Add warnings optionally
        return result;
    }

    public Miner saveMiner(Miner miner) {
        if (miner.getMinerChecks() != null) {
            for (MinerCheck minerCheck : miner.getMinerChecks()) {
                minerCheck.setMiner(miner);
            }
        }
        return repository.save(miner);
    }

    public Page<Miner> findMiners(MinerFilter pageRequest) {
        return repository.filter(pageRequest);
    }

    protected MinerSummary saveResponse(CgMinerResponse response, Miner miner, Long queryLag) {

        MinerSummary summary = new MinerSummary(response, queryLag);
        summary.setMiner(miner);
        summary = minerSummary.save(summary);
        return summary;
    }

    public void handleWarning(MinerWarning warning, CgMinerResponse response) {
        // no response !!
        if (StatusState.T.equals(response.getStatus().get(0).getStatus())) {

        }
    }

    public void registerListener(MinerResponseListener listener) {
        Map<Long, List<MinerResponseListener>> cmdListeners = listeners.get(listener.getCmd());
        if (cmdListeners == null) {
            cmdListeners = new HashMap();
        }
        List<MinerResponseListener> idListener = cmdListeners.get(listener.getMinerId());
        if (idListener == null) {
            idListener = new ArrayList<>();
        }
        idListener.add(listener);
        cmdListeners.put(listener.getMinerId(), idListener);
        listeners.put(listener.getCmd(), cmdListeners);
    }

    public void unregisterListener(MinerResponseListener listener) {
        Map<Long, List<MinerResponseListener>> cmdListeners = listeners.get(listener.getCmd());
        if (cmdListeners == null) {
            return;
        }
        List<MinerResponseListener> idListeners = cmdListeners.get(listener.getMinerId());
        if (idListeners == null) {
            return;
        }
        idListeners.remove(listener);
        listeners.put(listener.getCmd(), cmdListeners);
    }
}
