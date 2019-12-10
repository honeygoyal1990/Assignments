package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shoppingCartPage {
	By shoppingMenu=By.xpath("//ul[@id='menu']/li[5]");
	By shoppingSubMenu=By.xpath("//ul[@id='menu']/li[5]/ul/li[3]");

	By tr=By.xpath("//form[@id='form-return']/div/table/tbody/tr");
	By td=By.xpath("//form[@id='form-return']/div/table/tbody/tr/td");
	public WebElement getshopMenu(WebDriver driver) {
		
		return driver.findElement(this.shoppingMenu);
		
	}
public WebElement getshopSubMenu(WebDriver driver) {
		
		return driver.findElement(this.shoppingSubMenu);
		
	}

public List<WebElement> getTableRow(WebDriver driver) {
	
	return driver.findElements(this.tr);
	
}
public List<WebElement> getTableData(WebDriver driver) {
	
	return driver.findElements(this.td);
	
}
}
