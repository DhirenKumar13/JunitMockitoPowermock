package org.doInjava.data.api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.doInjava.data.business.TodoBusinessImpl;
import org.junit.Before;
import org.junit.Test;

public class TodoServiceBDDMockTest {

	private TodoService mockService;
	private TodoBusinessImpl impl;

	@Before
	public void initialSetup() {
		mockService = mock(TodoService.class);
		impl = new TodoBusinessImpl(mockService);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_WithEmptyList() {

		// Given
		List<String> mockedList = Arrays.asList("");
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		List<String> filteredList = impl.retrieveTodosRelatedToSpring("FullList");

		// Then
		assertThat(filteredList.size(), is(0));
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_WithList() {
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		List<String> filteredList = impl.retrieveTodosRelatedToSpring("FullList");

		// Then
		assertThat(filteredList.size(), is(3));
	}

}
