package com.ekit.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ekit.security.data.User;

/**
 * Implements the AuthenticationProvider which can process specific
 * authentication
 */
public class DBAuthenticationProvider implements AuthenticationProvider {
    
    UserDetailsService userDetailsService;

    /**
     * Sets userDetailsService
     * 
     * @param userDetailsService
     */
    public void setUserDetailsService(UserDetailsService userDetailsService) {
	this.userDetailsService = userDetailsService;
    }

    /**
     * Returns true if this AuthenticationProvider supports the indicated
     * Authentication object. Returning true does not guarantee an
     * AuthenticationProvider will be able to authenticate the presented
     * instance of the Authentication class. It simply indicates it can support
     * closer evaluation of it. An AuthenticationProvider can still return null
     * from the authenticate(Authentication) method to indicate another
     * AuthenticationProvider should be tried. Selection of an
     * AuthenticationProvider capable of performing authentication is conducted
     * at runtime the ProviderManager.
     * 
     * @param authentication
     * @return true if the implementation can more closely evaluate the
     *         Authentication class presented
     */
    public boolean supports(Class authentication) {

    	boolean returnboolean = (DBAuthenticationToken.class.isAssignableFrom(authentication));
    	return returnboolean;
    }

    /**
     * Retrieves an User by given username and DBAuthenticationToken
     * 
     * @param username
     * @param authentication
     * @return the User by username and DBAuthenticationToken
     * @throws AuthenticationException
     */
    public User retrieveUser(String username, DBAuthenticationToken authentication)
	    throws AuthenticationException {
	

	User user = userDetailsService.loadDBUser(authentication.getUsername(), authentication
		.getPassword(), authentication.getSite(), authentication.getDomain());

	
	return user;
    }

    /**
     * Performs authentication with the same contract as
     * AuthenticationManager.authenticate(Authentication).
     * 
     * @param authentication -
     *                the authentication request object.
     * @return a fully authenticated object including credentials. May return
     *         null if the AuthenticationProvider is unable to support
     *         authentication of the passed Authentication object. In such a
     *         case, the next AuthenticationProvider that supports the presented
     *         Authentication class will be tried.
     */
    public Authentication authenticate(Authentication authentication)
	    throws AuthenticationException {
	// Determine username
	String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED"
		: authentication.getName();
	User user = null;

	user = retrieveUser(username, (DBAuthenticationToken) authentication);

	Authentication returnAuthentication = createSuccessAuthentication(
		(DBAuthenticationToken) authentication, user);
	
	return returnAuthentication;
    }

    /**
     * Creates Success Authentication
     * 
     * @param token
     * @param user
     * @return a fully authenticated object based upon the User.
     */
    protected Authentication createSuccessAuthentication(DBAuthenticationToken token, User user) {
	

	DBAuthenticationToken result = new DBAuthenticationToken(user.getAuthorities(), token
		.getUsername(), token.getPassword(), token.getSite(), token.getDomain(), user
		.getId());
	result.setDetails(token.getDetails());

	
	return result;
    }
}