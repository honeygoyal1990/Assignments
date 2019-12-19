package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpskillsPage {
	By mainbtn=By.xpath("//a[@class='dropdown-toggle']");
	By email=By.name("email");
	By password=By.name("password");
	By loginoption=By.xpath("//li[@class='dropdown myaccount open']//ul//li[2]");
	By logbtn=By.xpath("//input[@class='btn btn-primary']");
	By usericon=By.xpath("//div[@id='top-links1']/ul/li[@class='dropdown myaccount']/a/i");
	By orderHistory = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']/li/a[contains(text(),'Order History')]");
	By trOrder=By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td/a/i");
	By trreturnbtn=By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td/a[@class='btn btn-danger']");
	By Rdreturnrs=By.xpath("//div[@class='form-group required']/div/div[@class='radio']/label");
	By Rdopened=By.xpath("//div[@class='form-group required']/div/label[@class='radio-inline']");
	By btnagree=By.xpath("//div[@class='buttons clearfix']/div[@class='pull-right']/input[@name='agree']");
	By btnsubmit=By.xpath("//div[@class='buttons clearfix']/div[@class='pull-right']/input[@value='Submit']");
	By txtarea=By.xpath("//div[@class='form-group']/div/textarea[@id='input-comment']");
	By successMsg=By.xpath("//div[@id='content']/p");
	
	public WebElement getmainbtn(WebDriver driver) {
		return driver.findElement(mainbtn);
	}
	public WebElement getemail(WebDriver driver) {
		return driver.findElement(email);
	}
	public WebElement getpassword(WebDriver driver) {
		return driver.findElement(password);
	}
	public WebElement getloginoption(WebDriver driver) {
		return driver.findElement(loginoption);
	}
	public WebElement getlogbtn(WebDriver driver) {
		return driver.findElement(logbtn);
	}
	
	public WebElement getusericon(WebDriver driver) {
		return driver.findElement(usericon);
	}
	public List<WebElement> getsuccessMsg(WebDriver driver) {
		return driver.findElements(successMsg);
	}
	public WebElement gettxtarea(WebDriver driver) {
		return driver.findElement(txtarea);
	}
	public WebElement getbtnsubmit(WebDriver driver) {
		return driver.findElement(btnsubmit);
	}
	public WebElement getRdreturnrs(WebDriver driver) {
		return driver.findElement(Rdreturnrs);
	}
	public WebElement getbtnagree(WebDriver driver) {
		return driver.findElement(btnagree);
	}
	public WebElement getRdopened(WebDriver driver) {
		return driver.findElement(Rdopened);
	}
	public WebElement getorderHistory(WebDriver driver) {
		return driver.findElement(orderHistory);
	}
	public WebElement gettrOrder(WebDriver driver) {
		return driver.findElement(trOrder);
	}
	public WebElement gettrreturnbtn(WebDriver driver) {
		return driver.findElement(trreturnbtn);
	}

}
