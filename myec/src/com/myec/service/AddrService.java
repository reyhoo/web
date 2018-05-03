package com.myec.service;

import java.util.List;

import com.myec.pojo.Address;

public interface AddrService {

	List<Address> getUserAddresses(Long userId);
	
	Address getAddress(Long id);
	
	int add(Address address);
}
