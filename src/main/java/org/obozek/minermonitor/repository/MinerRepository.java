/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.repository;

import java.util.List;
import org.obozek.filterlib.PageFilter;
import org.obozek.minermonitor.entities.Miner;

/**
 *
 * @author Ondrej.Bozek
 */
public interface MinerRepository extends BaseRepository<Miner, Long, PageFilter> {

    List<Miner> findStartedMiners();
}
