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
package org.obozek.minermonitor.service;

import java.io.Serializable;
import org.obozek.minermonitor.entities.UserRole;
import org.obozek.minermonitor.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
@Transactional
public class UserRoleService implements Serializable
{

    @Autowired
    private UserRoleRepository repository;
    private static final String DEFAULT_USER_ROLE_NAME = "freeUser";

    public UserRole getDefaultUserRole()
    {
        UserRole defaultRole = repository.getByRoleName(DEFAULT_USER_ROLE_NAME);
        if (defaultRole == null) {
            defaultRole = createDefaultRole();
        }
        return defaultRole;
    }

    private UserRole createDefaultRole()
    {
        UserRole defaultRole = new UserRole();
        defaultRole.setRoleName(DEFAULT_USER_ROLE_NAME);
        return repository.save(defaultRole);
    }
}
