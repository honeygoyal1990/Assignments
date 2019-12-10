package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LocatorInfo;
import com.training.pom.LoginPOM;
import com.training.pom.customerPage;
import com.training.pom.salesPage;
import com.training.pom.shoppingCartPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment2 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	LocatorInfo loc=new LocatorInfo();
	customerPage cust=new customerPage();
	salesPage sale=new salesPage();
	shoppingCartPage shop=new shoppingCartPage();
	String username,password;
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("AdminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		username=properties.getProperty("AdminUsername");
		password=properties.getProperty("AdminPassword");
		loc.getUsername(driver).sendKeys(username);
		loc.getPassword(driver).sendKeys(password);
		loc.logBtn(driver).click();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test
	public void Catalog() throws InterruptedException
	{
		int editProduct=0;
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[2]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='menu']/li[2]/ul/li[2]")).click();
		
		Thread.sleep(1000);
		editProduct=driver.findElements(By.xpath("//a[@class='btn btn-primary']")).size();
		Assert.assertNotEquals(editProduct, 0);
		
	}	
}
