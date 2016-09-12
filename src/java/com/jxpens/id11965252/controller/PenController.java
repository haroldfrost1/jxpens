package com.jxpens.id11965252.controller;

import com.jxpens.id11965252.dbhelper.PenDAO;
import com.jxpens.id11965252.exception.DataStoreException;
import com.jxpens.id11965252.model.Pen;
import java.io.Serializable;
import java.sql.SQLException;
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
     * @throws com.jxpens.id11965252.exception.DataStoreException
     */
    public String saveNewPen() throws DataStoreException {
        new PenDAO().createPen(pen);
        return "penlist?faces-redirect=true";
    }

    /**
     * Update the record in the database whose database id matches that of the current pen.
     * @return a redirect to view the whole pen list
     * @throws com.jxpens.id11965252.exception.DataStoreException
     */
    public String updatePen() throws DataStoreException {
        new PenDAO().updatePen(pen);
        return "penlist?faces-redirect=true";
    }

    /**
     * Delete the record from the database that matches the current pen's database id.
     * @return a redirect to view the whole pen list
     * @throws com.jxpens.id11965252.exception.DataStoreException
     */
    public String delete() throws DataStoreException {
        new PenDAO().deletePen(pen);
        return "penlist?faces-redirect=true";
    }

    /**
     * Load the details of a pen from the database.
     * @param index the unique database id of the pen to retrieve
     * @throws com.jxpens.id11965252.exception.DataStoreException
     */
    public void loadPen(int index) throws DataStoreException  {
        this.pen = new PenDAO().findPen(index);
    }

    /**
     * Returns a collection containing the entire pen list database.
     * @return 
     * @throws com.jxpens.id11965252.exception.DataStoreException 
     */
    public ArrayList<Pen> getAllPens() throws DataStoreException {
        return new PenDAO().findAll();
    }
}
