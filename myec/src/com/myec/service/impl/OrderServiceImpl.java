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
import com.myec.pojo.OrderStatusEnum;
import com.myec.pojo.Product;
import com.myec.pojo.User;
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
				return -1;
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
		int count = updateOrderStatus(orderId,userId,OrderStatusEnum.PAID);
		if(count > 0) {
			Order order = orderMapper.getById(orderId, userId);
			int decrementUpdate = decrementUserBalance(userId,order.getTotalAmount());
			if(decrementUpdate <= 0) {
				throw new RuntimeException("扣款失败");
			}
			for (OrderProduct orderProduct : order.getProductList()) {
				userMapper.incrementBalance(orderProduct.getProduct().getMerchant().getId(), orderProduct.getProductAmount());
			}
		}
		return count;
	}
	@Transactional
	@Override
	public int cancel(Long orderId, Long userId) {
		int count = updateOrderStatus(orderId,userId,OrderStatusEnum.CANCELLED);
		if(count > 0) {
			Order order = orderMapper.getById(orderId, userId);
			List<OrderProduct> productList = order.getProductList();
			for (OrderProduct orderProduct : productList) {
				productMapper.incrementStock(orderProduct.getProduct().getId(), orderProduct.getProductQuantity());
			}
		}
		return count;
	}
	
	private int decrementUserBalance(Long userId,Double amount) {
		for (int i = 0; i < 3; i++) {
			User user = userMapper.getById(userId);
			if(user.getBalance() < amount) {
				return -1;
			}
			int count = userMapper.decrementBalance(userId, amount, user.getVersion());
			if(count == 0) {
				System.err.println("扣款并发");
				continue;
			}
			System.err.println("扣款成功");
			return count;
		}
		return 0;
	}
	private int updateOrderStatus(Long orderId, Long userId,OrderStatusEnum orderStatusEnum) {
		for (int i = 0; i < 3; i++) {
			Order order = orderMapper.getById(orderId, userId);
			if(order == null) {
				throw new RuntimeException("未找到订单");
			}
			System.err.println(order);
			if(!order.getStatus().equals(OrderStatusEnum.UNPAID)) {
				return -1;
			}
			int count = orderMapper.updateOrderStatus(order.getId(), order.getVersion(), orderStatusEnum);
			if(count == 0) {
				System.err.println("更新订单状态并发："+orderStatusEnum);
				continue;
			}
			System.err.println("更新订单状态成功："+orderStatusEnum);
			return count;
		}
		return 0;
	}
}
