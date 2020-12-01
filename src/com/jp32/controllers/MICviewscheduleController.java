/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

import com.jp32.core.DBManager;
import com.jp32.models.MICUser;
import com.jp32.models.StUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dilu
 */
public class MICviewscheduleController {

    private static String ClubName;
    private static String ClubId;

    public void initialize(String ClubName) {
        this.ClubName = ClubName;
    }

    public ResultSet viewschedule() {
        try {
            String[] columns = {"ClubName"};
            String[] values = {ClubName};
            ResultSet res = DBManager.fetchByColumns("club", columns, values);
            if (res.next()) {
                ClubId = res.getString("ClubID");
            }

            ResultSet resPractise = DBManager.fetchByID("practice", "clubid", ClubId);

            return resPractise;

        } catch (SQLException ex) {
            Logger.getLogger(MICviewscheduleController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
