package com.class01.Intro_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Task 1: Executing different test based TestNG annotations

Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation

Observe the results!
 */
public class Task2 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("I am before class");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("I am before method");
	}
	@Test 
	public void Test1() {
		System.out.println("I am test 1");
	}
	
	@Test 
	public void Test2() {
		System.out.println("I am test 2");
	}
	
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("I am after Method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("I am after class");
	}

}
