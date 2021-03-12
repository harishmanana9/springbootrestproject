//package com.spring.userdao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.spring.model.User;
//
//public class UserDaoImpl implements UserDao{
//
//	private List<User> users = new ArrayList<User>();
//	
//	@Override
//	public void createUser(User user) {
//		users.add(user);
//	}
//
//	@Override
//	public boolean updateUser(int userId, User user) {
//		for(User userObj : users) {
//			if(userObj.getUserId() == userId) {
//				users.remove(userObj);
//				users.add(user);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public boolean deleteUser(int userId) {
//		for(User userObj : users) {
//			if(userObj.getUserId() == userId) {
//				users.remove(userObj);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public User findUserById(int userId) {
//		for(User userObj : users) {
//			if(userObj.getUserId() == userId) {
//				return userObj;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public List<User> findAll() {
//		return users;
//	}
//}
