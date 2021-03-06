package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	// AACD => CD ACD => CD CDEF => CDEF CDAA=>CDAA

	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AInFirst2Positions() {
		String actual = helper.truncateAInFirst2Positions("AACD");
		String expected = "CD";
		assertEquals(expected, actual);
		// expected, actual 
	}

	@Test
	public void testTruncateAInFirst2Positions_AInFirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_NoA() {
		assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
	}

	@Test
	public void testTruncateAInFirst2Positions_AInTheEnd() {
		assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
	}
	
	// ABCD=>false, ABAB=>true, AB=>true, A=>false

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_PositiveScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_NegativeScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
	}
}
