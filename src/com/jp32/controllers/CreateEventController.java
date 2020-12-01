/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

import com.jp32.core.DBManager;
import javax.swing.JOptionPane;

/**
 *
 * @author THARUSHI
 */
public class CreateEventController {
    
    /**
     *
     * @param eventname
     * @param venue
     * @param eventdate
     * @param eventtype
     * @param eventtime
     */
    public static void createEvent(String eventname, String venue, String eventdate, String eventtype, String eventtime){
        
        int res;
        boolean status;
        String[] columns = {"EventName", "Venue", "EventDate", "EventType", "EventTime"};
        String[] values = {eventname, venue, eventdate, eventtype, eventtime};        
        res = DBManager.insertRecord("nsbmevent", columns, values);
        
        if(res != 0){
            status = true;
            System.out.println("Event Created Successfully");
            JOptionPane.showMessageDialog(null, "Event created Successfully");
            
        }
        
    }
}
