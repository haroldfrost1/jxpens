package com.jxpens.id11965252.controller;

import com.jxpens.id11965252.model.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Handles login authentication
 * @author Shaoxi He 11965252
 */
@Named
@SessionScoped
public class UserController implements Serializable{

    private User user = new User();
    
    /**
     * @return the current user
     */
    public User getUser(){
        return user;
    }
    
    /**
     * Authenticate the user information
     * if user exists
     * @return the navigation to penlist
     * otherwise
     * @return the navigation to error page
     */
    public String authenticate(){
        return "penlist";
    }
    
}
