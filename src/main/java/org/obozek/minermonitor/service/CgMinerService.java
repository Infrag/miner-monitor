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

import org.obozek.minermonitor.client.CgMinerClient;
import org.obozek.minermonitor.client.dto.CgMinerCmdEnum;
import org.obozek.minermonitor.client.dto.CgMinerQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
public class CgMinerService
{

    @Autowired
    private CgMinerClient client;

    public String getSummary(String host, Integer port)
    {
        return client.queryCgMiner(host, port, new CgMinerQueryDTO(CgMinerCmdEnum.summary));
    }

    public String getConfig(String host, Integer port)
    {
        return client.queryCgMiner(host, port, new CgMinerQueryDTO(CgMinerCmdEnum.config));
    }

    public String getDevices(String host, Integer port)
    {
        return client.queryCgMiner(host, port, new CgMinerQueryDTO(CgMinerCmdEnum.devs));
    }

    public String getDeviceDetails(String host, Integer port)
    {
        return client.queryCgMiner(host, port, new CgMinerQueryDTO(CgMinerCmdEnum.devdetails));
    }

    public String getNotify(String host, Integer port)
    {
        return client.queryCgMiner(host, port, new CgMinerQueryDTO(CgMinerCmdEnum.notify));
    }
}
