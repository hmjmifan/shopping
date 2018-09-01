package com.example.demo.service;

public class NowInfo {
	String name;
	String bookname;
	String author;
	String picture;
	String clazz;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "NowInfo [name=" + name + ", bookname=" + bookname + ", author=" + author + ", picture=" + picture
				+ ", clazz=" + clazz + "]";
	}
	
}
