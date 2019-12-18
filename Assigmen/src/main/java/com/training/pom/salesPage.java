package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class salesPage {
	By salesMenu=By.xpath("//ul[@id='menu']/li[@id='sale']/a/i");
	By SubMenu=By.xpath("//ul[@id='menu']/li[@id='Sales']/ul/li");
	By salesSubMenu=By.xpath("//ul[@id='menu']/li[@id='sale']/ul/li/a[contains(text(),'Orders')]");
	By returnSubMenu=By.xpath("//ul[@id='menu']/li[@id='sale']/ul/li/a[contains(text(),'Returns')]");
	By trOrdertoDel=By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td[1]");
	By delbtn = By.xpath("//div[@id='content']/div[@class='page-header']/div[@class='container-fluid']/div[@class='pull-right']/button");
	By msgBox=By.xpath("//div[@id='content']/div[@class='container-fluid']/div");
	public WebElement getsalesMenu(WebDriver driver) {
		
		return driver.findElement(this.salesMenu);
		
	}
public WebElement getmsgBox(WebDriver driver) {
		
		return driver.findElement(this.msgBox);
		
	}
public WebElement getdelbtn(WebDriver driver) {
		
		return driver.findElement(this.delbtn);
		
	}
public WebElement gettrOrdertoDel(WebDriver driver) {
		
		return driver.findElement(this.trOrdertoDel);
		
	}
public List<WebElement> getSubMenu(WebDriver driver) {
		
		return driver.findElements(this.SubMenu);
		
	}
public WebElement getsalesSubMenu(WebDriver driver) {
	
	return driver.findElement(this.salesSubMenu);
	
}
public WebElement getreturnsSubMenu(WebDriver driver) {
	
	return driver.findElement(this.returnSubMenu);
	
}
}
