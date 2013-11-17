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
package org.obozek.minermonitor.client.dto;

/**
 *
 * @author Ondrej.Bozek
 */
public enum CgMinerCmdEnum {

    summary(CgMinerSummary.class),
    version(CgMinerResponse.class),
    config(CgMinerResponse.class),
    pools(CgMinerResponse.class),
    devs(CgMinerResponse.class),
    devdetails(CgMinerResponse.class),
    pga(CgMinerResponse.class),
    pgacount(CgMinerResponse.class),
    notify(CgMinerResponse.class),
    stats(CgMinerResponse.class),
    coin(CgMinerResponse.class);

    public Class<? extends CgMinerResponse> clazz;

    private CgMinerCmdEnum(Class<? extends CgMinerResponse> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends CgMinerResponse> getClazz() {
        return clazz;
    }

}
