package com.class02.Assertion_XmlFile_Grouping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	WebDriver driver;
	@BeforeMethod  
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
	driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	driver.manage().window().maximize();
	}
	
	@AfterMethod  
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void invalidLoginError() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("fhyehguhwe"); //wrong password
		driver.findElement(By.id("btnLogin")).click();
		
		//calling SoftAssert class
		SoftAssert softAssertion = new SoftAssert();//call it and import it
		String expcetedErrorMessage1 = "Invalid credential";//on purpose //Invalid credentials
		WebElement errorMessage = driver.findElement(By.id("spanMessage"));
		//1 validation
		softAssertion.assertEquals(errorMessage.getText(), expcetedErrorMessage1);
		Thread.sleep(3000);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys(""); //empty password
		driver.findElement(By.id("btnLogin")).click();
		String errorMessage2 = "Password cannot be";// on purpose //Password cannot be empty
		errorMessage = driver.findElement(By.id("spanMessage"));
		//2 validation
		softAssertion.assertEquals(errorMessage.getText(), errorMessage2);
		Thread.sleep(3000);

		System.out.println("----------The end of the code----------");
		
		//a MUST in softassertion at the end of the program
		softAssertion.assertAll();//to throw all failed assertions, cuz otherwise it will show as test passed
		
		
		
	}
	
	

}
