package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService {
	public void createUser(User user);
	public boolean updateUser(int userId, User user);
	public boolean deleteUser(int userId);
	
	public User findUserById(int userId);
	public List<User> findAll();

}
