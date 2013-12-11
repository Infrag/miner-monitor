/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.obozek.minermonitor.config.SecurityContextHelper;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.entities.User;
import org.obozek.minermonitor.service.MinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author infragile
 */
@URLMapping(id = Navigation.MINER_MANAGEMENT, viewId = "/view/auth/index.xhtml", pattern = "/auth/")
@Component
@Scope("view")
public class MinerManagement implements Serializable {

    @Autowired
    private SecurityContextHelper securityContextHelper;
    @Autowired
    private MinerService minerService;
    private User user;
    private LazyMinerDataModel dataModel;

    @PostConstruct
    public void init() {
        user = securityContextHelper.getUser();
        dataModel = new LazyMinerDataModel(minerService, user.getEmail());
    }

    public String startMinerChecking(Miner miner) {
        // todo validate miner settings
        minerService.startMinerChecking(miner);
        return null;
    }

    public String stopMinerChecking(Miner miner) {
        // todo validate miner settings
        minerService.stopMinerChecking(miner);
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LazyMinerDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(LazyMinerDataModel dataModel) {
        this.dataModel = dataModel;
    }

}
