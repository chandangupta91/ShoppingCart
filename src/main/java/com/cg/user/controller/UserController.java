package com.cg.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.user.domain.JwtResponse;
import com.cg.user.domain.Login;
import com.cg.user.domain.UserDomain;
import com.cg.user.security.JWT.JwtProvider;
import com.cg.user.service.UserSeviceInterface;


@RestController
@RequestMapping(value="/users")
public class UserController {
	
@Autowired
UserSeviceInterface userService;


@Autowired
JwtProvider jwtProvider;

@Autowired
AuthenticationManager authenticationManager;




@PostMapping("/login")
public ResponseEntity<JwtResponse> login(@RequestBody Login loginForm) {
    // throws Exception if authentication failed

    try {

    	Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generate(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDomain user = userService.findOne(userDetails.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, user.getEmail(), user.getName(), user.getRole()));
    } catch (AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

	
	
	
	  @GetMapping(value= "/{id}") public UserDomain getUserById(@PathVariable int
	  id) throws Exception {
	  
	  Optional<UserDomain> products = userService.getUserById(id);
	  if(!products.isPresent()) throw new
	  Exception("Could not find product with id- " + id);
	  
	  return products.get(); }
	  
	  
	  
	  @PutMapping(value="/addUser")
	  
	  public ResponseEntity<UserDomain> createOrUpdateProducts(@RequestBody
	  UserDomain user){
	  
	  UserDomain oldUsers = userService.findOne(user.getEmail());
	  
	  UserDomain products1= new UserDomain();
	  
	 
	  
	  
	  if(!StringUtils.isEmpty(oldUsers))

	  { 
	 if(StringUtils.isEmpty(user.getPhone())) {		  
	  user.setPhone(oldUsers.getPhone());
	  }
	  if(StringUtils.isEmpty(user.getName())) {
		  user.setName(oldUsers.getName()); }
	  
	  if(StringUtils.isEmpty(user.getAddress()))
	  {
	  user.setAddress(oldUsers.getAddress() );
	  }
	  products1=
	  userService.createOrUpdateProducts(user); }
	  else { 
		  
		  products1 =
	  userService.createOrUpdateProducts(user); }
	  
	 
	  
	  return new ResponseEntity<UserDomain>(products1, HttpStatus.OK);
	  
	  }
	  
	  
}
