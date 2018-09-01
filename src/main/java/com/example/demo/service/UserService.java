package com.example.demo.service;

import org.springframework.stereotype.Service;


public interface UserService {
	void logup(String name,String password);

	User hasUser(String name);
	
	String passright(String name);
}
