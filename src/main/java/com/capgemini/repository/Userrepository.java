package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.User;

public interface Userrepository extends JpaRepository<User, Long>{

	
	
}
