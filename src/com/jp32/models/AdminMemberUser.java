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
public abstract class AdminMemberUser extends User {
    
    public AdminMemberUser(String userid, String username, String password, String firstName, String lastName, String faculty, short userType, String post, int contactdt, String repassword) {
        super(userid, username, password, firstName, lastName, faculty, userType, post, contactdt, repassword);
    }
    
    
    
    
}
