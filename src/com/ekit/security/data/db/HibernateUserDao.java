package com.ekit.security.data.db;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ekit.security.DESEDE;
import com.ekit.security.data.User;
import com.ekit.security.data.UserDao;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Repository
public class HibernateUserDao implements UserDao {

    private HibernateTemplate hibernateTemplate;
   
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
    }
   
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(User user) {
	
    	user = (User) hibernateTemplate.merge(user);
    	hibernateTemplate.delete(user);

    }

    public User get(int userID) {
	
    	User user = (User) hibernateTemplate.get(User.class, userID);
    	return user;
    }

    public User get(String userName) {
    	
    	Object[] paramArr = new Object[1];
    	paramArr[0] = new String(userName);
    	List<User> users = hibernateTemplate.find("from User where username=?", paramArr);
    	if((users != null) && (users.size() > 0)) {
    		User returnUser = users.get(0);
    		
    		return returnUser;
    	} else {
    		
    		return null;
    	}
    }
    
    public User getUserByEmail(String email) {
   
    	Object[] paramArr = new Object[1];
    	paramArr[0] = new String(email);
    	List<User> users = hibernateTemplate.find("from User where email=?", paramArr);
    	if((users != null) && (users.size() > 0)) {
    		User returnUser = users.get(0);

    		return returnUser;
    	} else {    		
    		return null;
    	}
    }
    
    public User get(String username, String password, String site, String domain) {
	
		DESEDE desede = new DESEDE(username);
		Object[] paramArr = new Object[2];
		paramArr[0] = new String(username);
		paramArr[1] = desede.encrypt(password);
		List<User> users = hibernateTemplate.find("from User where username=? and password=?",
			paramArr);
		if(users == null || users.size() == 0) {
		    throw new org.springframework.security.authentication.BadCredentialsException(
			    "Invalid username / password combination");
		}
	
		User returnUser = users.get(0);
		return returnUser;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User save(User user) {
	
		user = (User) hibernateTemplate.merge(user);
		return user;
    }
    
    public List<User> getAllUsers(){
    	return hibernateTemplate.find("from User");
    }
}
