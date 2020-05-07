package com.capgemini.service.impl;

import java.util.List;
import java.util.Optional;

import com.capgemini.entity.Category;
import com.capgemini.repository.CategoryRepository;
import com.capgemini.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;

	@Override
	public List<Category> all(){
		return categoryRepository.findAll();
		
	}

	@Override
	public Category newCategory(Category newCategory) {
		return categoryRepository.save(newCategory);
	}

//	@Override
//	public Category replaceCategory(Category newcategory, int id) {
//		 //insert
//	}

	@Override
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public Optional<Category> one(int id) {
	
		return categoryRepository.findById(id);
	}
}
