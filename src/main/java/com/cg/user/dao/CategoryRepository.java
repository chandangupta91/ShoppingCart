package com.cg.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
