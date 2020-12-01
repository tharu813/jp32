/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

import com.jp32.core.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilu
 */
public class StSignUpController {
    public boolean checkUsername(String username){
        ResultSet res;
        String idCol ="username";
        String id=username;
         boolean checkUser = false;
        res = DBManager.fetchByID("studentmember",idCol, id);
        try {
             
            if(res.next())
            {
                checkUser = true;
            }
            else {
                
            }   
            } catch (SQLException ex) {
            Logger.getLogger(StSignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;
        }
       
        
        public static boolean addRecords(String userid, String firstName, String lastName, String faculty, String dp, String username, String password, String userType, String rpstatus, String post, String contactdt){
            //String para=username;
            boolean status = false;
            StSignUpController check = new StSignUpController();
            if(check.checkUsername(username) != true){
                int res;
                
                String[] columns={"MemberID","username","password","FirstName","LastName","Faculty","UserType","Post","ContactNumber","DegreeProgramme","RepStatus"};
                String[] values={userid,username,password,firstName,lastName,faculty,userType,post,contactdt,dp,rpstatus};
                //String[] columns={"username","password","FirstName","LastName","Faculty","UserType","Post","ContactNumber","DegreeProgramme","RepStatus"};
                //String[] values={username,password,firstName,lastName,faculty,userType,post,contactdt,dp,rpstatus};
                res = DBManager.insertRecord("studentmember",columns,values);
                if(res != 0)
                {
                    status = true;
                     JOptionPane.showMessageDialog(null, "Registered Successfully");
                }
             
            } else {
                status = false;
                JOptionPane.showMessageDialog(null, "Registered Successfully");
            }
            return status;
            
    /*private Object MyConnection;
    
    public boolean checkUsername(String username)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `the_app_users` WHERE `u_uname` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;*/
    }

    
}
