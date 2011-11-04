package com.ekit.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.ekit.util.ParamUtil;
import com.ekit.util.JSONView;
import com.ekit.security.DBAuthenticationToken;
import com.ekit.security.UserDetailsService;
import com.ekit.security.data.User;
import com.ekit.util.DBVController;

public class SecurityController extends DBVController {
  
    private final String LOGOUT_URL = "/ekit/j_spring_security_logout";
    private final String ADMIN_PAGE = "/ekit/security/AdminHome.dbv";
    private final String USER_PAGE = "/ekit/security/UserHome.dbv";
    
    
    private UserDetailsService userDetailsService;
    
    public void setUserDetailsService(UserDetailsService userService) {
    	this.userDetailsService = userService;
    }

    public ModelAndView Login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String errorLogin = request.getParameter("error_login");
	
		HashMap model = new HashMap();
		model.put("errorLogin", errorLogin == null ? "" : errorLogin);
	
		return new ModelAndView("/security/login", model);
    }

    public ModelAndView PasswordRequest(HttpServletRequest request, HttpServletResponse response)
    				throws Exception {
    	
    	HashMap map = new HashMap();
    	map.put("success", "");

    	return new ModelAndView("/security/password_request", map);
    }
    
    
    public void Logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	response.sendRedirect(LOGOUT_URL);
    }

    public void LoginFailure(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	response.sendRedirect("");
    }

    public void Welcome(HttpServletRequest request, HttpServletResponse response) {

	DBAuthenticationToken token = (DBAuthenticationToken) request.getUserPrincipal();

		try {
			
		    try {
				User user = userDetailsService.getUser(token.getUserID());
		
				if(user != null) {
					if(user.hasRole("ROLE_ADMIN")) {
				    	response.sendRedirect(this.ADMIN_PAGE);
				    } else {
				    	response.sendRedirect(this.USER_PAGE);
				    }
				} 
	
		    } catch(IOException ioe) {
				
		    }
		} catch(Exception e) {

		    e.printStackTrace();
		}
    }
    
    @SuppressWarnings("unchecked")
	public ModelAndView AdminHome(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HashMap adminMap = new HashMap();
		adminMap.put("PageLink", "Dashboard");
		adminMap.put("PageTitle", "Administrator-Home");
		ModelAndView adminHomeModelAndView = new ModelAndView("/security/admin_home", adminMap);
		
		
		
		return adminHomeModelAndView;
	}

    @SuppressWarnings("unchecked")
	public ModelAndView UserHome(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		
		HashMap userMap = new HashMap();
		userMap.put("PageLink", "users");
		userMap.put("PageTitle", "Manage-Users");
		ModelAndView manageUsersModelAndView = new ModelAndView("/security/user_home", userMap);
		
		
		
		return manageUsersModelAndView;
	}
    
    @SuppressWarnings("unchecked")
	public ModelAndView LoadUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	    
	    
	    String taskType = ParamUtil.getString(request, "task");
	    HashMap userMap = new HashMap();
	    
	    if(taskType.equals("ALL")) {
	    	int start = (request.getParameter("start") != null) ? ParamUtil.getInt(request, "start") : 0;
	    	int limit = (request.getParameter("limit") != null) ? ParamUtil.getInt(request, "limit") : 15;
	    	List<Map<String,Object>> userList = userDetailsService.getAllUsers();	
			userMap.put( "userList",  userList.subList(start, start + limit > userList.size() ? userList.size() : start + limit));
			userMap.put( "totalCount",  userList.size());
	    }
	    
		ModelAndView userListModelAndView = new ModelAndView(new JSONView(), userMap);
		
	  
		
		return userListModelAndView;
	}
}
