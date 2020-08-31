package com.class02.Assertion_XmlFile_Grouping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dependency {
	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		// driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@Test(groups="smoke")
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPasswords")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		if (welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in. Test pass");
		} else {
			System.out.println("Admin is NOT logged in. Test fail");
		}
	}

	@Test(groups="regression",dependsOnMethods = "validLogin")//if validLogin pass ONLY then execute invalidLogin
								//otherwise if validLogin fails then DO NOT EXECUTE invalidLogin (invalid Login test will be skipped)
	public void invalidLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement message = driver.findElement(By.id("spanMessage"));
		String expectedMsg = "Password cannot be empty";
		String actualMsg = message.getText();
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test FAIL");
		}
	}
}
