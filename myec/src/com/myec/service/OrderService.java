package com.myec.service;

import java.util.List;

import com.myec.pojo.Address;
import com.myec.pojo.Order;

public interface OrderService {

	int createOrder(Long userId,Integer num,Long productId,Address address);
	
	List<Order> getUserOrderList(Long userId);
	
	Order getById(Long orderId,Long userId);
	
	int pay(Long orderId,Long userId) ;
	
	int cancel(Long orderId, Long userId);
}
