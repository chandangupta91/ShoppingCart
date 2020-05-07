package com.capgemini.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.Category;
import com.capgemini.repository.CategoryRepository;

@RestController
public class CategoryController {

	private final CategoryRepository categoryRepository;

	  CategoryController(CategoryRepository categoryRepository) {
	    this.categoryRepository = categoryRepository;
	  }

	  @GetMapping("/categories")
	  List<Category> all() {
	    return categoryRepository.findAll();
	  }

	  @PostMapping("/categories")
	  Category newCategory(@RequestBody Category newCategory) {
	    return categoryRepository.save(newCategory);
	  }

	  // Single item

	  @GetMapping("/catetory/{id}")
	  Category one(@PathVariable int id) throws Exception {

	    return categoryRepository.findById(id)
	      .orElseThrow(() -> new Exception("Could not find category with id:" + id));
	  }

	  @PutMapping("/category/{id}")
	  Category replaceCategory(@RequestBody Category newcategory, @PathVariable int id) {

	    return categoryRepository.findById(id)
	      .map(category -> {
	    	  category.setName(newcategory.getName());
	    	  
	        return categoryRepository.save(category);
	      })
	      .orElseGet(() -> {
	        newcategory.setId(id);
	        return categoryRepository.save(newcategory);
	      });
	  }

	  @DeleteMapping("/employees/{id}")
	  void deleteCategory(@PathVariable int id) {
	    categoryRepository.deleteById(id);
	  }
}
