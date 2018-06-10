package org.doInjava.mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.doInjava.data.api.TodoService;
import org.doInjava.data.business.TodoBusinessImpl;
import org.junit.Before;
import org.junit.Test;

public class TodoDeleteMethodBDDMockTest {

	private TodoService mockService;
	private TodoBusinessImpl impl;

	@Before
	public void initialSetup() {
		mockService = mock(TodoService.class);
		impl = new TodoBusinessImpl(mockService);
	}

	@Test
	public void deleteTodosNotRelatedToSpring_VerifyMatchesCalled() {
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		verify(mockService).deleteTodo("JavaSE and JavaEE intermediate");
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_VerifyNotMatchesNotCalled() {
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		verify(mockService , never()).deleteTodo("Spring For Beginners");
		verify(mockService , never()).deleteTodo("Spring Boot Starters");
		verify(mockService , never()).deleteTodo("Spring Cloud Starters");
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_VerifyMatchesCalledHowManyTimes() {
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		verify(mockService,times(1)).deleteTodo("JavaSE and JavaEE intermediate");
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_VerifyMatchesCalledAtLeastOnce() {
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		verify(mockService,atLeastOnce()).deleteTodo("JavaSE and JavaEE intermediate");
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_VerifyMatches() {
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		then(mockService).should().deleteTodo("JavaSE and JavaEE intermediate");
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_VerifyNotMatches() {
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		then(mockService).should(never()).deleteTodo("Spring For Beginners");
		then(mockService).should(never()).deleteTodo("Spring Boot Starters");
		then(mockService).should(never()).deleteTodo("Spring Cloud Starters");
	}
	
}
