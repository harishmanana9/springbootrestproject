package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.userdao.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public boolean updateUser(int userId, User user) {
		return userDao.updateUser(userId, user);
	}

	@Override
	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public User findUserById(int userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
