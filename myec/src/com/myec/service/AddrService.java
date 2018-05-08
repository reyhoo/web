package com.myec.service;

import java.util.List;

import com.myec.pojo.Address;

public interface AddrService {

	List<Address> getUserAddresses(Long userId);
	
	Address getAddress(Long id);
	
	Address getAddress(Long id,Long userId);
	
	int add(Address address);
	
	int delete(Long id,Long userId);
	
	int modify(Address address);
}
