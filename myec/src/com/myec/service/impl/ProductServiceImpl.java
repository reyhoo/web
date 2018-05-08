package com.myec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myec.mapper.ProductMapper;
import com.myec.pojo.Product;
import com.myec.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> getAllProductList() {
		return productMapper.getAll();
	}

	@Override
	public List<Product> getProductListByUserId(Long userId) {
		return productMapper.getByMerchantId(userId);
	}

	@Override
	public Product getProductById(Long id) {
		return productMapper.getById(id);
	}

	@Override
	public int decrementStock(Long id, Integer version) {
		return productMapper.decrementStock(id, version);
	}

	@Override
	public int incrementStock(Long id, Integer version) {
		return productMapper.incrementStock(id, version);
	}

}
