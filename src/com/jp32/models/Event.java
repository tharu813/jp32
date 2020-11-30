/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.models;

import java.sql.Time;

/**
 *
 * @author THARUSHI
 */
public class Event {
    public int eventid;
    public String eventname;
    public String venue;
    public java.sql.Date eventdate;
    public short type;
    public Time time;
    
    public Event(){
        
    }
    
}
