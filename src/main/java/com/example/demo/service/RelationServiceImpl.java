package com.example.demo.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.BorrowMapper;
import com.example.demo.mapper.UserMapper;

@Service
public class RelationServiceImpl implements RelationService{
	
	@Autowired
	BookMapper bookMapper;
	
	@Autowired 
	UserMapper userMapper;
	
	@Autowired 
	BorrowMapper borrowMapper;
	
	
	@Override
	public HashMap<String,Object> findbybookname(String string) {
		HashMap<String,Object> data =new HashMap<String,Object>();
		if(borrowMapper.findbybook(bookMapper.findbyname(string))==null) {
			data.put("msg",0);
		}else {
			data.put("msg",1);
			data.put("info",borrowMapper.findbybook(bookMapper.findbyname(string)));
		}
		
		
		return data;
	}

	@Override
	public Relation findbyuser(String string) {
		return null;
	}

	//借书
	@Override
	public void borrow(Relation relation) {
		borrowMapper.borrow(relation.getBook_id(), relation.getUser_id());
	}

	@Override
	public void rebook(Relation relation) {
		borrowMapper.rebook(relation.getBook_id(),relation.getUser_id());
	}


}
