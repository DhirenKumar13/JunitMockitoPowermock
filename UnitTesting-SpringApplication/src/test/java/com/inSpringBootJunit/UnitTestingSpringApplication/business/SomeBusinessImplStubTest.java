package com.inSpringBootJunit.UnitTestingSpringApplication.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.inSpringBootJunit.UnitTestingSpringApplication.business.SomeBusinessImpl;
import com.inSpringBootJunit.UnitTestingSpringApplication.business.SomeDataService;

class SomeDataServiceStub implements SomeDataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3,4};
	}
}

class SomeMoreDataServiceStub implements SomeDataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}


public class SomeBusinessImplStubTest {

	@Test
	public void testArrayWithItems() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setDataService(new SomeDataServiceStub());
		int addTheArray = impl.addTheArrayUsingDataService();
		assertEquals(10,addTheArray);
	}
	
	@Test
	public void testArrayWithoutItems() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setDataService(new SomeMoreDataServiceStub());
		int addTheArray = impl.addTheArrayUsingDataService();
		assertEquals(0,addTheArray);
	}

}
