package com.ekit.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Extends AbstractAuthenticationToken
 */
public class DBAuthenticationToken extends AbstractAuthenticationToken {
    private String username;
    private String password;
    private String site;
    private String domain;
    private int userID;

    /**
     * Constructor
     * 
     * @param username
     * @param password
     * @param site
     * @param domain
     */
    public DBAuthenticationToken(String username, String password, String site, String domain) {
	super(null);
	this.username = username;
	this.password = password;
	this.site = site;
	this.domain = domain;
    }

    /**
     * Constructor
     * 
     * @param authorities
     * @param username
     * @param password
     * @param site
     * @param domain
     * @param userID
     */
    public DBAuthenticationToken(Collection<GrantedAuthority> authorities, String username,
	    String password, String site, String domain, int userID) {
	super(authorities);
	this.username = username;
	this.password = password;
	this.site = site;
	this.domain = domain;
	this.userID = userID;
	setAuthenticated(true);
    }

    /**
     * Retrieves username
     * 
     * @return username
     */
    public String getUsername() {
	return username;
    }

    /**
     * Sets username
     * 
     * @param username
     */
    public void setUsername(String username) {
	this.username = username;
    }

    /**
     * Retrieves password
     * 
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * Sets password
     * 
     * @param password
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Retrieves site
     * 
     * @return site
     */
    public String getSite() {
	return site;
    }

    /**
     * Sets site
     * 
     * @param site
     */
    public void setSite(String site) {
	this.site = site;
    }

    /**
     * Retrieves domain
     * 
     * @return the domain
     */
    public String getDomain() {
	return domain;
    }

    /**
     * Sets domain
     * 
     * @param domain
     */
    public void setDomain(String domain) {
	this.domain = domain;
    }

    /**
     * Retrieves userID
     * 
     * @return userID
     */
    public int getUserID() {
	return userID;
    }

    /**
     * Sets userID
     * 
     * @param userID
     */
    public void setUserID(int userID) {
	this.userID = userID;
    }

    /**
     * The credentials that prove the principal is correct. This is usually a
     * password, but could be anything relevant to the AuthenticationManager.
     * Callers are expected to populate the credentials.
     * 
     * @return null
     */
    public Object getCredentials() {
	return null;
    }

    /**
     * The identity of the principal being authenticated. In the case of an
     * authentication request with username and password, this would be the
     * username. Callers are expected to populate the principal for an
     * authentication request.
     * 
     * The AuthenticationManager implementation will often return an
     * Authentication containing richer information as the principal for use by
     * the application. Many of the authentication providers will create a
     * UserDetails object as the principal.
     * 
     * @return the Principal being authenticated or the authenticated principal
     *         after authentication.
     */
    public Object getPrincipal() {
	return userID;
    }
}
