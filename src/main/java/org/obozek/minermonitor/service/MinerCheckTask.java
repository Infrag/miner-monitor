/*
 * Copyright (C) 2013 infragile
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.obozek.minermonitor.service;

import org.obozek.minermonitor.client.dto.CgMinerResponse;
import org.obozek.minermonitor.client.dto.StatusState;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.entities.MinerCheck;
import org.obozek.minermonitor.entities.MinerWarning;

/**
 *
 * @author infragile
 */
public class MinerCheckTask implements Runnable {

    private Miner miner;
    private final CgMinerService service;
    private final MinerService minerService;

    public MinerCheckTask(Miner miner, CgMinerService service, MinerService minerService) {
        this.miner = miner;
        this.service = service;
        this.minerService = minerService;
    }

    @Override
    public void run() {
        for (MinerCheck minerCheck : miner.getMinerChecks()) {
            long startTime = System.currentTimeMillis();
            CgMinerResponse response = service.getResponse(miner.getHostName(), miner.getPort(), minerCheck.getCommand());
            long endTime = System.currentTimeMillis();
            minerService.saveResponse(response, miner, endTime - startTime);
            miner.setAlive(!StatusState.T.equals(response.getStatus().get(0).getStatus()));
            miner = minerService.saveMiner(miner);
            for (MinerWarning warning : minerCheck.getMinerWarnings()) {
                minerService.handleWarning(warning, response);
            }
        }
    }
}
