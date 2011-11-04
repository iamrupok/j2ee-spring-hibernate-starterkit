package com.ekit.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ekit.security.UserDetailsService;
import com.ekit.security.UserDetailsServiceImpl;
import com.ekit.security.data.User;
import com.ekit.security.data.UserDao;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
   
    
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
    	
    	this.userDao = userDao;
    }
	
	public User getUser(int userID) {
    
    	User returnUser = userDao.get(userID);
    	return returnUser;
    }

    public User getUserByEmail(String emailAddress) {
	
    	User user = userDao.getUserByEmail(emailAddress);
       	return user;
    }
    
    public User save(User user) {
	
    	User returnUser = this.userDao.save(user);
	   	return returnUser;
    }

    public User loadDBUser(String username, String password, String site, String domain) {
	
    	User returnUser = userDao.get(username, password, site, domain);
	   	return returnUser;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,
	    DataAccessException {
	
    	// TODO Auto-generated method stub
    	return null;
    }
    
	public ArrayList<Map<String, Object>> getAllUsers() {
		
		
		List<User> userList = userDao.getAllUsers();
		
		ArrayList<Map<String, Object>> userMappedList = new ArrayList<Map<String, Object>>();
    	Map<String, Object> userMap = null;
    	
    	for(User user : userList){
    		userMap = new HashMap<String,Object>();
    		userMap.put("id", user.getId());
    		userMap.put("username", user.getUsername() == null ? null : user.getUsername().toString());
    		userMap.put("password", user.getPassword() == null ? null : user.getPassword());
    		userMap.put("email", user.getEmail() == null ? null : user.getEmail().toString());
    		userMap.put("firstName", user.getFirstName() == null ? null : user.getFirstName().toString());
    		userMap.put("lastName", user.getLastName() == null ? null : user.getLastName().toString());
    		userMap.put("userType",user.getUserType() );
    		userMappedList.add(userMap);
    	}
		
		
		
		return userMappedList;
	}
    
}
