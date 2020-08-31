package com.class02.Assertion_XmlFile_Grouping;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("----------- This is Before Suite annotation -----");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("--------- This is Before Test annotation -----");
	}
	
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
	
	@AfterTest
	public void afterTest() {
		System.out.println("---------- This is After Test annotation --------");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("----------- This is After Suite annotation -----");
	}
	
}
