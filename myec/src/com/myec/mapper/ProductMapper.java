package com.myec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.myec.pojo.Product;

@Repository
public interface ProductMapper {

	List<Product> getAll();
	
	List<Product>getByMerchantId(Long id);
	
	Product getById(Long id);
	
	int decrementStock(@Param("id")Long id,@Param("version")Integer version);
	
	int incrementStock(@Param("id")Long id,@Param("version")Integer version);
}
