package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPage {
	By imgprod=By.xpath("//a[@href='http://uniformm1.upskills.in/index.php?route=product/product&product_id=186']");
	By AddBtn = By.xpath("//button[@class='add_cart']");
By selectChestSize = By.xpath("//body/div[@class='container']/div/div//div[@class='row']/div[@class='col-sm-8 product-middle']/div/div/select");
By cartBtn = By.xpath("//body/div[@class='container']/div/div//div[@class='row']/div[@class='col-sm-8 product-middle']/div/div[@class='form-group quntity']/button[@id='button-cart']");
	By ShoppingnCartBTn=By.xpath("//div[@id='cart']/button");
	
	By viewCart=By.xpath("//a[@href='http://uniformm1.upskills.in/index.php?route=checkout/cart']");
	By checkOutBtn= By.xpath("//div[@class='buttons']/div[@class='pull-right']/a[@href='http://uniformm1.upskills.in/index.php?route=checkout/checkout']");
	By radioGuest= By.xpath("//input[@name='account' and @value='guest']");
	
	By ContBtn=By.xpath("//input[@id='button-account']");
	
	
public WebElement getImgprod(WebDriver driver) {
		
		return driver.findElement(this.imgprod);
		
	}
public WebElement getContBtn(WebDriver driver) {
	
	return driver.findElement(this.ContBtn);
	
}
public WebElement getRdGuest(WebDriver driver) {
	
	return driver.findElement(this.radioGuest);
	
}
public WebElement getchkoutBtn(WebDriver driver) {
	
	return driver.findElement(this.checkOutBtn);
	
}
public WebElement getViewCart(WebDriver driver) {
	
	return driver.findElement(this.viewCart);
	
}
public WebElement getcartbtn(WebDriver driver) {
	
	return driver.findElement(this.cartBtn);
	
}
public WebElement getAddBtn(WebDriver driver) {
	
	return driver.findElement(this.AddBtn);
	
}	
public WebElement getSelectChestSize(WebDriver driver) {
	
	return driver.findElement(this.selectChestSize);
	
}

public WebElement getShoppingbtn(WebDriver driver) {
	
	return driver.findElement(this.ShoppingnCartBTn);
	
}




}
