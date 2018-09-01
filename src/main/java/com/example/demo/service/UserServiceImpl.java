package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public void logup(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		userMapper.add(user);

	}

	@Override
	public User hasUser(String name) {
		if (userMapper.FindByName(name) != null) {
			return userMapper.FindByName(name);
		}
		return null;
	}

	@Override
	public String passright(String name) {
		return userMapper.passright(name);
	}
}
