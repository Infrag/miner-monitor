/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.view;

import java.util.Map;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.model.LazyPaginationModel;
import org.obozek.minermonitor.repository.MinerFilter;
import org.obozek.minermonitor.service.MinerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 *
 * @author infragile
 */
public class LazyMinerDataModel extends LazyPaginationModel<Miner, MinerFilter> {

    private final MinerService MinerService;
    private final String userEmail;

    public LazyMinerDataModel(MinerService MinerService, String userEmail) {
        this.MinerService = MinerService;
        this.userEmail = userEmail;
    }

    @Override
    public Page<Miner> getPage(MinerFilter pageReguest) {
        return MinerService.findMiners(pageReguest);
    }

    @Override
    public MinerFilter createPageRequest(int page, int size, Sort sort, Map<String, String> filters) {
        MinerFilter mf = new MinerFilter(page, size);
        if (sort != null) {
            mf.setSort(sort);
        }
        mf.setUser_email(userEmail);
        return mf;
    }

}
