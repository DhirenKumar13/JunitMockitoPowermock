package com.inSpringBootJunit.UnitTestingSpringApplication.business;

public class SomeBusinessImpl {
	
	private SomeDataService dataService;
	
	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}

	public int addTheArray(int[] array) {
		int sum = 0;
		for(int data : array)
			sum += data;
		return sum;
	}	
	
	public int addTheArrayUsingDataService() {
		int sum = 0;
		int[] array = dataService.retrieveAllData();
		for(int data : array)
			sum += data;
		return sum;
	}	
	
}
