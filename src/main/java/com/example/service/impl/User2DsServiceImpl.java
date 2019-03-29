package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.service.User2DsService;
import com.example.test.mapper.UserTestMapper;
import com.example.test1.mapper.StudentMapper;

@Service
public class User2DsServiceImpl implements User2DsService {

	@Autowired
	private UserTestMapper userMapper;
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public int insert(User user) {
		userMapper.insert(user.getUserid(), user.getUsername(), user.getPassword(), user.getStatus());
		studentMapper.insert(user.getUserid(), user.getUsername(), 12, user.getStatus());
		return 0;
	}

}
