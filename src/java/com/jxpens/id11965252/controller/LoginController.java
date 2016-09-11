/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jxpens.id11965252.controller;

import com.jxpens.id11965252.model.Account;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * A Backing bean handles user Login and Logout
 *
 * @author harold
 */
@Named
@RequestScoped
public class LoginController {

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
     * Attempt to log in using the username/password properties set by JSF. Uses
     * the container-managed authentication to perform the password check.
     *
     * @return an outcome corresponding to a secure welcome page, null if the
     * login failed
     */
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(this.account.getUsername(), this.account.getPassword());
//            HttpSession session = request.getSession();
//            session.setAttribute("username", this.account.getUsername());
            return "/welcome?faces-redirect=true";

        } catch (ServletException e) {
            showError("Incorrect username or password.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Logs out the current user of the container-managed authentication.
     *
     * @return an outcome corresponding to the login page
     * @throws ServletException if there is no currently logged in user
     */
    public String logout() throws ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.logout();
        return "/login?faces-redirect=true";
    }

    /**
     * Retrieves the username logged in the Server, returns null if no user
     * is logged in
     * @return the username logged in the server
     */
    public String getLoggedUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        return request.getRemoteUser();
    }

    /**
     * Adds a message to the current faces context, so that it will appear in a
     * h:messages element.
     *
     * @param message the text of the error message to show the user
     */
    private void showError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

}
