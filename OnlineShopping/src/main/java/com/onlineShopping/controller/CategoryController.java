package com.onlineShopping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShopping.dao.CategoryDao;
import com.onlineShopping.entity.Category;
@RestController
public class CategoryController {
	

	  private final CategoryDao repository;

	  CategoryController(CategoryDao repository) {
	    this.repository = repository;
	  }

	  @GetMapping("/categories")
	  List<Category> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/categories")
	  Category newCategory(@RequestBody Category newCategory) {
	    return repository.save(newCategory);
	  }

	  // Single item

	  @GetMapping("/catetory/{id}")
	  Category one(@PathVariable int id) throws Exception {

	    return repository.findById(id)
	      .orElseThrow(() -> new Exception("Could not find category with id:" + id));
	  }

	  @PutMapping("/category/{id}")
	  Category replaceCategory(@RequestBody Category newcategory, @PathVariable int id) {

	    return repository.findById(id)
	      .map(category -> {
	    	  category.setName(newcategory.getName());
	    	  
	        return repository.save(category);
	      })
	      .orElseGet(() -> {
	        newcategory.setId(id);
	        return repository.save(newcategory);
	      });
	  }

	  @DeleteMapping("/employees/{id}")
	  void deleteCategory(@PathVariable int id) {
	    repository.deleteById(id);
	  }
	}


