package com.cg.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.dao.CategoryRepository;
import com.cg.user.domain.Category;
import com.cg.user.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
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
