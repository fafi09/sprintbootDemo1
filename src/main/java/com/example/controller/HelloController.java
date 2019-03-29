package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.entity.UserJpa;
import com.example.service.User2DsService;
import com.example.service.UserJpaService;
import com.example.service.UserMbService;
import com.example.service.UserService;

@RestController
@EnableAutoConfiguration
public class HelloController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMbService userMbService;

	@Autowired
	private UserJpaService userJpaService;
	
	@Autowired
	private User2DsService user2DsService;
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/errorpage")
	public String error() {
		/*
		 * int a = 2/0; return "error";
		 */
		throw new RuntimeException();
	}

	@RequestMapping("/createuser")
	public String createUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		userService.createUser(username, password);
		return "success";
	}

	@RequestMapping("/creatembuser")
	public String createMbUser(@RequestParam(value = "userid") String userid,
			@RequestParam(value = "username") String username, 
			@RequestParam(value = "password") String password,
			@RequestParam(value = "status") String status) {
		User user = new User();
		user.setUserid(Integer.valueOf(userid));
		user.setUsername(username);
		user.setPassword(password);
		user.setStatus(status);
		
		userMbService.insert(user);
		
		return "success";
	}
	
	@RequestMapping("/finduser")
	public User findUser(@RequestParam(value = "userid") String userid) {
		User user = userMbService.findByName(userid);
		return user;
	}
	
	@RequestMapping("/findjpauser")
	public UserJpa findJpaUser(@RequestParam(value = "userid") String userid) {
		UserJpa user = userJpaService.findUser(Integer.valueOf(userid));
		return user;
	}
	
	@RequestMapping("/create2user")
	public String create2DsUser(@RequestParam(value = "userid") String userid,
			@RequestParam(value = "username") String username, 
			@RequestParam(value = "password") String password,
			@RequestParam(value = "status") String status) {
		User user = new User();
		user.setUserid(Integer.valueOf(userid));
		user.setUsername(username);
		user.setPassword(password);
		user.setStatus(status);
		user2DsService.insert(user);
		return "success";
	}
	
	
}
