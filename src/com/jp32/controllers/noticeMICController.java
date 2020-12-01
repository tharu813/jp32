/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

import com.jp32.core.DBManager;
import com.jp32.models.StUser;
import java.sql.ResultSet;

/**
 *
 * @author Dilu
 */
public class noticeMICController {
    private StUser MIC;
    
    
    public void initialize (StUser MIC){
        this.MIC = MIC;
      }
    
    public static int addNotice(String notice){
           String idCol="NoticeContent";
           //String id=notice;
           String[] columns={idCol};
           String[] values={notice};
           int res;
           res = DBManager.insertRecord("notice",columns, values);
           return res;
          
      }

    public void addNotice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    

