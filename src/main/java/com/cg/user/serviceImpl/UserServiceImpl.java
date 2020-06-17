package com.cg.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.dao.UserDao;
import com.cg.user.domain.UserDomain;
import com.cg.user.service.UserSeviceInterface;

@Service

public class UserServiceImpl implements UserSeviceInterface {
	
@Autowired
   private UserDao userDao;


@Override
public UserDomain findOne(String email) {
    return userDao.findByEmail(email);
}


	@Override
	public UserDomain createOrUpdateProducts(UserDomain user) {
		
		// TODO Auto-generated method stub
		UserDomain addedProduct =userDao.save(user);
		return addedProduct;
	}


	@Override
	public Optional<UserDomain> getUserById(int id) {
		
		// TODO Auto-generated method stub
		return 	userDao.findById(id);
	}


	@Override
	public void deleteById(UserDomain product) {
		userDao.delete(product);
		
	}

}
