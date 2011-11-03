package com.ekit.security.data;

import java.util.List;


import com.ekit.security.data.User;

public interface UserDao {

    public User save(User user);
    public void delete(User user);
    public User get(int userID);
    public User get(String username);
    public User get(String site, String domain, String username, String password);
    public User getUserByEmail(String email);
    public List<User> getAllUsers();

}
