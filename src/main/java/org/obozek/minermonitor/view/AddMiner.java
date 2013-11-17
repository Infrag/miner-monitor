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
package org.obozek.minermonitor.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import javax.annotation.PostConstruct;
import org.obozek.minermonitor.config.SecurityContextHelper;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.service.MinerService;
import static org.obozek.minermonitor.view.Navigation.ADD_NEW_MINER;
import static org.obozek.minermonitor.view.Navigation.MINER_MANAGEMENT;
import static org.obozek.minermonitor.view.Navigation.getPretty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author infragile
 */
@URLMapping(id = ADD_NEW_MINER, viewId = "/view/auth/addMiner.xhtml",
        pattern = "/auth/add-miner")
@Component
@Scope("view")
public class AddMiner {

    @Autowired
    private MinerService minerService;
    @Autowired
    private SecurityContextHelper securityContextHelper;
    private Miner miner = new Miner();
    private static final Long DEAD_CHECK_INTERVAL = 120000L;

    @PostConstruct
    public void init() {
        miner.setUser(securityContextHelper.getUser());
        miner.setAlive(Boolean.FALSE);
        miner.setDeadCheckIntervalMs(DEAD_CHECK_INTERVAL);
    }

    public String addMiner() {
        minerService.saveMiner(miner);
        return getPretty(MINER_MANAGEMENT);
    }

    public Miner getMiner() {
        return miner;
    }

    public void setMiner(Miner miner) {
        this.miner = miner;
    }

}
