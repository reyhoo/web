package com.myec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myec.mapper.OrderMapper;
import com.myec.mapper.ProductMapper;
import com.myec.mapper.UserMapper;
import com.myec.pojo.Address;
import com.myec.pojo.Order;
import com.myec.pojo.OrderProduct;
import com.myec.pojo.Product;
import com.myec.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private UserMapper userMapper;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int createOrder(Long userId,Integer num,Long productId, Address address) {
		for(int i = 0 ; i < 3; i++) {
			Product product = productMapper.getById(productId);
			if(product == null) {
				return -1;
			}
			if(product.getStock()< num) {
				return 0;
			}
//			User user = userMapper.getById(userId);
//			if(user.getBalance() < product.getPrice()) {
//				return 0;
//			}
			int updateCount = productMapper.decrementStock(productId, num, product.getVersion());
			if(updateCount == 0) {
				continue;
			}
			
			Order order = new Order();
			order.setAddr(address.getAddr());
			order.setConsumeId(userId);
			order.setMobile(address.getMobile());
			order.setNickname(address.getNickname());
			order.setTotalAmount(num*product.getPrice());;
			orderMapper.addOrder(order);
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct(product);
			orderProduct.setProductAmount(num*product.getPrice());
			orderProduct.setOrderId(order.getId());
			orderProduct.setProductName(product.getProductName());
			orderProduct.setProductQuantity(num);
			orderProduct.setProductUnitPrice(product.getPrice());
			orderMapper.addOrderProduct(orderProduct);
			return 1;
		}
		return 0;
	}
	@Override
	public List<Order> getUserOrderList(Long userId) {
		return orderMapper.getOrderByUserId(userId);
	}
	@Override
	public Order getById(Long orderId, Long userId) {
		return orderMapper.getById(orderId,userId);
	}
	@Transactional
	@Override
	public int pay(Long orderId, Long userId) {
		Order order = orderMapper.getById(orderId, userId);
		if(order == null) {
			throw new RuntimeException("Œ¥’“µΩ∂©µ•");
		}
		System.err.println(order);
		return 0;
	}

}
