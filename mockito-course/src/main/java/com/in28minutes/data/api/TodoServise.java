package com.in28minutes.data.api;

import java.util.List;


//1. Create TodoServiseStub
//2. Test TodoBusinessImpl using Stub

public interface TodoServise {
	public List<String> retrieveTodos(String user);	
	
	public void deleteTodo(String todo);

	public TodoServise should();
}
