package com.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.UserJpa;
import com.example.service.UserJpaService;

@Service
public class UserJpaServiceImpl implements UserJpaService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserJpa findUser(Integer id) {
		UserJpa ayUser = new UserJpa();
		ayUser.setUserid(id);
		Example<UserJpa> example = Example.of(ayUser);
		Optional<UserJpa> userOption = userDao.findOne(example);

		UserJpa user = userOption.get();
		return user;
	}

}
