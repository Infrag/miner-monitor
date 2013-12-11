/*
 * Copyright (C) 2013 infragile
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.obozek.minermonitor.view;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLBeanName;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.Serializable;
import javax.annotation.PreDestroy;
import org.obozek.minermonitor.client.dto.CgMinerCmdEnum;
import org.obozek.minermonitor.client.dto.CgMinerResponse;
import org.obozek.minermonitor.client.dto.CgMinerSummary;
import org.obozek.minermonitor.client.dto.StatusState;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.service.CgMinerService;
import org.obozek.minermonitor.service.MinerResponseListener;
import org.obozek.minermonitor.service.MinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author infragile
 */
@URLMapping(id = "auth:MinerSummary", pattern = "/auth/miner-summary/#{minerId : minerSummary.minerId}",
        viewId = "/view/auth/MinerSummary.xhtml")
@Component(value = "minerSummary")
@Scope("view")
@URLBeanName("minerSummary")
public class MinerSummaryView implements MinerResponseListener<CgMinerSummary>, Serializable {

    @Autowired
    private MinerService minerService;
    @Autowired
    private CgMinerService cgMinerService;
    private CgMinerResponse summary;

    private Long minerId;
    private Miner miner;
    private int interval = 3;
    private boolean periodicChecking = true;
    private boolean success = true;

    @URLAction
    public void loadMiner() {
        miner = minerService.getMiner(minerId);
        interval = (int) (miner.getCheckIntervalMs() / 1000);
        minerService.registerListener(this);
        if (!miner.isEnabled()) {
            periodicChecking = false;
        }
        checkMiner();
    }

    public String checkMiner() {
        summary = cgMinerService.getSummary(miner.getHostName(), miner.getPort());
        if (StatusState.T.equals(summary.getStatus().get(0).getStatus())) {
            success = false;
        } else {
            success = true;
        }
        return null;
    }

    @PreDestroy
    private void tearDown() {
        minerService.unregisterListener(this);
    }

    @Override
    public Long getMinerId() {
        return minerId;
    }

    public void setMinerId(Long minerId) {
        this.minerId = minerId;
    }

    @Override
    public CgMinerCmdEnum getCmd() {
        return CgMinerCmdEnum.summary;
    }

    @Override
    public CgMinerSummary listenToResponse(CgMinerSummary response) {
        summary = response;
        return response;
    }

    public CgMinerResponse getSummary() {
        return summary;
    }

    public void setSummary(CgMinerResponse summary) {
        this.summary = summary;
    }

    public Miner getMiner() {
        return miner;
    }

    public void setMiner(Miner miner) {
        this.miner = miner;
    }

    public boolean isPeriodicChecking() {
        return periodicChecking;
    }

    public void setPeriodicChecking(boolean periodicChecking) {
        this.periodicChecking = periodicChecking;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

}
