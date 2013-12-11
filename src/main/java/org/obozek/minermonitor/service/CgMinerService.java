/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 12, 2013
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
import java.util.List;
import org.obozek.minermonitor.client.CgMinerClient;
import org.obozek.minermonitor.client.dto.CgMinerCmdEnum;
import org.obozek.minermonitor.client.dto.CgMinerQueryDTO;
import org.obozek.minermonitor.client.dto.CgMinerResponse;
import org.obozek.minermonitor.client.dto.CgMinerSummary;
import org.obozek.minermonitor.client.dto.StatusDTO;
import org.obozek.minermonitor.client.dto.StatusState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
public class CgMinerService {

    @Autowired
    private CgMinerClient client;
    private static final String REQUEST_TIMEOT_MSG = "REQ_TO";
    private static final String REQUEST_TIMEOT_DESC = "Request timed out!";

    public CgMinerResponse getResponse(String host, Integer port, CgMinerCmdEnum command) {
        return getResponse(host, port, new CgMinerQueryDTO<>(CgMinerCmdEnum.summary));
    }

    private <T extends CgMinerResponse> T getResponse(String host, Integer port, CgMinerQueryDTO<T> query) {
        try {
            return client.queryCgMiner(host, port, query);
        } catch (Exception ex) {
            List<StatusDTO> statuses = new ArrayList<>();
            StatusDTO st = new StatusDTO(StatusState.T, new Date(), -1, REQUEST_TIMEOT_MSG, REQUEST_TIMEOT_DESC);
            statuses.add(st);
            CgMinerResponse response = new CgMinerResponse(-1L, statuses);
            return (T) response;
        }
    }

    public CgMinerResponse getSummary(String host, Integer port) {
        return getResponse(host, port, new CgMinerQueryDTO<>(CgMinerCmdEnum.summary));
    }

    public CgMinerResponse getConfig(String host, Integer port) {
        return getResponse(host, port, new CgMinerQueryDTO<CgMinerResponse>(CgMinerCmdEnum.config));
    }

    public CgMinerResponse getDevices(String host, Integer port) {
        return getResponse(host, port, new CgMinerQueryDTO<CgMinerResponse>(CgMinerCmdEnum.devs));
    }

    public CgMinerResponse getDeviceDetails(String host, Integer port) {
        return getResponse(host, port, new CgMinerQueryDTO<CgMinerResponse>(CgMinerCmdEnum.devdetails));
    }

    public CgMinerResponse getNotify(String host, Integer port) {
        return getResponse(host, port, new CgMinerQueryDTO<CgMinerResponse>(CgMinerCmdEnum.notify));
    }
}
