package com.myec.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myec.pojo.TestInfo;
@Repository
public interface TestMapper {

	List<TestInfo>findAll();
	TestInfo findById(Long id);
}
