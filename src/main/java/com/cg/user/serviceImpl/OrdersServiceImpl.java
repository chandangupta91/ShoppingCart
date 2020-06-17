package com.cg.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.dao.OrdersDao;
import com.cg.user.domain.OrdersDomain;
import com.cg.user.service.OrdersServiceInterface;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersServiceInterface {
	
@Autowired
   private OrdersDao ordersDao;


	@Override
	public List<OrdersDomain> getAllOrders() {
		
		List<OrdersDomain> orders = ordersDao.findAll();
		// TODO Auto-generated method stub
		return orders;
	}


	@Override
	public OrdersDomain createOrUpdateProducts(OrdersDomain order) {
		
		
		
		// TODO Auto-generated method stub
		OrdersDomain addedOrder =ordersDao.save(order);
		return addedOrder;
	}



	@Override
	public void deleteById(OrdersDomain order) {
		ordersDao.delete(order);
		
	}


	@Override
	public Optional<OrdersDomain> getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return 	ordersDao.findById(orderId);
	}

}
