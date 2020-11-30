/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.models;

/**
 *
 * @author THARUSHI
 */
public class StUser extends User{
    
    private String degreep;
    private boolean repstatus;

    public StUser(String userid, String username, String password, String firstName, String lastName, String faculty, short userType, String post, int contactdt, String repassword, String dp, boolean rpstatus) {
        super(userid, username, password, firstName, lastName, faculty, userType, post, contactdt, repassword);
        this. degreep = dp;
        this. repstatus = rpstatus;
    }
    
}
