package com.inSpringBootJunit.UnitTestingSpringApplication.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inSpringBootJunit.UnitTestingSpringApplication.business.SomeBusinessImpl;
import com.inSpringBootJunit.UnitTestingSpringApplication.business.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {
	
	@Mock
	private SomeDataService someDataService;
	
	@InjectMocks
	private SomeBusinessImpl impl;
	
	@Test
	public void testArrayWithItems() {
		when(someDataService.retrieveAllData()).thenReturn(new int[] {1,2,3,4});
		int addTheArray = impl.addTheArrayUsingDataService();
		assertEquals(10,addTheArray);
	}
	
	@Test
	public void testArrayWithoutItems() {
		when(someDataService.retrieveAllData()).thenReturn(new int[] {});
		int addTheArray = impl.addTheArrayUsingDataService();
		assertEquals(0,addTheArray);
	}

}
