package com.example.demo.controller;

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
import com.example.demo.mapper.BorrowMapper;
import com.example.demo.service.BingInfo;
import com.example.demo.service.Book;
import com.example.demo.service.NowInfo;
import com.example.demo.service.Relation;
import com.example.demo.service.RelationServiceImpl;

@RestController
@RequestMapping("/api/v1/borrow")
public class BorrowController {
	
	@Autowired
	RelationServiceImpl relationservice;
	
	@Autowired
	BorrowMapper borrowmapper;
	
	@PostMapping("/book")
	public Relation findbybook(@RequestBody Book book){
		HashMap<String,Object> data=relationservice.findbybookname(book.getBookname());
		if((int)data.get("msg")==0) {
			return null;
		}
		else {
			return (Relation) data.get("info");
		}
	}
	
	@PostMapping
	public int borrow(@RequestBody Relation relation){
		relationservice.borrow(relation);
		return 1;	
	}
	
	@PostMapping("/re")
	public int ret(@RequestBody Relation relation) {
		relationservice.rebook(relation);
		return 1;
	}
	
	@PostMapping("/now")
	public List<NowInfo> now(@RequestBody Relation relation){
		System.out.println(borrowmapper.now(relation.getUser_id()));
		return borrowmapper.now(relation.getUser_id());
	}
	
	@GetMapping("/bing")
	public HashMap<String,Object> bing(HttpSession session){
		HashMap<String,Object> data = new HashMap<>();
		data.put("user", session.getAttribute("n"));
		data.put("info",borrowmapper.bing());
		return data;
		
	}
}	
