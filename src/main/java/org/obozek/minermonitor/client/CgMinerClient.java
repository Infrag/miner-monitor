/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.client;

import org.obozek.minermonitor.client.dto.CgMinerQueryDTO;
import org.obozek.minermonitor.client.dto.CgMinerResponse;

/**
 *
 * @author Ondrej.Bozek
 */
public interface CgMinerClient {

    public <T extends CgMinerResponse> T queryCgMiner(String host, int port, CgMinerQueryDTO<T> command);
}
