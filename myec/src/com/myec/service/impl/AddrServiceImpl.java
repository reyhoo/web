package com.myec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myec.mapper.AddrMapper;
import com.myec.pojo.Address;
import com.myec.service.AddrService;

@Service
public class AddrServiceImpl implements AddrService {

	@Autowired
	private AddrMapper addrMapper;
	
	@Override
	public List<Address> getUserAddresses(Long userId) {
		return addrMapper.getListByUserId(userId);
	}

	@Override
	public Address getAddress(Long id) {
		return addrMapper.getById(id);
	}

	@Transactional
	@Override
	public int add(Address address) {
		
		return addrMapper.add(address);
	}

}
