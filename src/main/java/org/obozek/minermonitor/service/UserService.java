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
import java.util.Date;
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
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserRoleService roleService;

    public User registerUser(User user) {
        user.setUserRoles(new ArrayList<UserRole>());
        // set default user role
        user.getUserRoles().add(roleService.getDefaultUserRole());
        user.setVerified(Boolean.FALSE);
        user.setCreated(new Date());
        return saveUser(user);
    }

    public User verifyUser(String email, String verificationKey) {
        User user = getUser(email);
        user.setVerified(Boolean.TRUE);
        return saveUser(user);
    }

    public User saveUser(User user) {
        return repository.save(canonize(user));
    }

    @Transactional(readOnly = true)
    public User getUser(String email) {
        return repository.findByEmail(canonize(email));
    }

    // TODO canonization should be probably pushed to Repository layer
    private User canonize(User user) {
        user.setEmail(canonize(user.getEmail()));
        return user;
    }

    private String canonize(String string) {
        if (string != null) {
            return string.trim().toLowerCase();
        }
        return string;
    }

}
