package com.example.service;

import com.example.entity.UserJpa;

public interface UserJpaService {
	UserJpa findUser(Integer id);
}
