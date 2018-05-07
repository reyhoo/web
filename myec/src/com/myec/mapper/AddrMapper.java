package com.myec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.myec.pojo.Address;
@Repository
public interface AddrMapper {

	List<Address> getListByUserId(Long userId);
	
	Address getById(Long id);
	
	Address getByIdAndUserId(@Param("id")Long id,@Param("userId")Long userId);
	
	int add(Address address);
	
	int delete(@Param("id")Long id,@Param("userId")Long userId);
}
