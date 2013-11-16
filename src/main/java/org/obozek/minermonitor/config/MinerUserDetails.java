/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.config;

import java.util.ArrayList;
import java.util.Collection;
import org.obozek.minermonitor.entities.User;
import org.obozek.minermonitor.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author infragile
 */
public class MinerUserDetails implements UserDetails {

    private User user;
    private Collection<SimpleGrantedAuthority> grantedAuthorities = null;

    public MinerUserDetails(User user) {
        this.user = user;
        grantedAuthorities = new ArrayList<>();
        for (UserRole role : user.getUserRoles()) {
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role.getRoleName());
            grantedAuthorities.add(sga);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getVerified();
    }

    public User getUser() {
        return user;
    }

}
