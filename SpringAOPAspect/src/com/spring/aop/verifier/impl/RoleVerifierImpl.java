package com.spring.aop.verifier.impl;

import com.spring.aop.pojo.Role;
import com.spring.aop.verifier.RoleVerifier;

public class RoleVerifierImpl implements RoleVerifier{

	@Override
	public boolean verify(Role role) {
		return role!=null;
	}

}
