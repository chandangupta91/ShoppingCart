package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.entity.ProductsDomain;

public interface ProductsSeviceInterface {
	
	public	List<ProductsDomain> getAllProducts();

	public ProductsDomain createOrUpdateProducts(ProductsDomain product);

	Optional<ProductsDomain> getProductById(int id);

	public void deleteById(ProductsDomain product);

}
