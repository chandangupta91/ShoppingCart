package com.cg.user.service;

import java.util.List;
import java.util.Optional;

import com.cg.user.domain.ImagesDomain;


public interface ImagesServiceInterface {
	

Optional<ImagesDomain> findById(Integer id);

List<ImagesDomain> findAll();

//Optional<ImagesDomain> findAll();



}
