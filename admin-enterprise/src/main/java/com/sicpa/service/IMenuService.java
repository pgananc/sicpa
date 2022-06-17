package com.sicpa.service;

import java.util.List;

import com.sicpa.model.Menu;

public interface IMenuService{
	
	List<Menu> findMenuByUsername(String userName);
}
