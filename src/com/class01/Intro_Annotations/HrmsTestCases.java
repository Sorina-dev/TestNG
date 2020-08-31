package com.class01.Intro_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HrmsTestCases {

	public static WebDriver driver; //static for other methods to access it
	
	@BeforeMethod  //methods for each test
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
	driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	driver.manage().window().maximize();
	}
	
	@Test
	public void validLogin() { //2nd one by alphabetical order
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		
		if(welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in. Test Pass");
		}else {
			System.out.println("Admin is not Logged in. Test Fail");
		}
	}
	
	@Test
	public void titleValidation() { //1st one by alphabetical order
		String expectedTitle= "Human Management System";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Titles match. Test Pass");
		}else {
			System.out.println("Titles don't match. Test Fail");
		}	
	}
		
	@AfterMethod  // after each test
	public void closeBrowser() {
		driver.quit();
	}
} 
