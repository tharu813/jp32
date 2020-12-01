/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

import com.jp32.core.DBManager;
import com.mysql.cj.protocol.Resultset;
import javax.swing.JOptionPane;

/**
 *
 * @author THARUSHI
 */
public class AdminRegistrationController {

    /**
     *
     * @param fname
     * @param lname
     * @param userid
     * @param faculty
     * @param position
     * @param contact
     * @param uname
     * @param password
     */
    public static void registerUser(String fname, String lname, String userid, String faculty, String position, String contact, String uname, String password, String usertype) {

        int res;
        boolean status = false;
        String[] columns = {"FirstName", "LastName", "MemberID", "Faculty", "post", "ContactNumber", "username", "password", "userType"};
        String[] values = {fname, lname, userid, faculty, position, contact, uname, password, usertype};

        res = DBManager.insertRecord("AdminCommitteeMember", columns, values);

        if(res != 0){
            System.out.println("Record added successfully");
            status = true;
            JOptionPane.showMessageDialog(null, "Registered Successfully");
            
        }
    }

}
