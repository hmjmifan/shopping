package com.example.demo.service;

public class Relation {
	int user_id;
	int book_id;
	int record;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	@Override
	public String toString() {
		return "Relation [user_id=" + user_id + ", book_id=" + book_id + ", record=" + record + "]";
	}
	
}
