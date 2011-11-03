package com.ekit.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ekit.security.data.User;

/**
 * Implements the AuthenticationProvider which can process specific
 * authentication
 */
public class DBAuthenticationProviders implements AuthenticationProvider {
    /**
     * Logger for this class
     */
   

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

    /*
     * public Authentication authenticate(Authentication authentication) {
     * System.out.println("authenticate"); if
     * (!supports(authentication.getClass())) { return null; }
     * 
     * if (authentication instanceof DBAuthenticationToken) {
     * DBAuthenticationToken token = (DBAuthenticationToken) authentication;
     * 
     * User user = userDetailsService.loadDBUser(token.getUsername(),
     * token.getPassword(), token.getSite(), token.getDomain()); if (user==null)
     * return null;
     * 
     * DBAuthenticationToken result = new
     * DBAuthenticationToken(user.getAuthorities(), token.getUsername(),
     * token.getPassword(), token.getSite(), token.getDomain(), user.getId());
     * result.setDetails(authentication.getDetails()); return result; } return
     * null; }
     */

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

	/*
	 * preAuthenticationChecks.check(user);
	 * 
	 * try { additionalAuthenticationChecks(user,
	 * (UsernamePasswordAuthenticationToken) authentication); } catch
	 * (AuthenticationException exception) { if (cacheWasUsed) { // There
	 * was a problem, so try again after checking // we're using latest data
	 * (ie not from the cache) cacheWasUsed = false; user =
	 * retrieveUser(username, (UsernamePasswordAuthenticationToken)
	 * authentication); additionalAuthenticationChecks(user,
	 * (UsernamePasswordAuthenticationToken) authentication); } else { throw
	 * exception; } }
	 * 
	 * postAuthenticationChecks.check(user);
	 * 
	 * if (!cacheWasUsed) { this.userCache.putUserInCache(user); }
	 * 
	 * Object principalToReturn = user;
	 * 
	 * if (forcePrincipalAsString) { principalToReturn = user.getUsername(); }
	 */

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