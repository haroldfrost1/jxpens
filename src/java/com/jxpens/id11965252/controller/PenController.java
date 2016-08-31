package com.jxpens.id11965252.controller;

import com.jxpens.id11965252.model.Pen;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Handles CRUD operations of Pens
 * @author Shaoxi He 11965252
 */
@Named
@SessionScoped
public class PenController implements Serializable{

    /**
     * @return an ArrayList contains Pen objects
     */
    public ArrayList<Pen> getPens(){
        // TODO: link to database
        return null;
    }
    
}
