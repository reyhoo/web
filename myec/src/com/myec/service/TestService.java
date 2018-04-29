package com.myec.service;

import java.util.List;

import com.myec.pojo.TestInfo;

public interface TestService {

	
	List<TestInfo> getAll();
	
	TestInfo getById(Long id);
}
