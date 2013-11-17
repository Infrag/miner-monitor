/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.config;

import org.obozek.minermonitor.entities.User;
import org.springframework.security.core.context.SecurityContext;

/**
 *
 * @author infragile
 */
public interface SecurityContextHelper {

    public SecurityContext getSecurityContext();

    public MinerUserDetails getUserDetails();

    public User getUser();
}
