package com.class01.Intro_Annotations;

import org.testng.annotations.Test;

public class TestNGIntro {
   
	@Test //we use this annotation to mark a method as a test method
	public void testOne() {
		System.out.println("I am test case one");
	}
	@Test
	public void testTwo() {
		System.out.println("I am test case 2");
	}
	@Test
	public void testThree() {
		System.out.println("I am test case 3");
	}
	@Test
	public void testFour() {
		System.out.println("I am test case 4");
	}
	//all test methods will get executed in alphabetical order
}
