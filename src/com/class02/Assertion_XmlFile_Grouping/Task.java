package com.class02.Assertion_XmlFile_Grouping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 * Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Add a picture to the profile
Verify Employee has been added successfully
Close the browser
 */
public class Task {
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
	public void validLogin() throws InterruptedException { //2nd one by alphabetical order
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		//Full Name
		Thread.sleep(2000);
		WebElement fullName = driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']"));
		WebElement employeeId = driver.findElement(By.xpath("//label[@for='employeeId']"));
		WebElement pic = driver.findElement(By.xpath("//label[@for='photofile']"));

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(fullName.isDisplayed());
		softAssertion.assertTrue(employeeId.isDisplayed() );
		softAssertion.assertTrue(pic.isDisplayed());
	
		driver.findElement(By.id("firstName")).sendKeys("Maria");
		driver.findElement(By.id("lastName")).sendKeys("Smith");
		
		driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\crist\\OneDrive\\Desktop\\Picture.jpg");
		driver.findElement(By.id("btnSave")).click();
		WebElement picture = driver.findElement(By.id("empPic"));
		softAssertion.assertTrue(picture.isDisplayed(), "Picture is displayed, The employee was added succesefully.");
		
	}
	
}
