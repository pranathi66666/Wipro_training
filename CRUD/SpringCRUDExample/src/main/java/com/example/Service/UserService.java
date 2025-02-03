package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.entity.User;
@Service
public interface UserService {
	User createUser(User user);

}
