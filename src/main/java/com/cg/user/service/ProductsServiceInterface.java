package com.cg.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.user.domain.ProductsDomain;
@Service
public interface ProductsServiceInterface {
	
	public	List<ProductsDomain> getAllProducts();

	public ProductsDomain createOrUpdateProducts(ProductsDomain product);

	Optional<ProductsDomain> getProductById(int id);

	public void deleteById(ProductsDomain product);

}
