package com.example.demo.service;

public class BookClassify {
	int id;
	String clazz;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassify() {
		return clazz;
	}
	public void setClassify(String classify) {
		this.clazz = classify;
	}
	@Override
	public String toString() {
		return "BookClassify [id=" + id + ", clazz=" + clazz + "]";
	}
	
}
