/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 15, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Ondrej.Bozek
 */
//@Order(1)
//@Configuration
//@EnableWebSecurity
public class MultiHttpSecurityConfig { //extends WebSecurityConfigurerAdapter {

    @Autowired
    private MonitorUserDetailsService userDetails;

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetails);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/javax.faces.resource/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/auth", "/auth/**", "/auth?").authenticated()
//                .antMatchers("/index", "/register","").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll();
//    }

}
