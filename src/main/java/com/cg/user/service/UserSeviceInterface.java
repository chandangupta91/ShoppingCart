package com.cg.user.service;

import java.util.List;
import java.util.Optional;

import com.cg.user.domain.UserDomain;

public interface UserSeviceInterface {
	

public UserDomain createOrUpdateProducts(UserDomain product);


public void deleteById(UserDomain product);

public Optional<UserDomain> getUserById(int id);


UserDomain findOne(String email);


}
