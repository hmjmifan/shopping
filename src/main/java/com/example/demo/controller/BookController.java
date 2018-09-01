package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.BookMapper;
import com.example.demo.service.Book;
import com.example.demo.service.BookClassify;
import com.example.demo.service.BookServiceImpl;
import com.example.demo.service.User;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
	@Autowired
	BookMapper bookMapper;
	@Autowired
	BookServiceImpl bookservice;

	// 书的类别以及用户信息发送
	@GetMapping("/first")
	public HashMap<String, Object> info(HttpSession session) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("user", session.getAttribute("n"));
		data.put("classify", bookMapper.classify());
		return data;
	}

	// 添加书籍
	@PostMapping("/first")
	public int addbook(@RequestBody Book book) {
		System.out.println(book);
		if (book.getPicture() == "") {
			bookMapper.addbook(book);
			System.out.println("1");
			return 1;
		} else {
			System.out.println("2");
			bookMapper.addbook2(book);
			return 1;
		}

	}

	// 从数据库取所有书
	@GetMapping("/big")
	public List<Book> extract() {
		List<Book> list = bookMapper.extract();
		return list;
	}

	// 发送会话中的用户
	@GetMapping("/big/")
	public User sess(HttpSession session) {
		return (User) session.getAttribute("n");
	}
	
	@PostMapping("/big")
	public String leave(HttpSession session) {
		session.removeAttribute("n");
		return "OK";
	}
	
	



	// 检索一个类别的书
	@PostMapping("/search")
	public List<Book> searchbooks(@RequestBody Book book) {
		return bookservice.searchbook(book.getClassify());

	}

	// 查询一本书
	@PostMapping("/searchone")
	public HashMap<String, Object> searchbook(@RequestBody Book book) {
		HashMap<String, Object> data = new HashMap<>();
		if (bookMapper.search(book.getBookname()) != null) {
			data.put("book", bookservice.searchone(book.getBookname()));
			data.put("msg", 1);
		}
		if (bookMapper.search(book.getBookname()) == null) {
			data.put("book", bookservice.searchone(book.getBookname()));
			data.put("msg", 0);
		}
		System.out.println(book);
		return data;
	}

	// 按作者查询
	@PostMapping("/searchauthor")
	public HashMap<String, Object> searchauthor(@RequestBody Book book) {
		HashMap<String, Object> data = new HashMap<>();
		
		if (bookMapper.searchauthor(book.getAuthor()).size()!=0) {
			data.put("books", bookservice.searchauthor(book.getAuthor()));
			data.put("msg", 1);
			System.out.println("you");
		}
		if (bookMapper.searchauthor(book.getAuthor()).size() == 0) {
			data.put("books", bookservice.searchauthor(book.getAuthor()));
			data.put("msg", 0);
			System.out.println("meiyou");
		}
		System.out.println(book);
		return data;
	}
	
	
}
