package com.myec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myec.mapper.TestMapper;
import com.myec.pojo.TestInfo;
import com.myec.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;
	@Transactional
	@Override
	public List<TestInfo> getAll() {
		return testMapper.findAll();
	}

	@Override
	public TestInfo getById(Long id) {
		return testMapper.findById(id);
	}

}
