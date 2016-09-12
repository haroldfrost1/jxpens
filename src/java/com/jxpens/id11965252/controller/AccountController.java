package com.jxpens.id11965252.controller;

import com.jxpens.id11965252.dbhelper.AccountDAO;
import com.jxpens.id11965252.exception.DataStoreException;
import com.jxpens.id11965252.model.Account;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import com.jxpens.id11965252.util.EncryptionUtil;
import java.security.NoSuchAlgorithmException;

/**
 * A backing bean Handles Account information manipulation
 * Provides function to register
 *
 * @author Shaoxi He 11965252
 */
@Named
@RequestScoped
public class AccountController implements Serializable {

    private Account account = new Account();

    /**
     * the current user that is logged in
     *
     * @return
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Adds a message to the current faces context, so that it will appear in a
     * h:messages element.
     *
     * @param message the text of the error message to show the user
     */
    private void showError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("form-rego:regofail", new FacesMessage(message));
    }
    
    /**
     * Create a new record of user account in the database
     * @return an outcome to direct the user the success registration
     * @throws an exception upon failure of registration because of duplicate username
     */
    public String registerNewAccount() throws NoSuchAlgorithmException{
        try{
            // Convert username to lowercase, in order to make it non-case-sensitive
            account.setUsername(account.getUsername().toLowerCase());
            
            // Encryp password with EncryptionUtil
            account.setPassword(EncryptionUtil.hash256(account.getPassword()));
            
            new AccountDAO().register(this.account);
            return "rego-success";
            
        }catch(DataStoreException e){
            showError("Username already exists.");
            e.printStackTrace();
            return null;
        }      
    }
}
