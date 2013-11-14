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
package org.obozek.minermonitor.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ondrej.Bozek
 */
@Entity
public class Miner implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hostName;
    private String port;
    private String minerName;
    @ManyToOne
    private User user;
    private Long checkIntervalMs;
    private Long deadCheckIntervalMs;
    private Boolean alive;
    @OneToMany(mappedBy = "miner")
    private List<MinerCheck> minerChecks;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getHostName()
    {
        return hostName;
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String getMinerName()
    {
        return minerName;
    }

    public void setMinerName(String minerName)
    {
        this.minerName = minerName;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<MinerCheck> getMinerChecks()
    {
        return minerChecks;
    }

    public void setMinerChecks(List<MinerCheck> minerChecks)
    {
        this.minerChecks = minerChecks;
    }

    public Long getCheckIntervalMs()
    {
        return checkIntervalMs;
    }

    public void setCheckIntervalMs(Long checkIntervalMs)
    {
        this.checkIntervalMs = checkIntervalMs;
    }

    public Long getDeadCheckIntervalMs()
    {
        return deadCheckIntervalMs;
    }

    public void setDeadCheckIntervalMs(Long deadCheckIntervalMs)
    {
        this.deadCheckIntervalMs = deadCheckIntervalMs;
    }

    public Boolean getAlive()
    {
        return alive;
    }

    public void setAlive(Boolean alive)
    {
        this.alive = alive;
    }
}
