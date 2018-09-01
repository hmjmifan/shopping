package com.example.demo.service;

public class BingInfo {
	String clazz;
	int num;
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "BingInfo [clazz=" + clazz + ", num=" + num + "]";
	}
	
}
