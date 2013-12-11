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

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLBeanName;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.util.List;
import org.joda.time.DateTime;
import org.obozek.minermonitor.entities.Miner;
import org.obozek.minermonitor.entities.MinerSummary;
import org.obozek.minermonitor.service.MinerService;
import org.obozek.minermonitor.service.MinerSummaryService;
import static org.obozek.minermonitor.view.Navigation.MINER_STATS;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author infragile
 */
@URLMapping(id = MINER_STATS, viewId = "/view/auth/MinerStats.xhtml",
        pattern = "/auth/miner-statistics-#{minerId : minerStatistics.minerId}")
@Component
@Scope("view")
@URLBeanName("minerStatistics")
public class MinerStatistics {

    private Long minerId;
    private Miner miner;
    @Autowired
    private MinerService minerService;
    @Autowired
    private MinerSummaryService minerSummaryService;
    private final DateTime day;
    private final DateTime week;
    private final DateTime month;

    private List<MinerSummary> data;
    private CartesianChartModel linearModel;

    {
        DateTime now = new DateTime();
        day = now.minusDays(1);
        week = now.minusDays(7);
        month = now.minusMonths(1);
    }

    @URLAction
    public void init() {
        miner = minerService.getMiner(minerId);
        data = minerSummaryService.getSummariesFrom(week.toDate());

        linearModel = new CartesianChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("5s MHs");
        for (MinerSummary minerSummary : data) {
            boys.set(minerSummary.getTimeAcquired(), minerSummary.getMhs5s());
        }
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

    public List<MinerSummary> getData() {
        return data;
    }

    public void setData(List<MinerSummary> data) {
        this.data = data;
    }

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    public void setLinearModel(CartesianChartModel linearModel) {
        this.linearModel = linearModel;
    }

}
