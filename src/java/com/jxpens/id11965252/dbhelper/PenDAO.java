package com.jxpens.id11965252.dbhelper;

import com.jxpens.id11965252.exception.DataStoreException;
import com.jxpens.id11965252.model.Pen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * A Data Access Object to access data in the Pen table
 *
 * @author Shaoxi He 11965252
 */
public class PenDAO {

    //------------------------ Configuration -----------------------------------
    private static final String JNDI_NAME = "jdbc/aip";
    private static final String SELECT_PEN = "SELECT id, pen_name, brand, nib_size, colour from pen ";
    private static final String PEN_ALL = SELECT_PEN;
    private static final String PEN_ID = SELECT_PEN + "where id = ?";
    private static final String PEN_INSERT = "INSERT INTO pen(pen_name,brand,nib_size,colour) VALUES(?, ?, ?, ?)";
    private static final String PEN_UPDATE = "UPDATE pen SET pen_name=?, brand=?, nib_size=?, colour=? where id=?";
    private static final String PEN_DELETE = "DELETE FROM pen where id=?";

    // ----------------------- Implementation ----------------------------------
    
    /**
     * Helper-method to create a Pen Model Object for a row of the database.
     *
     * @param rs the ResultSet from which to retrieve the attributes for the
     * Model
     * @return a Model corresponding to the current row of the ResultSet
     * @throws SQLException
     */
    private Pen createRowModel(ResultSet rs) throws SQLException {
        Pen result = new Pen();
        result.setId(rs.getInt("id"));
        result.setName(rs.getString("pen_name"));
        result.setBrand(rs.getString("brand"));
        result.setNibSize(rs.getDouble("nib_size"));
        result.setColour(rs.getString("colour"));
        return result;
    }

    /**
     * Retrieves all pens from the database as a complete list of Model Objects.
     *
     * @return a list containing every row of the database
     * @throws DataStoreException if an exception occurred while communicating
     * with the database.
     */
    public ArrayList<Pen> findAll() throws DataStoreException {
        ArrayList<Pen> results = new ArrayList<>();

        try {
            DataSource dataSource = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = dataSource.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(PEN_ALL)) {

                while (rs.next()) {
                    results.add(createRowModel(rs));
                }
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }

        return results;
    }
    
    /**
     * Creates a row to hold the data of a pen in the database, 
     * with a pen Data Transfer Object
     * @param pen needed to be passed in from the controller
     * @throws com.jxpens.id11965252.exception.DataStoreException
     */
    public void createPen(Pen pen) throws DataStoreException{
        try{
            DataSource dataSource = InitialContext.doLookup(JNDI_NAME);
            
            try(Connection conn = dataSource.getConnection();
                    PreparedStatement ps = conn.prepareStatement(PEN_INSERT)){
                
                ps.setString(1, pen.getName());
                ps.setString(2, pen.getBrand());
                ps.setDouble(3, pen.getNibSize());
                ps.setString(4, pen.getColour());
                
                int rowsInserted = ps.executeUpdate();
                
                if (1!=rowsInserted){
                    throw new DataStoreException("Failed to insert a pen.");
                }
            }
            
        }catch(SQLException | NamingException e){
            throw new DataStoreException(e);
        }
    }
    
    /**
     * Updates the data of a pen in the database, 
     * with a pen Data Transfer Object
     * @param pen needed to be passed in from the controller
     * @throws com.jxpens.id11965252.exception.DataStoreException
     */
    public void updatePen(Pen pen) throws DataStoreException{
        try{
            DataSource dataSource = InitialContext.doLookup(JNDI_NAME);
            
            try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(PEN_UPDATE)){
                
                ps.setString(1, pen.getName());
                ps.setString(2, pen.getBrand());
                ps.setDouble(3, pen.getNibSize());
                ps.setString(4, pen.getColour());
                ps.setInt(5, pen.getId());
                
                int rowsUpdated = ps.executeUpdate();
                
                System.out.println(pen.getId());
                
                if (1!=rowsUpdated){
                    throw new DataStoreException("Failed to update pen.");
                }
            }
            
        }catch(SQLException | NamingException e){
            throw new DataStoreException(e);
        }
    }

    /**
     * Retrieves a single pen in the database, corresponding to a given id.
     *
     * @return a Data Transfer Object corresponding to the username, or null if
     * no matching user was found
     * @throws DataStoreException if an exception occurred while communicating
     * with the database.
     */
    public Pen findPen(int id) throws DataStoreException {
        try {
            DataSource dataSource = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = dataSource.getConnection();
                    PreparedStatement ps = conn.prepareStatement(PEN_ID)) {

                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // pen found
                        return createRowModel(rs);
                    } else {
                        // pen not found
                        return null;
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
    }
    
    /**
     * Delete a record of a pen from the database
     * with a pen Data transfer object
     * @param pen needed to be passed in from the penController
     * @throws DataStoreException 
     */
    public void deletePen(Pen pen) throws DataStoreException{
        try{
            DataSource dataSource = InitialContext.doLookup(JNDI_NAME);
            
            try(Connection conn = dataSource.getConnection();
                    PreparedStatement ps = conn.prepareStatement(PEN_DELETE)){
                
                ps.setInt(1, pen.getId());
                
                int rowsUpdated = ps.executeUpdate();
                
                if (1!=rowsUpdated){
                    throw new DataStoreException("Failed to delete pen.");
                }
            }
            
        }catch(SQLException | NamingException e){
            throw new DataStoreException(e);
        }
    }
}
