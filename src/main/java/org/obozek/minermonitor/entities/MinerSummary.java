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
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.obozek.minermonitor.client.dto.CgMinerResponse;
import org.obozek.minermonitor.client.dto.CgMinerSummary;
import org.obozek.minermonitor.client.dto.StatusDTO;
import org.obozek.minermonitor.client.dto.SummaryDTO;

/**
 *
 * @author Ondrej.Bozek
 */
@Entity
public class MinerSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer elapsed = 0;
    private Double mhsAverage = 0D;
    private Double mhs5s = 0D;
    private Long foundBlocks = 0L;
    private Long getworks = 0L;
    private Long accepted = 0L;
    private Long rejected = 0L;
    private Long hwErrors = 0L;
    private Double utility = 0D;
    private Double difficultyAccepted = 0D;
    private Long bestShare = 0L;
    private Double deviceHardware = 0D;
    private Double deviceRejected = 0D;
    private Double poolRejected = 0D;
    private Double poolStale = 0D;
    private StatusDTO status;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timeAcquired;
    private Long queryLag;
    @ManyToOne
    private Miner miner;

    public MinerSummary(CgMinerResponse response, Long queryLag) {
        this.status = response.getStatus().get(0);
        this.timeAcquired = new Date();
        this.queryLag = queryLag;
        if (response instanceof CgMinerSummary) {
            SummaryDTO summary = ((CgMinerSummary) response).getSummary().get(0);
            this.accepted = summary.getAccepted();
            this.bestShare = summary.getBestShare();
            this.deviceHardware = summary.getDeviceHardware();
            this.deviceRejected = summary.getDeviceRejected();
            this.difficultyAccepted = summary.getDifficultyAccepted();
            this.elapsed = summary.getElapsed();
            this.foundBlocks = summary.getFoundBlocks();
            this.getworks = summary.getGetworks();
            this.hwErrors = summary.getHwErrors();
            this.mhs5s = summary.getMhs5s();
            this.mhsAverage = summary.getMhsAverage();
            this.poolRejected = summary.getPoolRejected();
            this.poolStale = summary.getPoolStale();
            this.rejected = summary.getRejected();
            this.utility = summary.getUtility();
        }
    }

    public MinerSummary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Double getMhsAverage() {
        return mhsAverage;
    }

    public void setMhsAverage(Double mhsAverage) {
        this.mhsAverage = mhsAverage;
    }

    public Double getMhs5s() {
        return mhs5s;
    }

    public void setMhs5s(Double mhs5s) {
        this.mhs5s = mhs5s;
    }

    public Long getFoundBlocks() {
        return foundBlocks;
    }

    public void setFoundBlocks(Long foundBlocks) {
        this.foundBlocks = foundBlocks;
    }

    public Long getGetworks() {
        return getworks;
    }

    public void setGetworks(Long getworks) {
        this.getworks = getworks;
    }

    public Long getAccepted() {
        return accepted;
    }

    public void setAccepted(Long accepted) {
        this.accepted = accepted;
    }

    public Long getRejected() {
        return rejected;
    }

    public void setRejected(Long rejected) {
        this.rejected = rejected;
    }

    public Long getHwErrors() {
        return hwErrors;
    }

    public void setHwErrors(Long hwErrors) {
        this.hwErrors = hwErrors;
    }

    public Double getUtility() {
        return utility;
    }

    public void setUtility(Double utility) {
        this.utility = utility;
    }

    public Double getDifficultyAccepted() {
        return difficultyAccepted;
    }

    public void setDifficultyAccepted(Double difficultyAccepted) {
        this.difficultyAccepted = difficultyAccepted;
    }

    public Long getBestShare() {
        return bestShare;
    }

    public void setBestShare(Long bestShare) {
        this.bestShare = bestShare;
    }

    public Double getDeviceHardware() {
        return deviceHardware;
    }

    public void setDeviceHardware(Double deviceHardware) {
        this.deviceHardware = deviceHardware;
    }

    public Double getDeviceRejected() {
        return deviceRejected;
    }

    public void setDeviceRejected(Double deviceRejected) {
        this.deviceRejected = deviceRejected;
    }

    public Double getPoolRejected() {
        return poolRejected;
    }

    public void setPoolRejected(Double poolRejected) {
        this.poolRejected = poolRejected;
    }

    public Double getPoolStale() {
        return poolStale;
    }

    public void setPoolStale(Double poolStale) {
        this.poolStale = poolStale;
    }

    public Date getTimeAcquired() {
        return timeAcquired;
    }

    public void setTimeAcquired(Date timeAcquired) {
        this.timeAcquired = timeAcquired;
    }

    public Miner getMiner() {
        return miner;
    }

    public void setMiner(Miner miner) {
        this.miner = miner;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public Long getQueryLag() {
        return queryLag;
    }

    public void setQueryLag(Long queryLag) {
        this.queryLag = queryLag;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MinerSummary other = (MinerSummary) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
