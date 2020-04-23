package com.in28minutes.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}
	
	@Before
	public void setup() {
		System.out.println("Before test");
	}
	
	@After
	public void teardown() {
		System.out.println("After test");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1 executed");		
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2 executed");		
	}

}
