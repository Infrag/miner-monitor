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

/**
 *
 * @author infragile
 */
public class Navigation {

    public static final String PRETTY = "pretty:";
    public static final String MINER_DETAIL = "auth:MinerDetail",
            MINER_MANAGEMENT = "auth:Index",
            ADD_NEW_MINER = "auth:AddMiner",
            MINER_STATS = "auth:MinerStats",
            INDEX = "index";

    public static final String getPretty(String string) {
        return PRETTY + string;
    }

}
