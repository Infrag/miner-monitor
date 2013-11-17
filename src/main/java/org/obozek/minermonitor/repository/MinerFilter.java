/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.repository;

import org.obozek.filterlib.PageFilter;

/**
 *
 * @author infragile
 */
public class MinerFilter extends PageFilter {

    private String user_email;

    public MinerFilter(int page, int size) {
        super(page, size);
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

}
