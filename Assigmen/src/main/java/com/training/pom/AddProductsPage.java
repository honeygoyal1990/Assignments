package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductsPage {
	By Producttxtbox=By.xpath("//input[@id='input-product']");
	By qtytxtbox=By.xpath("//input[@id='input-quantity']");
	By AddBtn = By.xpath("//button[@id='button-product-add']");
By cartBtn = By.xpath("//button[@id='button-cart']");
By PaymentBtn = By.xpath("//button[@id='button-payment-address']");
	By ShippingnBTn=By.xpath("//button[@id='button-shipping-address']");
	By saveBtn=By.xpath("//button[@id='button-save']");
	
public WebElement getprodtxtbox(WebDriver driver) {
		
		return driver.findElement(this.Producttxtbox);
		
	}

public WebElement getqtytxtbox(WebDriver driver) {
	
	return driver.findElement(this.qtytxtbox);
	
}
public WebElement getAddBtn(WebDriver driver) {
	
	return driver.findElement(this.AddBtn);
	
}	
public WebElement getCartBtn(WebDriver driver) {
	
	return driver.findElement(this.cartBtn);
	
}
public WebElement getPaymenntBtn(WebDriver driver) {
	
	return driver.findElement(this.PaymentBtn);
	
}
public WebElement getShippingbtn(WebDriver driver) {
	
	return driver.findElement(this.ShippingnBTn);
	
}


public WebElement getsaveBtn(WebDriver driver) {
	
	return driver.findElement(this.saveBtn);
	
}

}
