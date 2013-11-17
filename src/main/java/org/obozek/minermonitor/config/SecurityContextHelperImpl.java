/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.config;

import org.obozek.minermonitor.entities.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author infragile
 */
@Service
public class SecurityContextHelperImpl implements SecurityContextHelper {

    @Override
    public SecurityContext getSecurityContext() {
        SecurityContext sc = SecurityContextHolder.getContext();
        return sc;
    }

    @Override
    public MinerUserDetails getUserDetails() {
        MinerUserDetails userDetails = null;
        SecurityContext sc = getSecurityContext();
        Authentication auth = sc.getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            userDetails = (MinerUserDetails) auth.getPrincipal();
        }
        return userDetails;
    }

    @Override
    public User getUser() {
        MinerUserDetails mud = getUserDetails();
        if (mud != null) {
            return mud.getUser();
        }
        return null;
    }
}
