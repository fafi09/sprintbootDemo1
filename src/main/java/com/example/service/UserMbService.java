package com.example.service;

import com.example.entity.User;

public interface UserMbService {
	User findByName(String userid);
	int insert(User user);
}
