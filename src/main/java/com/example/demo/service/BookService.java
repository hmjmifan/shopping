package com.example.demo.service;

import java.util.List;

public interface BookService {
	
	//按类别查询
	List<Book> searchbook(int i);
	
	//按书名查询
	Book searchone(String string);
	
	//按作者查询
	List<Book> searchauthor(String string);
	
	
}
