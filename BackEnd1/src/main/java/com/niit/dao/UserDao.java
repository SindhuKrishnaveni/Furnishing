package com.niit.dao;
import java.util.List;

import com.niit.model.User;
public interface UserDao 
{
	public User addUser(User user);
	public List<User>getUser();
    public User selectUser(int id);
	public void updateUser(User user);
	public void deleteUser(int id);
}

