package org.doInJava.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	
	private StringHelper helper = new StringHelper();
	
	@Test
	public void truncateAInFirst2PositionsSuccessTest() {
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
		assertEquals("",helper.truncateAInFirst2Positions("AA"));
		assertEquals("",helper.truncateAInFirst2Positions("A"));
		assertEquals("D",helper.truncateAInFirst2Positions("AD"));
	}
	
	@Test
	public void truncateAInFirst2PositionsFailureTest() {
		assertNotEquals("CD",helper.truncateAInFirst2Positions("AAACD"));
		assertNotEquals("CD",helper.truncateAInFirst2Positions("DACD"));
		assertNotEquals("",helper.truncateAInFirst2Positions("DAA"));
		assertNotEquals("",helper.truncateAInFirst2Positions("AD"));
	}
	
	@Test
	public void areFirstAndLastTwoCharactersTheSameSuccessTest() {
		assertEquals(true,helper.areFirstAndLastTwoCharactersTheSame("ABSDSDAB"));
		assertTrue("Condition ABAB Failed",helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
		assertTrue("Condition AB Failed",helper.areFirstAndLastTwoCharactersTheSame("AB"));
		assertTrue("Condition AAAABABAA Failed",helper.areFirstAndLastTwoCharactersTheSame("AAAABABAA"));
	}
	
	@Test
	public void areFirstAndLastTwoCharactersTheSameFailureTest() {
		assertEquals(false,helper.areFirstAndLastTwoCharactersTheSame("CABSDSDAB"));
		assertFalse("Condition ASABAB Failed",helper.areFirstAndLastTwoCharactersTheSame("ASABAB"));
		assertFalse("Condition A Failed",helper.areFirstAndLastTwoCharactersTheSame("A"));
		assertFalse("Condition ASAAAAABABAA Failed",helper.areFirstAndLastTwoCharactersTheSame("ASAAAAABABAA"));
	}

}
