package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//首页
	@RequestMapping("/")
	public String big() {
		return "home.html";
	}
	// 登录注册
	@RequestMapping("/login")
	public String home() {
		return "login.html";
	}
	
	//添加书籍页
	@RequestMapping("/addbook")
	public String first() {
		return "addbook.html";
	}
	
	//查询页
	@RequestMapping("/searchbook")
	public String search() {
		return "search.html";
	}
	
	@RequestMapping("/borrow")
	public String borrow() {
		return "borrow.html";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about.html";
	}
	
	
}
