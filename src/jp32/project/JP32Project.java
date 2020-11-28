/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp32.project;

import com.jp32.core.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author THARUSHI
 */
public class JP32Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ResultSet res = DBManager.fetchByID("club", "ClubID", 1);
        while (res.next()) {
            System.out.println(res.getString(2));
        }
        String[] columns = {"username"};
        String[] values = {"kasunt"};
        res = DBManager.fetchByColumns("AdminCommitteeMember", columns, values);
        while (res.next()) {
            System.out.println(res.getString("faculty"));
        }
    }

}
