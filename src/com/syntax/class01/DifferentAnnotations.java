package com.syntax.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations {

	@BeforeMethod
	public void before() {
		System.out.println("This is before method");
	}
	
	@Test
	public void testMethod() {
		System.out.println("This is actual Test method");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("This is Test method 2");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("This is after method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("-----  This is before class annotation -----");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("-----  This is after class annotation -----");
	}
	/*
-----  This is before class annotation -----
This is before method
This is actual Test method
This is after method
This is before method
This is Test method 2
This is after method
-----  This is after class annotation -----
PASSED: testMethod
PASSED: testMethod2
	 */
	
}
