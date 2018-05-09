package com.myec.service;

import java.util.List;

import com.myec.pojo.Product;

public interface ProductService {

	List<Product> getAllProductList();
	
	List<Product> getProductListByUserId(Long userId);
	
	Product getProductById(Long id);
	
	int decrementStock(Long id,Integer num,Integer version);
	
	int incrementStock(Long id,Integer num);
	
}
