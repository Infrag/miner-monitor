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

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * {"STATUS":"S","When":1384251030,"Code":11,"Msg":"Summary","Description":"cgminer
 * 3.7.2"}
 *
 * @author Ondrej.Bozek
 */
public class Status
{

    @SerializedName("STATUS")
    private StatusState status;
    private Date when;
    private Integer code;
    private String msg;
    private String description;

    public Status()
    {
    }

    public Status(StatusState status, Date when, Integer code, String msg, String description)
    {
        this.status = status;
        this.when = when;
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public StatusState getStatus()
    {
        return status;
    }

    public Date getWhen()
    {
        return when;
    }

    public Integer getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }

    public String getDescription()
    {
        return description;
    }
}
