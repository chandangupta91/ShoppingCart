package com.cg.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.domain.ProductsDomain;
@Repository
public interface ProductsDao extends JpaRepository<ProductsDomain, Integer>{

}
