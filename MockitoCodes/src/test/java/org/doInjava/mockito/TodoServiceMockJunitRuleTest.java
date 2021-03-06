package org.doInjava.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.doInjava.data.api.TodoService;
import org.doInjava.data.business.TodoBusinessImpl;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TodoServiceMockJunitRuleTest {
	
	//Rule can be multiple ;
	//where as Runner is always single for a class
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	private TodoService mockService;
	
	@InjectMocks
	private TodoBusinessImpl impl;
	
	@Captor
	private ArgumentCaptor<String> stringArgumentCaptor;

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
	
	@Test
	public void deleteTodosNotRelatedToSpring_WithArgumentCaptor() {
		
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
	}
	
}
