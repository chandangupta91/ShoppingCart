package com.cg.user.service;

import java.util.List;
import java.util.Optional;

import com.cg.user.domain.Category;

public interface CategoryService {

	public List<Category> all();
	
	public Category newCategory(Category newCategory);
	
	//public Category replaceCategory(Category newcategory,int id);

	public void deleteCategory(int id);
	
	public Optional<Category> one( int id);
}
