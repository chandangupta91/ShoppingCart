package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.User;
import com.capgemini.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/userdetails/{email}")
	public User getUserDetials(@PathVariable("email") String email) {
		return userService.findOne(email);
	}
	
	@PostMapping("/register")
	public User registerUserDetails(@RequestBody User user) {
		System.out.println("Reg controller");
		return userService.save(user);
	}
}
