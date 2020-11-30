/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.controllers;

import com.jp32.core.DBManager;

/**
 *
 * @author THARUSHI
 */
public class CreateEventController {
    
    public void createEvent(String eventname, String venue, java.sql.Date eventdate, short eventtype, java.sql.Time eventtime){
        
        /*int res;
        String[] columns = {"EventName", "Venue", "EventDate", "EventType", "EventTime"};
        String[] values = {eventname, venue, eventdate, eventtype, eventtime};        
        res = DBManager.insertRecord("nsbmevent", columns, values);
        
        if(res != 0){
            System.out.println("Event Created Successfully");
        }
        */
    }
}
