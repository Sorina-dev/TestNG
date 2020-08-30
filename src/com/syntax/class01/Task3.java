package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * TC 1: HRMS Application Login: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username and password
Click on login button
Then verify Syntax Logo is displayed
Close the browser

username: Admin
password: Hum@nhrm123
 */
public class Task3 {

	public static WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}
	
	@Test (priority = 2)
	public void validCredentials() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority = 1)
	public void logoDisplayed() {
		WebElement logo = driver.findElement(By.xpath("//img[@src='/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/themes/default/images/login/syntax.png']"));
	    boolean logodisplayed = true;
	    if(logo.isDisplayed()) {
	    	System.out.println("Logo is displayed. Test pass");
	    }else {
	    	System.out.println("Logo is NOT displayed. Test fail");
	    }
	}
	
	@Test (priority = 3) //which test executes first
	public void passwordEmpty() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		WebElement errorText = driver.findElement(By.id("spanMessage"));
		String excpetedTest = "Password cannot be empty";
		String actualText = errorText.getText();
		if(actualText.equals(excpetedTest)) {
		System.out.println("Password cannot be empty -- message is displayed. Test Pass");
		}else {
			System.out.println("Test Fail");
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	  
}
