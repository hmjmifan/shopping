package com.example.demo.service;

import java.util.HashMap;

public interface RelationService {
	
	public HashMap<String,Object> findbybookname(String string);
	
	public Relation findbyuser(String string);
	
	public void borrow(Relation relation);
	
	public void rebook(Relation relation);
}
