package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoServise;

//TodoBusinessImol SUT (system under test)
//TodoServise Dependency
public class TodoBusinessImpl {

	private TodoServise todoServise;

	public TodoBusinessImpl(TodoServise todoServise) {
		super();
		this.todoServise = todoServise;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoServise.retrieveTodos(user);

		for (String todo : todos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user) {

		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoServise.retrieveTodos(user);

		for (String todo : todos) {
			if (!todo.contains("Spring")) {
				todoServise.deleteTodo(todo);
			}
		}
	}
}
