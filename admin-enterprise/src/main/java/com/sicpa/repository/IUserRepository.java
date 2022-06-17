package com.sicpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicpa.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	
	User findOneByUsername(String username);
}
