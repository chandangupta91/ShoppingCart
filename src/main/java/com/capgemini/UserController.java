package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.service.UserService;

//@CrossOrigin
@RestController

public class UserController {

	@Autowired
	private UserService userService;
	
	
}
