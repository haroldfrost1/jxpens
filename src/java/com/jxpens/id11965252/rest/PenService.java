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
 *
 * @author Shaoxi He 11965252
 */
@Stateless
@Path("/pens")
public class PenService {

    @Context
    private ServletContext context;

    @Path("search")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Pen findPen(@QueryParam("id") int id) throws DataStoreException{
        return new PenDAO().findPen(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Pen> findAll() throws DataStoreException{
        return new PenDAO().findAll();
    }
}
