package com.sicpa.service;

import com.sicpa.model.User;

public interface ILoginService {
	
	User validateUserName(String userName, String password) throws Exception;
	

}
