package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class HomeController {
	@Autowired
	private UserService userService;
	
	//End Point
	@GetMapping("/")
	public String homePage() {
		return "Welcome to Spring Boot Rest Project";
	}
	
	@PostMapping("/user")
	public ResponseEntity<Void> createNewUser(@RequestBody User userObj) {
		Optional<User> user = userService.findUserById(userObj.getUserId());
		
		if(user.isEmpty()) {
			userService.createUser(userObj);
			return new ResponseEntity<>(HttpStatus.CREATED);	
		}
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("/user/{no}")
	public ResponseEntity<Void> updateUser(@PathVariable("no") Integer userId, @RequestBody User userObj) {
		if(userService.updateUser(userId, userObj)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/user/{no}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("no") int userId) {
		Optional<User> userObj = userService.findUserById(userId);
		if(userObj.isEmpty()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@GetMapping("/user/{no}")
	public ResponseEntity<User> fetchUser(@PathVariable("no") int userId) {
		
		Optional<User> userObj = userService.findUserById(userId);
		if(userObj.isPresent()) {
			return new ResponseEntity<User>(userObj.get(), HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}	
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> fetchAllUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
}
