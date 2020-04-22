package com.onlineShopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.onlineShopping.dao.CategoryDao;
import com.onlineShopping.entity.Category;
import com.onlineShopping.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	private CategoryDao categorydao;

	@Override
	public List<Category> all(){
		return categorydao.findAll();
		
	}

	@Override
	public Category newCategory(Category newCategory) {
		return categorydao.save(newCategory);
	}

//	@Override
//	public Category replaceCategory(Category newcategory, int id) {
//		 //insert
//	}

	@Override
	public void deleteCategory(int id) {
		categorydao.deleteById(id);
		
	}

	@Override
	public Optional<Category> one(int id) {
	
		return categorydao.findById(id);
	}
	

}
