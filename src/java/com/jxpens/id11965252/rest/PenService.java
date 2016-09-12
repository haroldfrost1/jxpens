package com.jxpens.id11965252.rest;

import com.jxpens.id11965252.dbhelper.PenDAO;
import com.jxpens.id11965252.exception.DataStoreException;
import com.jxpens.id11965252.model.Pen;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * A RESTful service class that provides data manipulation for Pen
 * 
 * @author Shaoxi He 11965252
 */
@Stateless
@Path("/pens")
public class PenService {

    @Context
    private ServletContext context;

    /**
     * Retrieves a single pen from the database
     * and output it into XML format with defined mapping
     * @param id
     * @return
     * @throws DataStoreException 
     */
    @Path("search")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Pen findPen(@QueryParam("id") int id) throws DataStoreException{
        return new PenDAO().findPen(id);
    }
    
    /**
     * Retrieves a list of all pens from the database
     * and outputs them into XML format with defined mapping
     * @return
     * @throws DataStoreException 
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Pen> findAll() throws DataStoreException{
        return new PenDAO().findAll();
    }
}
