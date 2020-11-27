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
    public AdminMemberUser(String username, String password, String firstName, String lastName){
        super(username, password, firstName, lastName);
    }
    
}
