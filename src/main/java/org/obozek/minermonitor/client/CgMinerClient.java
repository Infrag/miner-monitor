/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.client;

import org.obozek.minermonitor.client.dto.CgMinerQueryDTO;

/**
 *
 * @author Ondrej.Bozek
 */
public interface CgMinerClient
{

    public String queryCgMiner(String host, int port, CgMinerQueryDTO command);
}
