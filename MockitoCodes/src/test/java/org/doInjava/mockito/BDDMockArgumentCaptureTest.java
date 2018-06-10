package org.doInjava.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.doInjava.data.api.TodoService;
import org.doInjava.data.business.TodoBusinessImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class BDDMockArgumentCaptureTest {

	private TodoService mockService;
	private TodoBusinessImpl impl;

	@Before
	public void initialSetup() {
		mockService = mock(TodoService.class);
		impl = new TodoBusinessImpl(mockService);
	}

	@Test
	public void deleteTodosNotRelatedToSpring_WithoutArgumentCaptor() {
		
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		verify(mockService).deleteTodo("JavaSE and JavaEE intermediate");
		then(mockService).should().deleteTodo("JavaSE and JavaEE intermediate");
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_WithArgumentCaptor() {
		
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		// Given
		List<String> mockedList = Arrays.asList("Spring For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		verify(mockService).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getValue(),is("JavaSE and JavaEE intermediate"));
		then(mockService).should().deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getValue(),is("JavaSE and JavaEE intermediate"));
	}
	
	@Test
	public void deleteTodosNotRelatedToSpring_WithArgumentCaptorMultipleTimes() {
		
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		// Given
		List<String> mockedList = Arrays.asList("Java For Beginners", 
				"Spring Boot Starters", "Spring Cloud Starters",
				"JavaSE and JavaEE intermediate");
		
		given(mockService.retrieveTodos("FullList")).willReturn(mockedList);

		// When
		impl.deleteTodosNotRelatedToSpring("FullList");

		// Then
		verify(mockService,times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
		then(mockService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getAllValues().size(),is(4));
		
		//assertThat(stringArgumentCaptor.getAllValues().size(),is(4)); will fail here
	}
	
}
