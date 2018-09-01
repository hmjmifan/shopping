package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookmapper;
	
	//取出一类书
	@Override
	public List<Book> searchbook(int i) {
		return bookmapper.searchbook(i);
		
	}
	
	//按照书名查询
	@Override
	public Book searchone(String string) {
		if(bookmapper.search(string)!=null) {
			
			return bookmapper.search(string); 
		}
		else{
			return null;
		}
			
	}
	
	//按作者查询
	@Override
	public List<Book> searchauthor(String string) {
		if(bookmapper.searchauthor(string)!=null) {
			return bookmapper.searchauthor(string);
		}else {
			
			return null;
		}
	}

}
