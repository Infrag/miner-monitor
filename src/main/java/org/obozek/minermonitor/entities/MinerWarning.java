/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 13, 2013
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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ondrej.Bozek
 */
@Entity
public class MinerWarning implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private MinerCheck minerCheck;
    private Integer checkTreshold;
    private Integer missedChecks;
    private Double mhsBoundary;
    private String email;
    private String phoneNumber;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public MinerCheck getMinerCheck()
    {
        return minerCheck;
    }

    public void setMinerCheck(MinerCheck minerCheck)
    {
        this.minerCheck = minerCheck;
    }

    public Double getMhsBoundary()
    {
        return mhsBoundary;
    }

    public void setMhsBoundary(Double mhsBoundary)
    {
        this.mhsBoundary = mhsBoundary;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return "MinerWarning{" + "id=" + id + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }

    public Integer getCheckTreshold()
    {
        return checkTreshold;
    }

    public void setCheckTreshold(Integer checkTreshold)
    {
        this.checkTreshold = checkTreshold;
    }

    public Integer getMissedChecks()
    {
        return missedChecks;
    }

    public void setMissedChecks(Integer missedChecks)
    {
        this.missedChecks = missedChecks;
    }
}
