package com.ekit.security;

import java.util.ArrayList;
import java.util.Map;

import com.ekit.security.data.User;


public interface UserDetailsService extends	org.springframework.security.core.userdetails.UserDetailsService {

    public User getUser(int userID);
    public User getUserByEmail(String emailAddress);
    public User save(User user);
    public User loadDBUser(String username, String password, String site, String domain);       
    public ArrayList<Map<String, Object>> getAllUsers();
    public void deleteUser(int userID);
    
}