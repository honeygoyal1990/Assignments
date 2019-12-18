package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdersPage {
	By trOrderlist=By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr");
	By selorderStatus = By.xpath("//select[@id='input-order-status']");
By btnaddhistory=By.xpath("//button[@id='button-history']");
public WebElement gettrOrderList(WebDriver driver) {
		
		return driver.findElement(this.trOrderlist);
		
	}
public WebElement getselorderStatus(WebDriver driver) {
	
	return driver.findElement(this.selorderStatus);
	
}
public WebElement getbtnaddhistory(WebDriver driver) {
	
	return driver.findElement(this.btnaddhistory);
	
}
}
