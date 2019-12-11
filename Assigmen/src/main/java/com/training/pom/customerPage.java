package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class customerPage {
	By custMenu=By.xpath("//ul[@id='menu']/li[6]");
	By custSubMenu=By.xpath("//ul[@id='menu']/li[6]/ul/li");
	By custName=By.id("input-name");
	By custFilter=By.id("button-filter");
	By tr=By.xpath("//form[@id='form-customer']/div/table/tbody/tr");
	By td=By.xpath("//form[@id='form-customer']/div/table/tbody/tr/td");
	By email= By.id("input-email");
	public WebElement getCustMenu(WebDriver driver) {
		
		return driver.findElement(this.custMenu);
		
	}
public WebElement getEmail(WebDriver driver) {
		
		return driver.findElement(this.email);
		
	}
public List<WebElement> getcustSubMenu(WebDriver driver) {
		
		return driver.findElements(this.custSubMenu);
		
	}
public WebElement getFilter(WebDriver driver) {
	
	return driver.findElement(this.custFilter);
	
}
public WebElement getcustName(WebDriver driver) {
	
	return driver.findElement(this.custName);
	
}
public List<WebElement> getTableRow(WebDriver driver) {
	
	return driver.findElements(this.tr);
	
}
public List<WebElement> getTableData(WebDriver driver) {
	
	return driver.findElements(this.td);
	
}
}
