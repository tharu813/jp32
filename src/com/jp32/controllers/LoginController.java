/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

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

    public static void loginUser(String username, String password) {
        ResultSet res;
        String[] columns = {"username", "password"};
        String[] values = {username, password};
        res = DBManager.fetchRecordByValues("AdminCommitteeMember", columns, values);
        try {
            if (res.next()) {
                User user;
                int userType = res.getInt("usertype");
                String firstName = res.getString("firstname");
                String lastName = res.getString("lastname");
                switch (userType) {
                    case 1:
                        user = new HOAUser(username, password, firstName, lastName);
                        break;
                    default:
                        user = null;
                }
                if (user != null) {
                    System.out.println("Welcome " + user.getFirstName() + "!");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
