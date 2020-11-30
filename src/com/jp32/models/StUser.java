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
public class StUser extends User {

    private String degreep;
    private String repstatus;

    public StUser(String userid, String username, String password, String firstName, String lastName, String faculty, String userType, String post, String contactdt, String repassword, String dp, String repStatus) {
        super(userid, username, password, firstName, lastName, faculty, userType, post, contactdt, repassword);
       this.degreep =  dp;
       this.repstatus = repStatus;
    }

   

   

}
