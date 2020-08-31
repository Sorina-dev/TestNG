package com.class01.Intro_Annotations;

import org.testng.annotations.Test;

public class TestNGDependencies {

	@Test
	public void login() {//if login pass ONlY then execute checkReport
		System.out.println("Test that logges into the application");
	}
	// otherwise if login fail, then checkReport never executes and it will be skipped
	@Test(dependsOnMethods="login")  // executes after the Test method login()
	public void checkReport() {
		System.out.println("test that checks reports");
	}
	@Test(dependsOnMethods= {"login","checkReport"}) //when depends on 2 or more methods
	public void validation() {
		System.out.println("Test that checks the validation");
	}
	
}
