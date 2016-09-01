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

    private Pen pen = new Pen();
    
    /**
     * @return the current pen object
     */
    public Pen getPen(){
        return pen;
    }
    
    public String saveNewPen(){
        // TODO: link to database
        return "penlist";
    }
    
    public String updatePen(){
        // TODO: link to database
        return "penlist";
    }
    
    public String deletePen(int index){
        // TODO: link to database
        return "penlist";
    }
    
    public void loadPen(int index){
        // TODO: link to databse
    }
    
    /**
     * @return an ArrayList contains Pen objects
     */
    public ArrayList<Pen> getPens(){
        // TODO: link to database
        return null;
    }
    
}
