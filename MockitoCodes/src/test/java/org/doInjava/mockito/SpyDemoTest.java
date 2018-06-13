package org.doInjava.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class SpyDemoTest {
	
	@Mock
	private List<Integer> mockedList;
	
	@Spy
	private ArrayList<Integer> spyList;
	
	@Test
	public void testMockedList() {
		assertEquals(0,mockedList.size());
		stub(mockedList.size()).toReturn(5);
		assertEquals(5,mockedList.size());
		mockedList.add(69);
		assertEquals(5,mockedList.size());
	}
	
	@Test
	public void testSpyedList() {
		assertEquals(0,spyList.size());
		spyList.add(69);
		assertEquals(1,spyList.size());
	}

}
