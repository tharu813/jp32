/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THARUSHI
 */
public class DBManager {
    
    private final String dbName = "jp32db";

    private static Connection createConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jp32db", "root", "root");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
    @param table - from which table we are reading
    @param idCol - column name for id
    @param id - value of id
    @returns - a single record where having the matching ID
    */
    public static ResultSet fetchRecordByID(String table, String idCol, int id){
        Connection con = createConnection();
        String queryString = "SELECT * FROM " + table + " WHERE " + idCol + " = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
    @param table - from which table we are reading
    @param columns[] - which columns are we matching values to
    @param values[] - values we are matching
    @returns - a set of records in which the matching values can be found
    */
    public static ResultSet fetchRecordByValues(String table, String[] columns, String[] values){
        Connection con = createConnection();
        String queryString = "SELECT * FROM " + table + " WHERE ";
        int i = 0; 
        while (i < columns.length){
            queryString += columns[i] + " = ? ";
            i++;
            if (i < columns.length) queryString += " AND ";
        }
        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            for (int j = 1; j <= values.length; j++){
                stmt.setString(j, values[j-1]);
            }
            ResultSet result = stmt.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
