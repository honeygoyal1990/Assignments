package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class salesPage {
	By salesMenu=By.xpath("//ul[@id='menu']/li[9]");
	By SubMenu=By.xpath("//ul[@id='menu']/li[9]/ul/li");
	By salesSubMenu=By.xpath("//ul[@id='menu']/li[9]/ul/li[1]/ul/li");
	
	public WebElement getsalesMenu(WebDriver driver) {
		
		return driver.findElement(this.salesMenu);
		
	}

public List<WebElement> getSubMenu(WebDriver driver) {
		
		return driver.findElements(this.SubMenu);
		
	}
public List<WebElement> getsalesSubMenu(WebDriver driver) {
	
	return driver.findElements(this.salesSubMenu);
	
}
}
