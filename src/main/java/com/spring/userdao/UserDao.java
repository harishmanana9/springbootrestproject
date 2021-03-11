package com.spring.userdao;

import java.util.List;

import com.spring.model.User;

public interface UserDao {
	public void createUser(User user);
	public boolean updateUser(int userId, User user);
	public boolean deleteUser(int userId);
	
	public User findUserById(int userId);
	public List<User> findAll();
}
