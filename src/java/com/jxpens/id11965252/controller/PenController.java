package com.jxpens.id11965252.controller;

import com.jxpens.id11965252.dbhelper.PenDAO;
import com.jxpens.id11965252.exception.DataStoreException;
import com.jxpens.id11965252.model.Pen;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * A backing bean for the pen list JSF view
 *
 * @author Shaoxi He 11965252
 */
@Named
@RequestScoped
public class PenController implements Serializable {

    private Pen pen = new Pen();

    /**
     * the current pen object/model that this controller will manipulate
     * @return
     */
    public Pen getPen() {
        return pen;
    }

    /**
     * Save the current pen as a new record in the database.
     * @return a redirect to view the whole pen list
     */
    public String saveNewPen() {
        // TODO: link to database
        return "penlist?faces-redirect=true";
    }

    /**
     * Update the record in the database whose database id matches that of the current pen.
     * @return a redirect to view the whole pen list
     */
    public String updatePen() {
        // TODO: link to database
        return "penlist?faces-redirect=true";
    }

    /**
     * Delete the record from the database that matches the current pen's database id.
     * @return a redirect to view the whole pen list
     */
    public String delete() {
        // TODO: link to database
        return "penlist?faces-redirect=true";
    }

    /**
     * Load the details of a pen from the database.
     * @param index the unique database id of the pen to retrieve
     */
    public void loadPen(int index) {
        // TODO: link to databse
    }

    /**
     * Returns a collection containing the entire pen list database.
     * @return 
     */
    public ArrayList<Pen> getAllPens() throws DataStoreException {
        return new PenDAO().findAll();
    }
}
