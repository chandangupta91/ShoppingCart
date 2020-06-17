package com.cg.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.dao.ImagesDao;
import com.cg.user.domain.ImagesDomain;
import com.cg.user.service.ImagesServiceInterface;

@Service
public class ImagesServiceImpl implements ImagesServiceInterface {
	
@Autowired
   private ImagesDao imagesDao;

@Override
public Optional<ImagesDomain> findById(Integer id) {
	// TODO Auto-generated method stub
	return imagesDao.findById(id);
}

@Override
public List<ImagesDomain> findAll() {
	// TODO Auto-generated method stub
	return imagesDao.findAll();
}


	
}
