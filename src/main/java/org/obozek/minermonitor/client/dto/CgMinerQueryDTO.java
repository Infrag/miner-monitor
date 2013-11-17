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
 * @param <T>
 */
public class CgMinerQueryDTO<T extends CgMinerResponse> {

    private CgMinerCmdEnum command;
    private String parameter;

    public CgMinerQueryDTO(CgMinerCmdEnum command) {
        this(command, null);
    }

    public CgMinerQueryDTO(CgMinerCmdEnum command, String parameter) {
        this.command = command;
        this.parameter = parameter;
    }

    public CgMinerCmdEnum getCommand() {
        return command;
    }

    public String getParameter() {
        return parameter;
    }
}
