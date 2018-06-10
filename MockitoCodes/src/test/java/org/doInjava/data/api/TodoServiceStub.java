package org.doInjava.data.api;

import java.util.Arrays;
import java.util.List;

import org.doInjava.data.api.TodoService;

public class TodoServiceStub implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Spring For Beginners" ,
				"Spring Boot Starters" , "Spring Cloud Starters" ,
				"JavaSE and JavaEE intermediate");
	}

	@Override
	public void deleteTodo(String name) {
	}

}
