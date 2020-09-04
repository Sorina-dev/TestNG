package com.class03.DataProvider_Grouping;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * TC 1: HRMS Add Employee: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Add 5 different Employees and create login credentials by providing: 
First Name
Last Name
Username
Password
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.
Admin
Hum@nhrm123
 */
public class Homework { //refresh after each time, when getting the employees

	public static WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws InterruptedException {
		//navigate to the url
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
		driver.navigate().to(url);
		driver.navigate().refresh();
	
	}
	
	@AfterMethod(alwaysRun=true)
	public void quitBrowser() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "AnneS", "AnneS123#%&", "Anne", "Smith" },
				{ "AndrewL", "AndrewL123#%&*", "Andrew", "Locksmith" },
				{ "BenjaminM", "Ben123#%&$", "Benjamin", "Mathers" },
				{ "BeyonceC", "BeyonceC123#%&", "Beyonce", "Carter" },
				{ "JessieRo", "JessieR0123#%&//", "Jessie", "Rodrigues" } };
		return data;
	}
	
	@Test (dataProvider = "getData", groups="smoke")
	public void addEmployee(String userName, String password, String firstName, String lastName) throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='divUsername']/child::input")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//div[@id='divLoginButton']/child::input")).click();
        Thread.sleep(3000);
        //Add employee
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/child::b")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Add Employee")));
        driver.findElement(By.linkText("Add Employee")).click();
        driver.findElement(By.cssSelector("input#firstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(2000);
       
      
	}
	
	@Test(dataProvider="getData",groups="smoke")
     public void getEmployee(String userName, String password, String firstName, String lastName) throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='divUsername']/child::input")).sendKeys(userName);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(password);
		driver.findElement(By.xpath("//div[@id='divLoginButton']/child::input")).click();
        Thread.sleep(3000); 
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a#welcome")));
        WebElement text = driver.findElement(By.cssSelector("a#welcome"));
        String actualText = text.getText();
        Assert.assertEquals(actualText,"Welcome "+firstName, "the welcome mesage doesn't match");
        System.out.println(actualText);
        
        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
         try {
         FileUtils.copyFile(srcFile, new File("screenshots\\HW\\"+firstName +".png"));
         }catch(IOException e) {
         	e.printStackTrace();
         }
         Thread.sleep(2000);
	}
	

}
