package org.doInJava.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysClassTest {

	
	@Test
	public void testForArrarysSortSuccess() {
		Integer [] arr = {1,4,3,5,6,9};
		Integer [] arrResult = {1,3,4,5,6,9};
		Arrays.sort(arr);
		assertArrayEquals(arrResult, arr);
	}
	
	@Test(expected = NullPointerException.class)
	public void testForArrarysSortSuccessForException() {
		Integer [] arr = null;
		Arrays.sort(arr);
	}
	
	@Test
	public void testForArrarysSortSuccessForEmptyArray() {
		Integer [] arr = {};
		Integer [] arrResult = {};
		Arrays.sort(arr);
		assertArrayEquals(arrResult, arr);
	}
	
	@Test(timeout=185)
	public void testForArrarysSortPreformance() {
		Integer [] arr = {11,4,33,25,64,92};
		for(int i =0 ; i <= 10_000_00; i++) {
			arr[0] = i + 12;
			arr[arr.length - 1] = i;
			Arrays.sort(arr);
		}
	}
	
}
