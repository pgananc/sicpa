package com.sicpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicpa.model.User;
import com.sicpa.repository.ILoginRepository;
import com.sicpa.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginRepository loginRepository;

	@Override
	public User validateUserName(String userName, String password) throws Exception {
		return loginRepository.validateByUserName(userName, password);
	}
}
