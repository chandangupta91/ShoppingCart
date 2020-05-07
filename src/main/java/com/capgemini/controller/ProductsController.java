package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.ProductsDomain;
import com.capgemini.service.ProductsSeviceInterface;

@RestController
@RequestMapping(value="/products")
public class ProductsController {

	@Autowired
	ProductsSeviceInterface ProductsService;
		@GetMapping(value="/getAllProducts")
		public  List<ProductsDomain> getAllProducts(){
		
		List<ProductsDomain> list=ProductsService.getAllProducts();
		
		return list;
		
		}
		
		 @GetMapping(value= "/{id}")
		    public ProductsDomain getEmployeeById(@PathVariable int id) throws Exception {
		 
		        Optional<ProductsDomain> products =  ProductsService.getProductById(id);
		        if(!products.isPresent())
		            throw new Exception("Could not find product with id- " + id);
		 
		        return products.get();
		    }
		 
		
		
		@PutMapping(value="/addProduct")
		
		public ResponseEntity<ProductsDomain> createOrUpdateProducts(@RequestBody ProductsDomain product){
			
			Optional<ProductsDomain> products =  ProductsService.getProductById(product.getPid());
			
			ProductsDomain products1= new ProductsDomain();
			
			
			if(products.isPresent()) {
				if(StringUtils.isEmpty(product.getPmodel())) {
				product.setPmodel(products.get().getPmodel());
				}
				if(StringUtils.isEmpty(product.getPname())) {
				product.setPname(products.get().getPname());
				}
				if(StringUtils.isEmpty(product.getPrice())) {
				product.setPrice(products.get().getPrice());
				}
				products1= ProductsService.createOrUpdateProducts(product);
			}
			else {
				 products1 = ProductsService.createOrUpdateProducts(product);
			}
			
		
			return  new ResponseEntity<ProductsDomain>(products1, HttpStatus.OK);
			
		}
		
		@DeleteMapping(value= "/delete")
	    public String deleteEmployeeById(@RequestBody ProductsDomain product ) throws Exception {
			
			int deletedId = product.getPid();
	 
	        Optional<ProductsDomain> products =  ProductsService.getProductById(product.getPid());
	        if(!products.isPresent())
	            throw new Exception("Could not find product with id- " + product.getPid());
	        
	        ProductsService.deleteById(product);
			return ("deleted id is   " + deletedId);
	 
	    }

}
