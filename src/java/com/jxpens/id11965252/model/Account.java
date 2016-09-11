package com.jxpens.id11965252.model;

import java.io.Serializable;

/**
 * User (Data Transfer Object or Model)
 * Each User will have a unique username and a password
 * @author Shaoxi He 11965252
 */
public class Account implements Serializable{
    
    private String username;
    private String password;

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
