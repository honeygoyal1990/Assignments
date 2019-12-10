package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LocatorInfo {


	By username=By.name("username");
	By password=By.name("password");
	By logBtn=By.xpath("//button[@class='btn btn-primary']");
	By logoutBtn=By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']");
	public WebElement getUsername(WebDriver driver) {
		
		return driver.findElement(this.username);
		
	}
public WebElement getPassword(WebDriver driver) {
		
		return driver.findElement(this.password);
		
	}
public WebElement logBtn(WebDriver driver) {
	
	return driver.findElement(this.logBtn);
	
}	
public WebElement logoutBtn(WebDriver driver) {
	
	return driver.findElement(this.logoutBtn);
	
}	
}
 
