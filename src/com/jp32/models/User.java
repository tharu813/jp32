/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp32.models;

/**
 *
 * @author THARUSHI
 */
public abstract class User {
    private String userid;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String faculty;
    private short usertype;
    private String post;
    private int contactnumber;
    
    
    public User(String userid, String username, String password, String firstName, String lastName, String faculty, short userType, String post, int contactdt){
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.usertype = userType;
        this.post = post;
        this.contactnumber = contactdt;
    }
    public String getUserid(){
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public short getUsertype() {
        return usertype;
    }
    
    public String getPost() {
        return post;
    }
    
    public int getContactnum() {
        return contactnumber;
    }
}
