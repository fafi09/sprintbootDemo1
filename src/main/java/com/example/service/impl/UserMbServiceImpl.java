package com.example.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserMbService;

@Service
public class UserMbServiceImpl implements UserMbService {

	//@Resource
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByName(String userid) {
		User user = userMapper.findByName(userid);
		return user;
	}

	@Override
	public int insert(User user) {
		userMapper.insert(user.getUserid(), user.getUsername(), user.getPassword(), user.getStatus());
		return 0;
	}

}
