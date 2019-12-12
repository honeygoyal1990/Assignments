package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class salesPage {
	By salesMenu=By.xpath("//ul[@id='menu']/li[@id='reports']/a/i");
	By SubMenu=By.xpath("//ul[@id='menu']/li[@id='reports']/ul/li/a[contains(text(),'Sales')]");
	By salesSubMenu=By.xpath("//ul[@id='menu']/li[@id='reports']/ul/li//ul/li/a[contains(text(),'Orders')]");
	
	public WebElement getsalesMenu(WebDriver driver) {
		
		return driver.findElement(this.salesMenu);
		
	}

public List<WebElement> getSubMenu(WebDriver driver) {
		
		return driver.findElements(this.SubMenu);
		
	}
public WebElement getsalesSubMenu(WebDriver driver) {
	
	return driver.findElement(this.salesSubMenu);
	
}
}
