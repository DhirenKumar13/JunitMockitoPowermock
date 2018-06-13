package com.inSpringBootJunit.UnitTestingSpringApplication.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.inSpringBootJunit.UnitTestingSpringApplication.business.SomeBusinessImpl;

public class SomeBusinessImplTest {

	@Test
	public void testArrayWithItems() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		int addTheArray = impl.addTheArray(new int[] {1,2,3,4});
		assertEquals(10,addTheArray);
	}
	
	@Test
	public void testArrayWithoutItems() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		int addTheArray = impl.addTheArray(new int[] {});
		assertEquals(0,addTheArray);
	}

}
