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
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ondrej.Bozek
 */
@Entity
public class MinerSummary implements Serializable
{

    @Id
    private Long id;
    private Integer elapsed;
    private Double mhsAverage;
    private Double mhs5s;
    private Long foundBlocks;
    private Long getworks;
    private Long accepted;
    private Long rejected;
    private Long hwErrors;
    private Double utility;
    private Double difficultyAccepted;
    private Long bestShare;
    private Double deviceHardaware;
    private Double deviceRejected;
    private Double poolRejected;
    private Double poolStale;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date when;
    @ManyToOne
    private Miner miner;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getElapsed()
    {
        return elapsed;
    }

    public void setElapsed(Integer elapsed)
    {
        this.elapsed = elapsed;
    }

    public Double getMhsAverage()
    {
        return mhsAverage;
    }

    public void setMhsAverage(Double mhsAverage)
    {
        this.mhsAverage = mhsAverage;
    }

    public Double getMhs5s()
    {
        return mhs5s;
    }

    public void setMhs5s(Double mhs5s)
    {
        this.mhs5s = mhs5s;
    }

    public Long getFoundBlocks()
    {
        return foundBlocks;
    }

    public void setFoundBlocks(Long foundBlocks)
    {
        this.foundBlocks = foundBlocks;
    }

    public Long getGetworks()
    {
        return getworks;
    }

    public void setGetworks(Long getworks)
    {
        this.getworks = getworks;
    }

    public Long getAccepted()
    {
        return accepted;
    }

    public void setAccepted(Long accepted)
    {
        this.accepted = accepted;
    }

    public Long getRejected()
    {
        return rejected;
    }

    public void setRejected(Long rejected)
    {
        this.rejected = rejected;
    }

    public Long getHwErrors()
    {
        return hwErrors;
    }

    public void setHwErrors(Long hwErrors)
    {
        this.hwErrors = hwErrors;
    }

    public Double getUtility()
    {
        return utility;
    }

    public void setUtility(Double utility)
    {
        this.utility = utility;
    }

    public Double getDifficultyAccepted()
    {
        return difficultyAccepted;
    }

    public void setDifficultyAccepted(Double difficultyAccepted)
    {
        this.difficultyAccepted = difficultyAccepted;
    }

    public Long getBestShare()
    {
        return bestShare;
    }

    public void setBestShare(Long bestShare)
    {
        this.bestShare = bestShare;
    }

    public Double getDeviceHardaware()
    {
        return deviceHardaware;
    }

    public void setDeviceHardaware(Double deviceHardaware)
    {
        this.deviceHardaware = deviceHardaware;
    }

    public Double getDeviceRejected()
    {
        return deviceRejected;
    }

    public void setDeviceRejected(Double deviceRejected)
    {
        this.deviceRejected = deviceRejected;
    }

    public Double getPoolRejected()
    {
        return poolRejected;
    }

    public void setPoolRejected(Double poolRejected)
    {
        this.poolRejected = poolRejected;
    }

    public Double getPoolStale()
    {
        return poolStale;
    }

    public void setPoolStale(Double poolStale)
    {
        this.poolStale = poolStale;
    }

    public Date getWhen()
    {
        return when;
    }

    public void setWhen(Date when)
    {
        this.when = when;
    }

    public Miner getMiner()
    {
        return miner;
    }

    public void setMiner(Miner miner)
    {
        this.miner = miner;
    }
}
