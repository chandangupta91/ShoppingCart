package com.cg.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.dao.ProductsDao;
import com.cg.user.domain.ProductsDomain;
import com.cg.user.service.ProductsServiceInterface;

@Service
public class ProductsServiceImpl implements ProductsServiceInterface {
		
		@Autowired
		   private ProductsDao productsDao;


			@Override
			public List<ProductsDomain> getAllProducts() {
				
				List<ProductsDomain> products = productsDao.findAll();
				// TODO Auto-generated method stub
				return products;
			}


			@Override
			public ProductsDomain createOrUpdateProducts(ProductsDomain product) {
				
				
				
				// TODO Auto-generated method stub
				ProductsDomain addedProduct =productsDao.save(product);
				return addedProduct;
			}


			@Override
			public Optional<ProductsDomain> getProductById(int id) {
				
				// TODO Auto-generated method stub
				return 	productsDao.findById(id);
			}


			@Override
			public void deleteById(ProductsDomain product) {
				productsDao.delete(product);
				
			}
}
