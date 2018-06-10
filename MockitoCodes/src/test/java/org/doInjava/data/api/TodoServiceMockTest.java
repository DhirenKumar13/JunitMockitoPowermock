package org.doInjava.data.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.doInjava.data.business.TodoBusinessImpl;
import org.junit.Before;
import org.junit.Test;

public class TodoServiceMockTest {
	
	private TodoService mockService;
	private TodoBusinessImpl impl;
	@Before
	public void initialSetup() {
		mockService = mock(TodoService.class);
		impl = new TodoBusinessImpl(mockService);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_WithList() {
		List<String> mockedList = Arrays.asList("Spring For Beginners" ,
				"Spring Boot Starters" , "Spring Cloud Starters" ,
				"JavaSE and JavaEE intermediate");
		when(mockService.retrieveTodos("FullList")).thenReturn(mockedList);
		List<String> filteredList = impl.retrieveTodosRelatedToSpring("FullList");
		assertEquals(3,filteredList.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_WithEmptyList() {
		List<String> mockedList = new ArrayList<>();
		when(mockService.retrieveTodos("Empty")).thenReturn(mockedList);
		List<String> filteredList = impl.retrieveTodosRelatedToSpring("Empty");
		assertEquals(0,filteredList.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_WithListNoMatches() {
		List<String> mockedList = Arrays.asList("Java For Beginners" ,
				"Hibernate Starters" , "AWS Cloud Starters" ,
				"JavaSE and JavaEE intermediate");
		when(mockService.retrieveTodos("FullNegativeList")).thenReturn(mockedList);
		List<String> filteredList = impl.retrieveTodosRelatedToSpring("FullNegativeList");
		assertEquals(0,filteredList.size());
	}
	
}
