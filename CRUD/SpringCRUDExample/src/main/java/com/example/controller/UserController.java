package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.UserService;
import com.example.entity.User;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping
	public ResponseEntity<User> createUser( @RequestBody User user){
		User saveUser=userservice.createUser(user);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

}
