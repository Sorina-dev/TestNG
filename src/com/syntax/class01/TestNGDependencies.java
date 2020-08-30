package com.syntax.class01;

import org.testng.annotations.Test;

public class TestNGDependencies {

	@Test
	public void login() {
		System.out.println("Test that logges into the application");
	}
	
	@Test(dependsOnMethods="login")  // executes after the Test method login()
	public void checkReport() {
		System.out.println("test that checks reports");
	}
}
