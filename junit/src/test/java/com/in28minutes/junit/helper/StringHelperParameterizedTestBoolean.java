package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)
public class StringHelperParameterizedTestBoolean {
	
	StringHelper helper = new StringHelper();

	
	// ABCD=>false, ABAB=>true, AB=>true, A=>false

	private String input;
	private boolean expectedOutput;	
	
	public StringHelperParameterizedTestBoolean(String input, boolean expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static List<Object[]> testConditions(){
		Object expectedOutputs[][] = {{"ABCD",false},
									  {"ABAB",true},
									  {"AB",true},
									  {"A",false}};
		return Arrays.asList(expectedOutputs);
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		assertEquals(expectedOutput, helper.areFirstAndLastTwoCharactersTheSame(input));
	}
	
}
