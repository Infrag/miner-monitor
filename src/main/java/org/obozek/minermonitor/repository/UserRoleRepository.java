/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.repository;

import org.obozek.filterlib.PageFilter;
import org.obozek.minermonitor.entities.UserRole;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ondrej.Bozek
 */
@Repository
public interface UserRoleRepository extends BaseRepository<UserRole, Long, PageFilter>
{

    UserRole getByRoleName(String roleName);
}
