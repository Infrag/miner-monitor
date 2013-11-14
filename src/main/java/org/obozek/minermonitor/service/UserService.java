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

import java.util.ArrayList;
import org.obozek.minermonitor.entities.User;
import org.obozek.minermonitor.entities.UserRole;
import org.obozek.minermonitor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
@Transactional
public class UserService
{

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserRoleService roleService;

    public User registerUser(User user)
    {
        user.setUserRoles(new ArrayList<UserRole>());
        // set default user role
        user.getUserRoles().add(roleService.getDefaultUserRole());
        return saveUser(user);
    }

    public User saveUser(User user)
    {
        return user;
    }

    public User getUser(String email)
    {
        return repository.getUserByEmail(email);
    }
}
