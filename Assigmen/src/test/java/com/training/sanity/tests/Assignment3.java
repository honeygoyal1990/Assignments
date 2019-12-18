package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
import com.training.pom.OrdersPage;
import com.training.pom.ProductReturnPage;
import com.training.pom.ProductsPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.training.pom.customerPage;
import com.training.pom.AddProductsPage;
import com.training.pom.BillingDetailsPage;
import com.training.pom.GuestPage;
import com.training.pom.LocatorInfo;
import com.training.pom.salesPage;
import com.training.pom.shoppingCartPage;

public class Assignment3 {

	private WebDriver driver;
	private String baseUrl,url;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	GuestPage guest=new GuestPage();
	ProductsPage prods=new ProductsPage();
	LocatorInfo loc=new LocatorInfo();
	OrdersPage order=new OrdersPage();
	BillingDetailsPage bill = new BillingDetailsPage();
	String username,password;
	salesPage sale=new salesPage();
	String expectedmsg = "Success: You have modified products!";
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
		url=properties.getProperty("URL");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test()
	public void Catalog() throws InterruptedException
	{
		int Counter=0;
		Actions act =new Actions(driver);
		getProduct(act);
		btnClick(prods.getaddBtn(driver));
		txtSend(prods.gettxtnewProd(driver),"Socks1");
		txtSend(prods.gettxtNewProdMeta(driver),"White Socks");
		btnClick(prods.getDataTab(driver));
		txtSend(prods.gettxtNewModel(driver),"SCK-014");
		txtSend(prods.gettxtNewPrice(driver),"200");
		txtSend(prods.getqtyTextBox(driver),"20");
		prods.getLinksTab(driver).click();
		txtSend(prods.gettxtCategory(driver),"Sports Wear");
		List<WebElement> list=prods.getgrpCategory(driver);
		System.out.println(list.size());
		
		for(WebElement we :list) {
			System.out.println(we.getText());
			if(we.getText().contains("Sports Wear")) {
				we.click();
				Counter=1;
				
			}
			if(Counter==1)
				break;
		}
		
		btnClick(prods.getsaveBtn(driver));
		Assert.assertEquals(expectedmsg.contains(prods.getmsg(driver).getText()),true);
			
	}
@Test(priority=1)
void ProductaddGuest() throws InterruptedException {
	int size;
	 WebElement bodyElement = driver.findElement(By.tagName("body"));
	 
	 
			  bodyElement.sendKeys(Keys.CONTROL + "t");
		  Thread.sleep(1000);
		  System.out.println("Open a newtab.");
	  
	
	driver.get(url);
	Actions act =new Actions(driver);
	act.moveToElement(guest.getImgprod(driver)).click().build().perform();
	Thread.sleep(500);
	//guest.getAddBtn(driver).click();
	//Thread.sleep(500);
	Select select = new Select(guest.getSelectChestSize(driver));
	select.selectByVisibleText("42");
	btnClick(guest.getcartbtn(driver));
	btnClick(guest.getShoppingbtn(driver));
	
	btnClick(guest.getViewCart(driver));
	
	btnClick(guest.getchkoutBtn(driver));
	
	guest.getRdGuest(driver).click();
	btnClick(guest.getContBtn(driver));
	
	bill.gettxtFirstName(driver).sendKeys("abc2");
	bill.gettxtLastName(driver).sendKeys("xyz2");
	bill.gettxtEmail(driver).sendKeys("abc@test.com");
	bill.gettxtphone(driver).sendKeys("123456789");
	bill.gettxtAddress1(driver).sendKeys("abc1");
	bill.gettxtCity(driver).sendKeys("City");
	bill.gettxtPostCode(driver).sendKeys("123456");
	Select sel=new Select(bill.getSelectlistCountry(driver));
	sel.selectByVisibleText("India");
	sel=new Select(bill.getlistRegion(driver));
	sel.selectByVisibleText("Haryana");
	if(bill.getchkbox(driver).isSelected()==false)
		btnClick(bill.getchkbox(driver));
	btnClick(bill.getcontBtn(driver));
	
	if(bill.getfreeship(driver).isSelected()==false)
			bill.getfreeship(driver).click();
	bill.gettxtarea(driver).sendKeys("Testing");
	
	btnClick(bill.getcontBtn2(driver));
	
	if(bill.getagree(driver).isSelected()==false)
		btnClick(bill.getagree(driver));
	
	btnClick(bill.getcontBtn3(driver));

	btnClick(bill.getcontBtn4(driver));
Thread.sleep(3000);
}
@Test(priority=2,dependsOnMethods="ProductaddGuest")
void test1() throws InterruptedException
{
	driver.get(baseUrl);
	loc.getUsername(driver).sendKeys(username);
	loc.getPassword(driver).sendKeys(password);
	loc.logBtn(driver).click();
	Actions act=new Actions(driver);
	act.moveToElement(sale.getsalesMenu(driver)).build().perform();
	Thread.sleep(1000);
	
	sale.getsalesSubMenu(driver).click();
	if(order.gettrOrderList(driver).findElement(By.xpath("./td[3]")).getText().contains("abc2 xyz2"))
		btnClick(order.gettrOrderList(driver).findElement(By.xpath("./td[8]/a")));
	Select sel = new Select(order.getselorderStatus(driver));
	sel.selectByVisibleText("Complete");
	btnClick(order.getbtnaddhistory(driver));
	
}
	public void getProduct(Actions act) throws InterruptedException {
		act.moveToElement(prods.getProdMenu(driver)).build().perform();
		Thread.sleep(500);
		prods.getprodSubMenu(driver).click();
		Thread.sleep(500);
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
