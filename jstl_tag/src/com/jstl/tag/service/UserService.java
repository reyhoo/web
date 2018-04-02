package com.jstl.tag.service;

import com.jstl.tag.pojo.PageData;
import com.jstl.tag.pojo.User;

public interface UserService {

	PageData<User>getAllUser(int start,int limit);
	
	User getUser(Long id);
}
