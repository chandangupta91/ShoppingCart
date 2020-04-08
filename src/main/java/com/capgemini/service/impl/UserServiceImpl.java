package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.User;
import com.capgemini.repository.Userrepository;
import com.capgemini.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private Userrepository userRepository;
	
	@Override
	public User findOne(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	@Override
	@Transactional
	public User save(User user) {
    //register
       User savedUser = userRepository.save(user);
       System.out.println("Reg Service");
       return userRepository.save(savedUser);
    }
}
