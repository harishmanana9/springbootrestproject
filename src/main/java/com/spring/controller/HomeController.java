package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.service.UserService;

@RestController
public class HomeController {
	@Autowired
	private UserService userService;
	
	//End Point
	@GetMapping("/")
	public String homePage() {
		return "Welcome to Spring Boot Rest Project";
	}
	
	@PostMapping("/user/add")
	public ResponseEntity<Void> createNewUser(@RequestBody User userObj) {
		if(userService.findUserById(userObj.getUserId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userService.createUser(userObj);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//updateUser
	
	@DeleteMapping("/user/{no}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("no") int userId) {
		if(userService.findUserById(userId) != null) {
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(userService.deleteUser(userId), HttpStatus.OK);
	}
	
	@GetMapping("/user/{no}")
	public ResponseEntity<User> fetchUser(@PathVariable("no") int userId) {
		if(userService.findUserById(userId) != null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(userService.findUserById(userId), HttpStatus.OK);
	}	
	
	@GetMapping("/user/getall")
	public ResponseEntity<List<User>> fetchAllUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
}
