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

/**
 * {"Elapsed":450,"MHS av":1.07,"MHS 5s":1.03,"Found
 * Blocks":0,"Getworks":13,"Accepted":29,"Rejected":0,"Hardware
 * Errors":0,"Utility":3.87,"Discarded":22,"Stale":0,"Get Failures":0,"Local
 * Work":57,"Remote Failures":0,"Network Blocks":3,"Total MH":479.9857,"Work
 * Utility":967.45,"Difficulty Accepted":6848.00000000,"Difficulty
 * Rejected":0.00000000,"Difficulty Stale":0.00000000,"Best Share":5694,"Device
 * Hardware%":0.0000,"Device Rejected%":0.0000,"Pool Rejected%":0.0000,"Pool
 * Stale%":0.0000}
 *
 * @author Ondrej.Bozek
 */
public class Summary
{

    private Integer elapsed;
    @SerializedName("MHS av")
    private Double mhsAverage;
    @SerializedName("MHS 5s")
    private Double mhs5s;
    @SerializedName("Found Blocks")
    private Long foundBlocks;
    private Long getworks;
    private Long accepted;
    private Long rejected;
    @SerializedName("Hardware Errors")
    private Long hwErrors;
    private Double utility;
    @SerializedName("Difficulty Accepted")
    private Double difficultyAccepted;
    @SerializedName("Best Share")
    private Long bestShare;
    @SerializedName("Device Hardware%")
    private Double deviceHardaware;
    @SerializedName("Device Rejected%")
    private Double deviceRejected;
    @SerializedName("Pool Rejected%")
    private Double poolRejected;
    @SerializedName("Pool Stale%")
    private Double poolStale;

    public Summary(Integer elapsed, Double mhsAverage, Double mhs5s, Long foundBlocks,
            Long getworks, Long accepted, Long rejected, Long hwErrors, Double utility,
            Double difficultyAccepted, Long bestShare, Double deviceHardaware,
            Double deviceRejected, Double poolRejected, Double poolStale)
    {
        this.elapsed = elapsed;
        this.mhsAverage = mhsAverage;
        this.mhs5s = mhs5s;
        this.foundBlocks = foundBlocks;
        this.getworks = getworks;
        this.accepted = accepted;
        this.rejected = rejected;
        this.hwErrors = hwErrors;
        this.utility = utility;
        this.difficultyAccepted = difficultyAccepted;
        this.bestShare = bestShare;
        this.deviceHardaware = deviceHardaware;
        this.deviceRejected = deviceRejected;
        this.poolRejected = poolRejected;
        this.poolStale = poolStale;
    }

    public Summary()
    {
    }

    public Integer getElapsed()
    {
        return elapsed;
    }

    public Double getMhsAverage()
    {
        return mhsAverage;
    }

    public Double getMhs5s()
    {
        return mhs5s;
    }

    public Long getFoundBlocks()
    {
        return foundBlocks;
    }

    public Long getGetworks()
    {
        return getworks;
    }

    public Long getAccepted()
    {
        return accepted;
    }

    public Long getRejected()
    {
        return rejected;
    }

    public Long getHwErrors()
    {
        return hwErrors;
    }

    public Double getUtility()
    {
        return utility;
    }

    public Double getDifficultyAccepted()
    {
        return difficultyAccepted;
    }

    public Long getBestShare()
    {
        return bestShare;
    }

    public Double getDeviceHardaware()
    {
        return deviceHardaware;
    }

    public Double getDeviceRejected()
    {
        return deviceRejected;
    }

    public Double getPoolRejected()
    {
        return poolRejected;
    }

    public Double getPoolStale()
    {
        return poolStale;
    }
}
