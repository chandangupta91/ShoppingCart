package com.cg.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.domain.UserDomain;
@Repository
public interface UserDao extends JpaRepository<UserDomain, Integer>{

	UserDomain findByEmail(String email);


}
