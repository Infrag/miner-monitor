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

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.obozek.minermonitor.entities.Miner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Ondrej.Bozek
 */
@URLMappings(mappings = {
    @URLMapping(id = "MinerDetail", viewId = "/view/auth/minerDetail.xhtml", pattern = "/miner-detail-#{minerId : minerDetail.minerId}"),
    @URLMapping(id = "AddMiner", viewId = "/view/auth/minerDetail.xhtml", pattern = "/add-miner")})
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MinerDetail {

    private Long minerId;
    private Miner miner;

    public Long getMinerId() {
        return minerId;
    }

    public void setMinerId(Long minerId) {
        this.minerId = minerId;
    }

}
