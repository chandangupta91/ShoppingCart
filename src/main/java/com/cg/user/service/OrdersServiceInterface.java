package com.cg.user.service;

import java.util.List;
import java.util.Optional;

import com.cg.user.domain.OrdersDomain;


public interface OrdersServiceInterface {
public OrdersDomain createOrUpdateProducts(OrdersDomain product);


public void deleteById(OrdersDomain product);

public Optional<OrdersDomain> getOrderById(int id);

public List<OrdersDomain> getAllOrders();




}
