package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProductsPage;
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
	AddProductsPage addProd=new AddProductsPage();
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
	
	
	@Test(enabled=false)
	public void Catalog() throws InterruptedException
	{
		int editProduct=0;
		Actions act =new Actions(driver);
		getProduct(act);
		editProduct=prods.getBtn(driver).size();
		Assert.assertNotEquals(editProduct, 0);
		btnClick(prods.geteditbtn(driver));
		btnClick(prods.getDataTab(driver));
		txtSend(prods.getqtyTextBox(driver),"100");
		btnClick(prods.getsaveBtn(driver));
		Assert.assertEquals(expectedmsg.contains(prods.getmsg(driver).getText()),true);
			
	}

	public void getProduct(Actions act) throws InterruptedException {
		act.moveToElement(prods.getProdMenu(driver)).build().perform();
		Thread.sleep(1000);
		prods.getprodSubMenu(driver).click();
		Thread.sleep(1000);
	}	
	@Test(priority=1,enabled=false)
	void delete() throws InterruptedException
	{
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
				btnClick(we.findElement(By.xpath("./parent::tr")).findElement(By.xpath("./td[1]")));
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
		btnClick(shop.geteditbtn(driver));
		btnClick(shop.getContinue(driver));
		
		
		try {
			if(driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td")).size()==1)
			{
				if(driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td")).getText().contains("No Result"))
				System.out.println("No Element to delete");
			}
			else {
		if(driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[contains(text(),'REGULAR T-SHIRTS (Rust) ')]")).isDisplayed()) {
			
	System.out.println("Item deleted");
			btnClick(driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]/button[@data-original-title='Remove']")));
		}		}
		}
		catch(NullPointerException e) {
			e.printStackTrace();}
		
		
		finally {
			//txtSend(addProd.getprodtxtbox(driver),"Blazer");
			//txtSend(addProd.getqtytxtbox(driver),"1");
		//	btnClick(addProd.getAddBtn(driver));	
		
		btnClick(addProd.getCartBtn(driver));
		btnClick(addProd.getPaymenntBtn(driver));
		btnClick(addProd.getShippingbtn(driver));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		
		btnClick(addProd.getsaveBtn(driver));}
				
	}
	void btnClick(WebElement we) throws InterruptedException
	{
		we.click();
		Thread.sleep(1000);
	}
	void txtSend(WebElement we,String str) throws InterruptedException
	{
		we.clear();
		we.sendKeys(str);
		Thread.sleep(500);
	}
}

