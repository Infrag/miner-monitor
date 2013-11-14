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
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ondrej.Bozek
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long, PageFilter>
{

    User getUserByEmail(String email);
}
