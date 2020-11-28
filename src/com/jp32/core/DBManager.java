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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jp32db", "root", "");
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
    public static ResultSet fetchByID(String table, String idCol, String id) {
        Connection con = createConnection();
        String queryString = "SELECT * FROM " + table + " WHERE " + idCol + " = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            stmt.setString(1, id);
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
    public static ResultSet fetchByColumns(String table, String[] columns, String[] values) {
        Connection con = createConnection();
        String queryString = "SELECT * FROM " + table + " WHERE ";
        int i = 0;
        while (i < columns.length) {
            queryString += columns[i] + " = ? ";
            i++;
            if (i < columns.length) {
                queryString += " AND ";
            }
        }
        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            for (int j = 1; j <= values.length; j++) {
                stmt.setString(j, values[j - 1]);
            }
            ResultSet result = stmt.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
    @param table - from which table we are retrieving
    @returns - all rows of the table
    */
    public static ResultSet fetchAll(String table){
        Connection con = createConnection();
        String queryString = "SELECT * FROM " + table;
        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            ResultSet result = stmt.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
    @param table - which table we are considering
    @returns - count of all records
    */
    public static int getCountOfRecords(String table){
        Connection con = createConnection();
        String queryString = "SELECT COUNT(*) FROM " + table;
        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            ResultSet result = stmt.executeQuery();
            if(result.next()) return result.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /*
    @param table - to which table we are going to insert
    @param columns - which columns are we specifying
    @param values - values of columns
    (REMEMBER: DON'T GIVE ID COLUMN AND VALUE FOR WHICH AUTO-INCREMENT IS ENABLED)
    @returns - true if successfully inserted, false otherwise
     */
    public static boolean insertRecord(String table, String[] columns, String[] values) {
        Connection con = createConnection();
        String queryString = "INSERT INTO " + table + "(";
        int i = 0;
        while (i < columns.length) {
            queryString += columns[i];
            i++;
            if (i < columns.length) {
                queryString += ",";
            }
        }
        queryString += ") VALUES(";
        i = 0;
        while (i < columns.length) {
            queryString += "?";
            i++;
            if (i < columns.length) {
                queryString += ",";
            }
        }
        queryString += ")";

        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            for (i = 1; i <= values.length; i++) {
                stmt.setString(i, values[i - 1]);
            }
            return stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*
    @param table - in which table we are updating
    @param columns - which columns are we updating
    @param values - updating values
    @param idCol - column name for id 
    @param idVal - value of id
    @returns - true if successfully updated, false otherwise
    */
    public static boolean updateRecord(String table, String[] columns, String[] values, String idCol, String idVal) {
        Connection con = createConnection();
        String queryString = "UPDATE " + table + " SET ";
        int i = 0;
        while (i < columns.length) {
            queryString += columns[i] + " = ? ";
            i++;
            if (i < columns.length) {
                queryString += ",";
            }
        }
        
       queryString += " WHERE " + idCol + " = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(queryString);
            i = 0;
            while (i < values.length){
                stmt.setString(i+1, values[i]);
                i++;
            }
            stmt.setString(i+1, idVal);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
