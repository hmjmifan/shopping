package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.demo.service.Book;
import com.example.demo.service.BookClassify;

public interface BookMapper {
	
	//取书的类型
	@Select("Select * from classify")
	List<BookClassify> classify();
	
	
	@Insert("insert into classify (classify) values(#{classify})")
	void addclassify(BookClassify bookclass);
	
	//添加一本书
	@Insert("insert into book (bookname,author,classify) values(#{bookname},#{author},#{classify})")
	void addbook(Book book);
	
	//添加一本书
	@Insert("insert into book (bookname,author,classify,picture) values(#{bookname},#{author},#{classify},#{picture})")
	void addbook2(Book book);
	
	
	//取出来所有书
	@Select("select * from book")
	List<Book> extract();
	
	//取出一类书
	@Select("select * from book where classify=#{i}")
	List<Book> searchbook(int i);
	
	//按书名查询
	@Select("select * from book where bookname=#{string}")
	Book search(String string);
	
	//按作者查询
	@Select("select * from book where author=#{string}")
	List<Book> searchauthor(String string);
	
	//按书名查询id
	@Select("select id from book where bookname=#{string}")
	int findbyname(String string);
	
}
