package org.doInjava.data.business;

import java.util.List;
import java.util.stream.Collectors;

import org.doInjava.data.api.TodoService;

public class TodoBusinessImpl {

	private TodoService service;

	public TodoBusinessImpl(TodoService service) {
		super();
		this.service = service;
	}

	public TodoService getService() {
		return service;
	}

	public void setService(TodoService service) {
		this.service = service;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {

		List<String> myList = service.retrieveTodos(user);

		List<String> filteredTodos = myList.stream().filter(item -> item.contains("Spring"))
				.collect(Collectors.toList());

		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user) {

		List<String> myList = service.retrieveTodos(user);

		myList.forEach(item -> {
			if(!item.contains("Spring")) {
				service.deleteTodo(item);
			}
		});

	}
}
