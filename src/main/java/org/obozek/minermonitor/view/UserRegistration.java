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
package org.obozek.minermonitor.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.obozek.minermonitor.entities.User;
import org.obozek.minermonitor.service.UserService;
import static org.obozek.minermonitor.view.Navigation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Ondrej.Bozek
 */
@URLMapping(id = "Register", viewId = "/view/register.xhtml", pattern = "/register")
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class UserRegistration {

    @Autowired
    private UserService userService;
    private User user = new User();

    public String register() {
        user = userService.registerUser(user);
        userService.verifyUser(user.getEmail(), null);
        return getPretty(MINER_MANAGEMENT);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
