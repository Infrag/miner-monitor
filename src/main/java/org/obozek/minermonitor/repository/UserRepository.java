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
package org.obozek.minermonitor.repository;

import org.obozek.filterlib.PageFilter;
import org.obozek.minermonitor.entities.User;

/**
 *
 * @author Ondrej.Bozek
 */
public interface UserRepository extends BaseRepository<User, Long, PageFilter>
{

    User findByEmail(String email);
}
