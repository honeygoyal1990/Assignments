package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LocatorInfo;
import com.training.pom.LoginPOM;
import com.training.pom.ProductsPage;
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
	ProductsPage prods=new ProductsPage();
	shoppingCartPage shop=new shoppingCartPage();
	String username,password;
	String expectedmsg = "Success: You have modified products!";
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
	
	
	@Test()
	public void Catalog() throws InterruptedException
	{
		int editProduct=0;
		Actions act =new Actions(driver);
		getProduct(act);
		editProduct=prods.getBtn(driver).size();
		Assert.assertNotEquals(editProduct, 0);
		prods.geteditbtn(driver).click();
		Thread.sleep(500);
		prods.getDataTab(driver).click();
		Thread.sleep(500);
		prods.getqtyTextBox(driver).clear();
		prods.getqtyTextBox(driver).sendKeys("100");
				prods.getsaveBtn(driver).click();
		Thread.sleep(500);
				Assert.assertEquals(expectedmsg.contains(prods.getmsg(driver).getText()),true);
			
	}

	public void getProduct(Actions act) throws InterruptedException {
		act.moveToElement(prods.getProdMenu(driver)).build().perform();
		Thread.sleep(1000);
		prods.getprodSubMenu(driver).click();
		Thread.sleep(1000);
	}	
	@Test(priority=1)
	void delete() throws InterruptedException
	{
		int i=1;
		
		Actions act =new Actions(driver);
		getProduct(act);
		String expected=properties.getProperty("expectedProd");
		Assert.assertEquals(driver.findElement(By.xpath("//form[@id='form-product']//div//table//tbody//tr//td[contains(text(),'"+expected+"')]")).getText(), expected);
		
		int size=driver.findElements(By.xpath("//form[@id='form-product']//div//table//tbody//tr//td[contains(text(),'"+expected+"')]")).size();
		List<WebElement> list=driver.findElements(By.xpath("//form[@id='form-product']//div//table//tbody//tr//td[contains(text(),'"+expected+"')]"));
		System.out.println("Size is "+size);
		for(WebElement we:list)
		{
			if(expected.equals(we.getText()))
			{
				System.out.println("hey");
				
					we.findElement(By.xpath("./parent::tr")).findElement(By.xpath("./td[1]")).click();
				System.out.println(we.findElement(By.xpath("./parent::tr")).findElement(By.xpath("./td[6]")).getText());
				
			}
			
		}
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		driver.switchTo().alert().accept();
	
			Thread.sleep(1000);
		
		Assert.assertEquals(expectedmsg.contains(prods.getmsg(driver).getText()),true);
	}
	@Test(priority=2)
	void orders() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(shop.getshopMenu(driver)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(shop.getorderMenu(driver)).click().build().perform();
		int editProduct=shop.getBtn(driver).size();
		Assert.assertNotEquals(editProduct, 0);
		Thread.sleep(1000);
		shop.geteditbtn(driver).click();
		Thread.sleep(500);
		shop.getContinue(driver).click();
		Thread.sleep(1000);
	}
}

