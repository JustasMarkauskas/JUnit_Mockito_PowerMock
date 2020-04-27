package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;
// DUMMY implementation
public class TodoServiceStub implements TodoServise{

	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

	public TodoServise should() {
		// TODO Auto-generated method stub
		return null;
	}

}
