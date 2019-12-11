package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ProductReturnPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.training.pom.customerPage;
import com.training.pom.LocatorInfo;
import com.training.pom.salesPage;
import com.training.pom.shoppingCartPage;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	LocatorInfo loc=new LocatorInfo();
	customerPage cust=new customerPage();
	salesPage sale=new salesPage();
	shoppingCartPage shop=new shoppingCartPage();
	ProductReturnPage prod=new ProductReturnPage();
	String username,password;
	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
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
	
	
	@Test(priority=1)
	public void Customer() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(cust.getCustMenu(driver)).build().perform();
		Thread.sleep(1000);
		int i,countOfElement;
		String[] expectedEle= {"Customers","Customer Groups","Custom Fields"};
		countOfElement=cust.getcustSubMenu(driver).size();
	
		for(i=0;i<countOfElement;i++) {
			org.testng.Assert.assertEquals(expectedEle[i],cust.getcustSubMenu(driver).get(i).getText());
			//Assert.assertEquals(expectedEle[i],cust.getcustSubMenu(driver).get(i).getText());
			
		}
		act.moveToElement(cust.getcustSubMenu(driver).get(0)).click().build().perform();
		Thread.sleep(1000);
	cust.getcustName(driver).sendKeys("Neha");
	cust.getFilter(driver).click();
	if(cust.getTableRow(driver).size()==1) 
	{
		if(cust.getTableData(driver).size()==1)
		System.out.println("No Result Found");
		else
			System.out.println("1 result found");
	}
	else
		System.out.println(cust.getTableRow(driver).size()+" results found");
	Thread.sleep(1000);
	cust.getEmail(driver).sendKeys("neha1@gmail.com");
	cust.getFilter(driver).click();

		if(cust.getTableRow(driver).size()==1) 
		{
			if(cust.getTableData(driver).size()==1)
			System.out.println("No Result Found");
			else
				System.out.println("1 result found");
		}
		else
			System.out.println(cust.getTableRow(driver).size()+" results found");
		
	}
	@Test(priority=2)
	public void Sales() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(sale.getsalesMenu(driver)).build().perform();
		Thread.sleep(1000);
		
		act.moveToElement(sale.getSubMenu(driver).get(0)).click().build().perform();
		Thread.sleep(1000);
		int i,countOfElement;
		String[] expectedEle= {"Orders","Tax","Shipping","Returns","Coupons"};
		countOfElement=sale.getSubMenu(driver).size();
	
		for(i=0;i<countOfElement;i++) {
			org.testng.Assert.assertEquals(expectedEle[i],sale.getsalesSubMenu(driver).get(i).getText());
			
			
		}
	
		act.moveToElement(sale.getsalesSubMenu(driver).get(3)).click().build().perform();
		Thread.sleep(1000);
	
		
	}

	@Test()
	public void shoppingCart() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(shop.getshopMenu(driver)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(shop.getshopSubMenu(driver)).click().build().perform();
		Thread.sleep(1000);
	shop.getTextBox(driver).sendKeys("1");
	shop.filter(driver).click();
	Thread.sleep(1000);
	if(shop.getTableData(driver).size()==1) {
		System.out.println("0 Result Found");
	}

	else
		System.out.println(shop.getTableRow(driver).size()+" result found");
					
	}
	@Test(priority=3)
	public void productReturn() throws InterruptedException {
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(prod.getshopMenu(driver)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(prod.getshopSubMenu(driver)).click().build().perform();
		Thread.sleep(1000);
	prod.getTextBox(driver).sendKeys("207");
	prod.filter(driver).click();
	Thread.sleep(1000);
	prod.getCustTextBox(driver).sendKeys("Renu");
	prod.filter(driver).click();
	Thread.sleep(1000);
	
	if(prod.getTableData(driver).size()==1) {
		System.out.println("0 Result Found");
	}

	else
		System.out.println(prod.getTableRow(driver).size()+" result found");
					
	}
	
	

}
