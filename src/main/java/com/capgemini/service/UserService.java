package com.capgemini.service;

import com.capgemini.entity.User;

public interface UserService {

	User save(User user);
	
	User findOne(String email);
}
