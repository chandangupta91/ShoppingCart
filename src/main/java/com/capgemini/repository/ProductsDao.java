package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.ProductsDomain;

public interface ProductsDao extends JpaRepository<ProductsDomain, Integer>{

}
