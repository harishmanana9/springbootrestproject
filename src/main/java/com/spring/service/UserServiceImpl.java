package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		userDao.save(user);
	}

	@Override
	public boolean updateUser(int userId, User user) {
		User userObj = userDao.save(user);
		if(userObj == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		User userObj = new User();
		userObj.setUserId(userId);
		userDao.delete(userObj);
		return true;
	}

	@Override
	public Optional<User> findUserById(int userId) {
		return userDao.findById(userId);
	}

	@Override
	public List<User> findAll() {
		Iterable<User> iterableUser = userDao.findAll();
		List<User> listUser = new ArrayList<User>();
		iterableUser.forEach(listUser::add);
		return listUser;
	}
}
