package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.BookMapper;
import com.example.demo.service.Book;
import com.example.demo.service.BookClassify;
import com.example.demo.service.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	UserServiceImpl userservice;

	@Autowired
	BookMapper bookMapper;
	int x;
	int n;

	@PostMapping
	public int register(@RequestBody User user) {

		userservice.logup(user.getName(), user.getPassword());
		return 1;
	}

	@PostMapping("/")
	public int login(@RequestBody User user, HttpSession session) {
		User u = new User();
		u=userservice.hasUser(user.getName());
		if (u!=null) {
			if (user.getPassword().equals(userservice.passright(user.getName()))) {
				// 登录成功
				n = 1;
				session.setAttribute("n", u);
				System.out.println(u);
			} else {// 密码不对
				n = 2;
			}
		} else {// 没找到用户名
			n = 0;
		}
		return n;
	}

}
