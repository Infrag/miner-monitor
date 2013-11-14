/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 14, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.service;

import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.repository.MinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
@Transactional
public class MinerService
{

    @Autowired
    private MinerRepository repository;
    
    public Miner saveMiner(Miner miner) {
        return repository.save(miner);
    }
}
