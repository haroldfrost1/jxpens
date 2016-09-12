/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jxpens.id11965252.dbhelper;

import com.jxpens.id11965252.exception.DataStoreException;
import com.jxpens.id11965252.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * A data access object to access data in the account table
 * @author harold
 */
public class AccountDAO {
    
    private static final String JNDI_NAME = "jdbc/aip";
    private static final String ACCOUNT_REGISTER = "INSERT INTO account(username,password) VALUES(?,?)";
    
    /**
     * Creates a new record of account in the database
     * 
     * @param account passed from backing bean
     * @throws DataStoreException 
     */
    public void register(Account account) throws DataStoreException{
        try{
            DataSource dataSource = InitialContext.doLookup(JNDI_NAME);
            
            try(Connection conn = dataSource.getConnection();
                    PreparedStatement ps = conn.prepareStatement(ACCOUNT_REGISTER)){
                
                ps.setString(1, account.getUsername());
                ps.setString(2, account.getPassword());
                
                int rowsInserted = ps.executeUpdate();
                
                if (1!=rowsInserted){
                    throw new DataStoreException("Username already exists.");
                }
            }
            
        }catch(SQLException | NamingException e){
            throw new DataStoreException(e);
        }
    }
}
