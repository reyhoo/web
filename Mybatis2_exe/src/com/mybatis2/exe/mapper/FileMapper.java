package com.mybatis2.exe.mapper;

import com.mybatis2.exe.pojo.TestFile;

public interface FileMapper {

	int insertFile(TestFile file);
	TestFile getFile(long l);
}
