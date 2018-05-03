package com.myec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myec.pojo.Address;
import com.myec.service.AddrService;

@Service
public class AddrServiceImpl implements AddrService {

	@Autowired
	private AddrService addrService;
	
	@Override
	public List<Address> getUserAddresses(Long userId) {
		return addrService.getUserAddresses(userId);
	}

	@Override
	public Address getAddress(Long id) {
		return addrService.getAddress(id);
	}

	@Transactional
	@Override
	public int add(Address address) {
		
		return addrService.add(address);
	}

}
