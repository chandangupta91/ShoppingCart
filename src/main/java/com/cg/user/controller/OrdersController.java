package com.cg.user.controller;

import java.util.ArrayList;
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

import com.cg.user.dao.ProductsDao;
import com.cg.user.domain.OrdersDomain;
import com.cg.user.domain.ProductsDomain;
import com.cg.user.service.OrdersServiceInterface;
import com.cg.user.service.ProductsServiceInterface;



@RestController
@RequestMapping(value="/orders")
public class OrdersController {
	
@Autowired
OrdersServiceInterface OrdersService;

@Autowired
ProductsServiceInterface ProductsService;

@Autowired
ProductsDao productDao;

	@GetMapping(value="/getAllOrders")
	public  List<OrdersDomain> getAllOrders(){
	
	List<OrdersDomain> list = new ArrayList<OrdersDomain>();
	list =OrdersService.getAllOrders();
	
	return list;
	
	}
	
	 @GetMapping(value= "/{id}")
	    public OrdersDomain getOrderById(@PathVariable int id) throws Exception {
	 
	        Optional<OrdersDomain> orders =  OrdersService.getOrderById(id);
	        if(!orders.isPresent())
	            throw new Exception("Could not find order with id- " + id);
	 
	        return orders.get();
	    }
	 
	
	
	@PutMapping(value="/addOrder")	
	public ResponseEntity<OrdersDomain> createOrUpdateProducts(@RequestBody OrdersDomain order){
		
		Optional<OrdersDomain> orders =  OrdersService.getOrderById(order.getOrderId());
		
		OrdersDomain ordersnew= new OrdersDomain();
		
		
		if(orders.isPresent()) {
			if(StringUtils.isEmpty(order.getBuyerName())) {
				order.setBuyerName(orders.get().getBuyerName());
			}
			if(StringUtils.isEmpty(order.getBuyerAddress())) {
				order.setBuyerAddress(orders.get().getBuyerAddress());
			}
			if(StringUtils.isEmpty(order.getBuyerProduct())) {
				order.setBuyerProduct(orders.get().getBuyerProduct());
			}
			if(StringUtils.isEmpty(order.getOrderAmount())) {
				order.setOrderAmount(orders.get().getOrderAmount());
			}
			
			if(StringUtils.isEmpty(order.getOrderStatus())) {
				order.setOrderStatus(orders.get().getOrderStatus());
			}
			
			if(StringUtils.isEmpty(order.getCreateTime())) {
				order.setCreateTime(orders.get().getCreateTime());
			}
			if(StringUtils.isEmpty(order.getUpdateTime())) {
				order.setUpdateTime(orders.get().getUpdateTime());
			}
			
			ordersnew= OrdersService.createOrUpdateProducts(order);
			
			
			
			
		}
		else {
			ordersnew = OrdersService.createOrUpdateProducts(order);
			for(ProductsDomain o:order.getProducts()) {
				o.setOrderMain(order);
			}
			productDao.saveAll(order.getProducts());
		}
		
		//ordersnew= ProductsService.createOrUpdateProducts(order);
		
		return  new ResponseEntity<OrdersDomain>(ordersnew, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value= "/delete")
    public String deleteEmployeeById(@RequestBody OrdersDomain order ) throws Exception {
		
		int deletedId = order.getOrderId();
 
        Optional<OrdersDomain> orders =  OrdersService.getOrderById(order.getOrderId());
        if(!orders.isPresent())
            throw new Exception("Could not find order with id- " + order.getOrderId());
        
        OrdersService.deleteById(order);
		return ("deleted id is   " + deletedId);
 
    }

}
