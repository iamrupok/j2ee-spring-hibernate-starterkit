package com.ekit.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Processes an authentication form submission
 */
public class DBAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    /**
     * Logger for this class
     */
   

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "j_password";
    public static final String SPRING_SECURITY_FORM_SITE_KEY = "j_site";
    public static final String SPRING_SECURITY_FORM_DOMAIN_KEY = "j_domain";
    public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";

    private String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
    private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;

    /**
     * Returns a populated authentication token for the authenticated user,
     * indicating successful authentication. Returns null, indicating that the
     * authentication process is still in progress. Before returning, the
     * implementation should perform any additional work required to complete
     * the process.
     * 
     * @param request
     * @param response
     * @return the authenticated user token, or null if authentication is
     *         incomplete.
     * @throws AuthenticationException
     *                 if the authentication process fails
     */
    public Authentication attemptAuthentication(HttpServletRequest request,
	    HttpServletResponse response) throws AuthenticationException {
	if(logger.isDebugEnabled()) {
	    logger.debug("attemptAuthentication(HttpServletRequest, HttpServletResponse) - start");
	}

	String username = obtainUsername(request);
	String password = obtainPassword(request);
	String site = request.getParameter(SPRING_SECURITY_FORM_SITE_KEY);
	String domain = request.getParameter(SPRING_SECURITY_FORM_DOMAIN_KEY);

	if(username == null)
	    username = "";
	if(password == null)
	    password = "";

	username = username.trim();
	DBAuthenticationToken authRequest = new DBAuthenticationToken(username, password, site,
		domain);
	HttpSession session = request.getSession(false);

	if(session != null || getAllowSessionCreation()) {
	    request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY,
		    StringUtils.escape(username));
	}
	setDetails(request, authRequest);

	Authentication returnAuthentication = this.getAuthenticationManager().authenticate(
		authRequest);
	if(logger.isDebugEnabled()) {
	    logger.debug("attemptAuthentication(HttpServletRequest, HttpServletResponse) - end");
	}
	return returnAuthentication;
    }

    /**
     * May configure what is put into the authentication request's details
     * property.
     * 
     * @param request
     * @param authRequest
     */
    protected void setDetails(HttpServletRequest request, DBAuthenticationToken authRequest) {
	if(logger.isDebugEnabled()) {
	    logger.debug("setDetails(HttpServletRequest, DBAuthenticationToken) - start");
	}

	authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

	if(logger.isDebugEnabled()) {
	    logger.debug("setDetails(HttpServletRequest, DBAuthenticationToken) - end");
	}
    }
}