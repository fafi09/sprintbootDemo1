package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createUser(String name, String password) {
		System.out.println("create user");
		jdbcTemplate.update("insert into user values(?,?,?,?);",4, name, password, "1");

	}

}
