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

import java.util.concurrent.ScheduledFuture;
import org.obozek.minermonitor.client.dto.CgMinerSummary;

/**
 *
 * @author infragile
 */
public class PeriodicMinerInfo {

    private final ScheduledFuture scheduledFuture;
    private CgMinerSummary lastSummary;

    public PeriodicMinerInfo(ScheduledFuture scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }

    public ScheduledFuture getScheduledFuture() {
        return scheduledFuture;
    }

    public CgMinerSummary getLastSummary() {
        return lastSummary;
    }

    public void setLastSummary(CgMinerSummary lastSummary) {
        this.lastSummary = lastSummary;
    }

}
