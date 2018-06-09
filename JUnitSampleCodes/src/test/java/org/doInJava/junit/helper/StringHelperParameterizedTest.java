package org.doInJava.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	
	private StringHelper helper = new StringHelper();
	private String inputs,outputs;
	
	public StringHelperParameterizedTest(String inputs, String outputs) {
		super();
		this.inputs = inputs;
		this.outputs = outputs;
	}

	@Parameters
	public static Collection<String[]> testConditions(){
		String [][]testCases = {
				{"AACD","CD"},
				{"ACD","CD"},
				{"AA",""},
				{"A",""},
				{"AD","D"}
		};
		return Arrays.asList(testCases);
	}
	
	@Test
	public void truncateAInFirst2PositionsSuccessTest() {
		assertEquals(outputs,helper.truncateAInFirst2Positions(inputs));
	}
	
}
