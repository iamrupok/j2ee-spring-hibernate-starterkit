package com.ekit.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
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
    public ModelAndView UserList(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    		HashMap model = new HashMap();
    		model.put("PageLink", "User");
    		model.put("PageTitle", "Users");
    		ModelAndView returnModelAndView = new ModelAndView("/security/user_list", model);
    		return returnModelAndView;
    }
    
    @SuppressWarnings("unchecked")
    public ModelAndView EmployeeList(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    		HashMap model = new HashMap();
    		model.put("PageLink", "Employee");
    		model.put("PageTitle", "Employees");
    		ModelAndView returnModelAndView = new ModelAndView("/security/employee_list", model);
    		return returnModelAndView;
    }
    @SuppressWarnings("unchecked")
	public ModelAndView LoadUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	    
	    
	    String taskType = ParamUtil.getString(request, "task");
	    HashMap userMap = new HashMap();
	    
	    int start = (request.getParameter("start") != null) ? ParamUtil.getInt(request, "start") : 0;
    	int limit = (request.getParameter("limit") != null) ? ParamUtil.getInt(request, "limit") : 15;
    	List<Map<String,Object>> userList = userDetailsService.getAllUsers();
    	
	    if(taskType.equals("ALL")) {
	    		
			userMap.put( "userList",  userList.subList(start, start + limit > userList.size() ? userList.size() : start + limit));
			userMap.put( "totalCount",  userList.size());
	    }
	    else
	    {
	    		ArrayList<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
	    		for(int i = 0; i < userList.size(); i++) {
	    			
	    			if(((String) userList.get(i).get("username")).toUpperCase().startsWith(taskType.toUpperCase())
	    					|| ((String) userList.get(i).get("username")).toUpperCase().endsWith(taskType.toUpperCase()))
	    				list1.add(userList.get(i));
	    		}
	    		
	    		userMap.put("userList", list1.subList(start, start + limit > list1.size() ? list1.size() : start
	    				+ limit));
	    		userMap.put("totalCount", list1.size());
	    	
	    }
	    
		ModelAndView userListModelAndView = new ModelAndView(new JSONView(), userMap);
		
	  
		
		return userListModelAndView;
	}
    
    public ModelAndView SaveUser(HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		 
		
		String jsonData = ParamUtil.getString(request, "jsonData");
		
		JSONObject jsonObject = new JSONObject(jsonData);
		HashMap userMap = new HashMap();
		
		User securityUser = null;
		
		if(ParamUtil.getString(request, "saveType").equals("create")) {
			try {
				
				securityUser=new User();
				securityUser.setFirstName((String)jsonObject.get("firstName"));
				securityUser.setLastName((String)jsonObject.get("lastName"));
				securityUser.setUsername((String)jsonObject.get("username"));
				securityUser.setEmail((String)jsonObject.get("email"));
				securityUser.setUserType((String)jsonObject.get("userType"));
				DESEDE encodepwd=new DESEDE((String)jsonObject.get("username"));
				securityUser.setPassword(encodepwd.encrypt((String)jsonObject.get("password")));
				
				
				userDetailsService.save(securityUser);
				userMap.put("success", "true");
			    
			} catch(Exception ex) {
				userMap.put("failure", "true");
			}
		} else {
			try {
			   
				securityUser =userDetailsService.getUser(Integer.parseInt(jsonObject.get("id").toString()));
				//securityUser=new User();
				securityUser.setFirstName((String)jsonObject.get("firstName"));
				securityUser.setLastName((String)jsonObject.get("lastName"));
				securityUser.setUsername((String)jsonObject.get("username"));
				securityUser.setEmail((String)jsonObject.get("email"));
				securityUser.setUserType((String)jsonObject.get("userType"));
				DESEDE encodepwd=new DESEDE((String)jsonObject.get("username"));
				securityUser.setPassword(encodepwd.encrypt((String)jsonObject.get("password")));
				userDetailsService.save(securityUser);
							    
			    userMap.put("success", "true");
			} catch(Exception ex) {
				userMap.put("failure", "true");
			}
		}
		
		ModelAndView userSaveModelAndView = new ModelAndView(new JSONView(), userMap);
		
		return userSaveModelAndView;
		}
    
    public ModelAndView DeleteUser(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		HashMap deleteUserMap = new HashMap();
		
		try {
			 
			userDetailsService.deleteUser(ParamUtil.getInt(request, "id"));
			deleteUserMap.put("success", "true");
		} catch(Exception ex) {
			deleteUserMap.put("failure", "true");
		}
		
		ModelAndView userDeleteModelAndView = new ModelAndView(new JSONView(), deleteUserMap);
		
		return userDeleteModelAndView;
		}

}
