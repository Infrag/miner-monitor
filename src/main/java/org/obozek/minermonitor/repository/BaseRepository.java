/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.repository;

import java.io.Serializable;
import org.obozek.filterlib.FilteringRepository;
import org.obozek.filterlib.PageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ondrej.Bozek
 */
public interface BaseRepository<T, ID extends Serializable, Q extends PageFilter>
        extends JpaRepository<T, ID>, FilteringRepository<T, Q, Page<T>>
{
}
