package com.cg.products.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.products.domain.ProductsDomain;
@Repository
public interface ProductsDao extends JpaRepository<ProductsDomain, Integer>{


}
