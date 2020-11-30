/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;
//test
//test2

import com.jp32.core.DBManager;
import com.jp32.models.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THARUSHI
 */
public class LoginController {

    public static User loginUser(String username, String password) {
        ResultSet res;
        String[] columns = {"username", "password"};
        String[] values = {username, password};
        boolean isAdminCommitteeMember = false;
        res = DBManager.fetchByColumns("AdminCommitteeMember", columns, values);
        if (res != null) {
            isAdminCommitteeMember = true;
        } else {
            res = DBManager.fetchByColumns("StudentMember", columns, values);
        }
        if (res != null) {
            // now we have a user
            User user = null;
            try {
                String userid = res.getString("memberid");
                String firstName = res.getString("firstname");
                String lastName = res.getString("lastname");
                String faculty = res.getString("faculty");
                String usertype = res.getString("usertype");
                String post = res.getString("post");
                String contactnumber = res.getString("contactnumber");
                String repassword = res.getString("password");
                
                if (isAdminCommitteeMember) {
                    switch (usertype) {
                        case "1":
                            user : new HOAUser(userid, username, password, firstName, lastName, faculty, usertype, post, contactnumber, repassword);
                            break;
                        case "2":
                            user = new MICUser (userid, username, password, firstName, lastName, faculty, usertype, post, contactnumber, repassword);
                            break;
                        default:
                            user = null;
                    }
                } else {
                    String degreep = res.getString("degreeprogramme");
                    String repstatus = res.getString("repstatus");
                    switch (usertype) {
                        case "3":
                            user = new StudentMemberUser(userid, username, password, firstName, lastName, faculty, usertype, post, contactnumber, repassword, degreep, repstatus);
                            break;
                        case "4":
                            user = new StudentRepUser(userid, username, password, firstName, lastName, faculty, usertype, post, contactnumber, repassword, degreep, repstatus);
                            break;
                        default:
                            user = null;
                    }
                }
                System.out.println("Welcome "+user.getFirstName()+"!");
                return user;
                

            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

        }
        return null;
    }
}
