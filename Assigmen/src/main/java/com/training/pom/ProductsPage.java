package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	By ProductMenu=By.xpath("//ul[@id='menu']/li[2]");
	By productSubMenu=By.xpath("//ul[@id='menu']/li[2]/ul/li[2]");
By qtytextBox =By.xpath("//input[@id='input-quantity']");
By editBtn = By.xpath("//form[@id='form-product']//div//table//tbody//a[@class='btn btn-primary'][1]");
By Btn = By.xpath("//a[@class='btn btn-primary'][1]");
	By dataTab=By.xpath("//a[@href='#tab-data']");
	By saveBtn=By.xpath("//i[@class='fa fa-save']");
	By msg = By.xpath("//div[@class='container-fluid']//div");
	By checkbox=By.xpath("//form[@id='form-product']//div//table//tbody//tr");
public WebElement getcheck(WebDriver driver) {
		
		return driver.findElement(this.checkbox);
		
	}
	public WebElement getProdMenu(WebDriver driver) {
		
		return driver.findElement(this.ProductMenu);
		
	}
public WebElement getprodSubMenu(WebDriver driver) {
		
		return driver.findElement(this.productSubMenu);
		
	}
public List<WebElement> getBtn(WebDriver driver) {
	
	return driver.findElements(this.Btn);
	
}
public WebElement getqtyTextBox(WebDriver driver) {
	
	return driver.findElement(this.qtytextBox);
	
}
public WebElement geteditbtn(WebDriver driver) {
	
	return driver.findElement(this.editBtn);
	
}

public WebElement getDataTab(WebDriver driver) {
	
	return driver.findElement(this.dataTab);
	
}
public WebElement getsaveBtn(WebDriver driver) {
	
	return driver.findElement(this.saveBtn);
	
}
public WebElement getmsg(WebDriver driver) {
	
	return driver.findElement(this.msg);
	
}
}
