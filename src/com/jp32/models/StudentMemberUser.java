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
public class StudentMemberUser extends User {
    
    private String degreep;
    private boolean repstatus;
    
    public StudentMemberUser(String userid, String username, String password, String firstName, String lastName, String faculty, short userType, String post, int contactdt, String dp, boolean rpstatus) {
        super(userid, username, password, firstName, lastName, faculty, userType, post, contactdt);
        this. degreep = dp;
        this. repstatus = rpstatus;
    }
    

}
