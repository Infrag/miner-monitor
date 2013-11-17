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
package org.obozek.minermonitor.client.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author infragile
 */
public class CgMinerResponse {

    private Long id;
    @SerializedName("STATUS")
    private List<StatusDTO> status;

    public CgMinerResponse() {
    }

    public CgMinerResponse(Long id, List<StatusDTO> status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CgMinerResponse other = (CgMinerResponse) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public List<StatusDTO> getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "CgMinerResponse{" + "id=" + id + '}';
    }

}
