package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.service.User;

public interface UserMapper {
	@Select("select * from user where name=#{name}")
	@Results({
		 @Result(column="name",property="name")
	})
	User FindByName(String name);
	
	@Insert("insert into user(name,password,grade) values(#{name},#{password},0)")
	void add(User user);
	
	void update(User user);
	
	@Select("select password from user where name=#{name}")
	String passright(String name);
}
