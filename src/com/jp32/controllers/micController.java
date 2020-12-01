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
public class micController {

    private MICUser MIC;
    String clubN;
    
    public void initialize (MICUser MIC){
        this.MIC = MIC;
        addclubName();
    }
    /**
     *
     */
    public String addclubName() { 
        try {
            String idCol = "MasterInCharge";
            String id = MIC.getUserid();
            ResultSet res = DBManager.fetchByID("Club", idCol, id);
            while(res.next()){
                try { 
                    clubN = res.getString("ClubName");
                } catch (SQLException ex) {
                    Logger.getLogger(micController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(micController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clubN;
    }
    
        //res = DBManager.fetchByID("studentmember",idCol, id);
    
public String getAllMyClubs() throws SQLException{
    
    return this.addclubName();
}
    /*public void initialize(StUser MIC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
