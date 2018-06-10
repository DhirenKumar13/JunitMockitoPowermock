package org.doInjava.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListInterfaceMockTest {
	
	private List mockedList;

	@Before
	public void initialSetup() {
		mockedList = mock(List.class);
	}

	@Test
	public void listMethodMock_SizeMethod() {
		when(mockedList.size()).thenReturn(2);
		assertEquals(2,mockedList.size());
	}
	
	@Test
	public void listMethodMock_SizeMethod_MultipleSameReturns() {
		when(mockedList.size()).thenReturn(2);
		when(mockedList.size()).thenReturn(2);
		when(mockedList.size()).thenReturn(2);
		assertEquals(2,mockedList.size());
		assertEquals(2,mockedList.size());
		assertEquals(2,mockedList.size());
	}
	
	@Test
	public void listMethodMock_SizeMethod_MultipleDifferntReturns() {
		when(mockedList.size()).thenReturn(2).thenReturn(3).thenReturn(4);
		assertEquals(2,mockedList.size());
		assertEquals(3,mockedList.size());
		assertEquals(4,mockedList.size());
	}
	
	@Test
	public void listMethodMock_GetMethod_OneArgumentReturn() {
		when(mockedList.get(0)).thenReturn(2);
		assertEquals(2,mockedList.get(0));
	}
	
	@Test
	public void listMethodMock_GetMethod_DefaultOneArgumentReturn() {
		when(mockedList.get(0)).thenReturn(2);
		assertEquals(null,mockedList.get(1));
		//feature of nice mock by mockito
	}
	
	@Test
	public void listMethodMock_GetMethod_AnyIndexReturn() {
		when(mockedList.get(anyInt())).thenReturn(2);
		assertEquals(2,mockedList.get(1));
		assertEquals(2,mockedList.get(0));
		assertEquals(2,mockedList.get(100));
	}
	
	@Test(expected=RuntimeException.class)
	public void listMethodMock_GetMethod_AnyIndexReturnThrowingException() {
		when(mockedList.get(anyInt())).thenThrow(new RuntimeException("Thrown by mockito"));
		mockedList.get(1);
	}
	
}
