/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

import com.jp32.core.DBManager;
import com.jp32.models.StUser;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Disura
 */
public class StudentMyClubsController {

    StUser student;
    ArrayList<String[]> allMyClubs = new ArrayList<>();

    public StudentMyClubsController() {
    }
    
    public void initialize (StUser student){
        this.student = student;
        setMyAllClubs();
    }

    private void setMyAllClubs() {
        String[] columns = {"studentid"};
        String[] values = {student.getUserid()};
        ResultSet res = DBManager.fetchByColumns("membership", columns, values);
        ArrayList<String> clubIds = new ArrayList<>();
        try {
            while (res.next()) {
                clubIds.add(res.getString("clubid"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentMyClubsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!clubIds.isEmpty()) {
            ResultSet clubs;
            for (String clubId : clubIds) {
                clubs = DBManager.fetchByID("club", "clubid", clubId);
                try {
                    if (clubs.next()) {
                        String[] clubArray = {clubId, clubs.getString("clubname")};
                        allMyClubs.add(clubArray);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StudentMyClubsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<String[]> getAllMyClubs() {
        for (String[] club : allMyClubs) {
            System.out.println(club[0] + ":" + club[1]);
        }
        return this.allMyClubs;
    }

}
