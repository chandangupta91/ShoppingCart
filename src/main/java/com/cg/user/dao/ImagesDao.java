package com.cg.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.domain.ImagesDomain;


@Repository
public interface ImagesDao extends JpaRepository<ImagesDomain, Integer>{


}
