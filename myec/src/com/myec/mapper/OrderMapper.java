package com.myec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.myec.pojo.Order;
import com.myec.pojo.OrderProduct;
import com.myec.pojo.OrderStatusEnum;

@Repository
public interface OrderMapper {
	
	
	int addOrder(Order order);
	
	int addOrderProduct(OrderProduct product);
	
	List<Order>getOrderByUserId(Long id);

	Order getById(@Param("id")Long id,@Param("userId")Long userId);
	
	int updateOrderStatus(@Param("id")Long id,@Param("orderStatus")OrderStatusEnum orderStatus);
}
