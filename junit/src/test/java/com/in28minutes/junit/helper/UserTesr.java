package com.in28minutes.junit.helper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserTesr {

	@Rule 
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testUsernameTooShort() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Username is too short");
		User user = new User();
		user.setName("JM");
	}

}
