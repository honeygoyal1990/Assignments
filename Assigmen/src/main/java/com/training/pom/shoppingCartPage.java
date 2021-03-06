package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shoppingCartPage {
	By shoppingMenu=By.xpath("//ul[@id='menu']/li[@id='sale']");
	By shoppingSubMenu=By.xpath("//ul[@id='menu']/li[@id='sale']/ul/li/a[contains(text(),'Recurring Orders')]");
	By orderMenu=By.xpath("//ul[@id='menu']/li[@id='sale']/ul/li/a[contains(text(),'Orders')]");
By textBox = By.id("input-order-recurring-id");
By shopFilter = By.id("button-filter");
	By tr=By.xpath("//form[@id='form']/div/table/tbody/tr");
	By td=By.xpath("//form[@id='form']/div/table/tbody/tr/td");
	By editBtn = By.xpath("//form[@id='form-order']//div//table//tbody//tr//td[8]//a[@class='btn btn-primary'][1]");
	By Btn = By.xpath("//a[@class='btn btn-primary'][1]");
By continueBtn=By.xpath("//button[@id='button-customer']");
By trProduct = By.xpath("//form[@id='form-product']//div//table//tbody//tr");
By delBtn=By.xpath("//i[@class='fa fa-trash-o']");
By trOrder = By.xpath("//table[@class='table table-bordered']/tbody/tr");
public WebElement getTableRowProduct(WebDriver driver) {
	
	return driver.findElement(this.trProduct);
	
}
public WebElement getTableRowOrder(WebDriver driver) {
	
	return driver.findElement(this.trOrder);
	
}
	public WebElement getshopMenu(WebDriver driver) {
		
		return driver.findElement(this.shoppingMenu);
		
	}
public WebElement getContinue(WebDriver driver) {
		
		return driver.findElement(this.continueBtn);
		
	}
public WebElement getshopSubMenu(WebDriver driver) {
		
		return driver.findElement(this.shoppingSubMenu);
		
	}
public WebElement getorderMenu(WebDriver driver) {
	
	return driver.findElement(this.orderMenu);
	
}
public WebElement getTextBox(WebDriver driver) {
	
	return driver.findElement(this.textBox);
	
}
public WebElement filter(WebDriver driver) {
	
	return driver.findElement(this.shopFilter);
	
}

public List<WebElement> getTableRow(WebDriver driver) {
	
	return driver.findElements(this.tr);
	
}
public List<WebElement> getTableData(WebDriver driver) {
	
	return driver.findElements(this.td);
	
}
public List<WebElement> getBtn(WebDriver driver) {
	
	return driver.findElements(this.Btn);
	
}
public WebElement geteditbtn(WebDriver driver) {
	
	return driver.findElement(this.editBtn);
	
}
public WebElement getDelbtn(WebDriver driver) {
	
	return driver.findElement(this.delBtn);
	
}
}
