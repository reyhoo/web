package com.myec.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myec.pojo.Address;
@Repository
public interface AddrMapper {

	List<Address> getListByUserId(Long userId);
	
	Address getById(Long id);
	
	int add(Address address);
}
