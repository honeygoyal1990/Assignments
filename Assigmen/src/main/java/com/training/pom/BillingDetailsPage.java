package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingDetailsPage {
	By txtFirstName=By.xpath("//input[@id='input-payment-firstname']");
	By txtLastName = By.xpath("//input[@id='input-payment-lastname']");
By txtEmail = By.xpath("//input[@id='input-payment-email']");
By txtphone = By.xpath("//input[@id='input-payment-telephone']");
	By txtAddress1=By.xpath("//input[@id='input-payment-address-1']");
	
	By txtCity=By.xpath("//input[@id='input-payment-city']");
	By txtPostCode= By.xpath("//input[@id='input-payment-postcode']");
	By listCountry= By.xpath("//select[@id='input-payment-country']");
	By listRegion=By.xpath("//select[@id='input-payment-zone']");
	By chkbox=By.xpath("//input[@name='shipping_address']");
	By contBtn=By.xpath("//div[@class='buttons']/div/input[@id='button-guest']");
	By freeship= By.xpath("//input[@name='shipping_method']");
	By txtarea= By.xpath("//div[@class='panel-body']/p/textarea[@name='comment']");
	By agree=By.xpath("//input[@name='agree']");
	By contBtn2=By.xpath("//input[@id='button-shipping-method']");
	By contBtn3=By.xpath("//input[@id='button-payment-method']");
	By contBtn4=By.xpath("//input[@id='button-confirm']");
public WebElement getfreeship(WebDriver driver) {
		
		return driver.findElement(this.freeship);
		
	}
public WebElement gettxtarea(WebDriver driver) {
	
	return driver.findElement(this.txtarea);
	
}
public WebElement getagree(WebDriver driver) {
	
	return driver.findElement(this.agree);
	
}
public WebElement getcontBtn2(WebDriver driver) {
	
	return driver.findElement(this.contBtn2);
	
}
public WebElement getcontBtn3(WebDriver driver) {
	
	return driver.findElement(this.contBtn3);
	
}
public WebElement getcontBtn4(WebDriver driver) {
	
	return driver.findElement(this.contBtn4);
	
}	
	
public WebElement gettxtFirstName(WebDriver driver) {
		
		return driver.findElement(this.txtFirstName);
		
	}
public WebElement getcontBtn(WebDriver driver) {
	
	return driver.findElement(this.contBtn);
	
}
public WebElement getchkbox(WebDriver driver) {
	
	return driver.findElement(this.chkbox);
	
}
public WebElement gettxtLastName(WebDriver driver) {
	
	return driver.findElement(this.txtLastName);
	
}
public WebElement gettxtEmail(WebDriver driver) {
	
	return driver.findElement(this.txtEmail);
	
}
public WebElement gettxtphone(WebDriver driver) {
	
	return driver.findElement(this.txtphone);
	
}
public WebElement gettxtAddress1(WebDriver driver) {
	
	return driver.findElement(this.txtAddress1);
	
}
public WebElement gettxtCity(WebDriver driver) {
	
	return driver.findElement(this.txtCity);
	
}
public WebElement gettxtPostCode(WebDriver driver) {
	
	return driver.findElement(this.txtPostCode);
	
}	
public WebElement getSelectlistCountry(WebDriver driver) {
	
	return driver.findElement(this.listCountry);
	
}

public WebElement getlistRegion(WebDriver driver) {
	
	return driver.findElement(this.listRegion);
	
}




}
