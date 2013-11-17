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
package org.obozek.minermonitor.view;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.service.MinerService;
import static org.obozek.minermonitor.view.Navigation.MINER_DETAIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ondrej.Bozek
 */
@URLMappings(mappings = {
    @URLMapping(id = MINER_DETAIL, viewId = "/view/auth/minerDetail.xhtml",
            pattern = "/auth/miner-detail-#{minerId : minerDetail.minerId}")})
@Component
@Scope("view")
public class MinerDetail {

    @Autowired
    private MinerService minerService;
    private Long minerId;
    private Miner miner;

    private Boolean edit = false;

    @URLAction
    public void init() {
        miner = minerService.getMiner(minerId);
    }

    public String save() {
        miner = minerService.saveMiner(miner);
        return toggleEdit();
    }

    public String cancel() {
        miner = minerService.getMiner(minerId);
        return toggleEdit();
    }

    public String toggleEdit() {
        edit = !edit;
        return null;
    }

    public Long getMinerId() {
        return minerId;
    }

    public void setMinerId(Long minerId) {
        this.minerId = minerId;
    }

    public Miner getMiner() {
        return miner;
    }

    public void setMiner(Miner miner) {
        this.miner = miner;
    }

    public Boolean isEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

}
