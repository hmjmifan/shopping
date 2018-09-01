package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.demo.service.BingInfo;
import com.example.demo.service.NowInfo;
import com.example.demo.service.Relation;

public interface BorrowMapper {
	
	@Select("select * from relation where book_id=#{i}")
	Relation findbybook(int i);
	
	@Insert("insert into relation(book_id,user_id,record) values(#{bookid},#{userid},1)")
	void borrow(int bookid,int userid);
	
	@Delete("delete from relation where user_id=#{userid} and  book_id=#{bookid}")
	void rebook(int bookid,int userid);
	
	@Select("select name,bookname,author,picture,clazz from user,book,relation,classify where user_id=user.id and book_id =book.id and classify.id=book.classify and user_id=#{i};")
	List<NowInfo> now(int i);
	
	@Select("select clazz,count(book.classify) num from classify,book where classify.id=book.classify group by book.classify;")
	List<BingInfo> bing();
}
