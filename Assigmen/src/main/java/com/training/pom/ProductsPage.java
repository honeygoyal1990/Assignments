package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	By ProductMenu=By.xpath("//ul[@id='menu']/li[@id='catalog']");
	By productSubMenu=By.xpath("//ul[@id='menu']/li[@id='catalog']/ul/li/a[contains(text(),'Products')]");
By qtytextBox =By.xpath("//input[@id='input-quantity']");
By editBtn = By.xpath("//form[@id='form-product']//div//table//tbody//a[@class='btn btn-primary'][1]");
By Btn = By.xpath("//a[@class='btn btn-primary'][1]");
	By dataTab=By.xpath("//a[@href='#tab-data']");
	By linksTab=By.xpath("//a[@href='#tab-links']");
	By saveBtn=By.xpath("//i[@class='fa fa-save']");
	By msg = By.xpath("//div[@class='container-fluid']//div");
	By checkbox=By.xpath("//form[@id='form-product']//div//table//tbody//tr");
	By addBtn= By.xpath("//a[@class='btn btn-primary']");
	By txtnewProd= By.xpath("//input[@id='input-name1']");
	By txtnewProdMeta= By.xpath("//input[@id='input-meta-title1']");
	By txtnewModel= By.xpath("//input[@id='input-model']");
	By txtnewPrice= By.xpath("//input[@id='input-price']");
	By grpcategory=By.xpath("//div[@class='col-sm-10']/ul/li");
	By txtCategory = By.xpath("//input[@id='input-category']");
public WebElement getcheck(WebDriver driver) {
		
		return driver.findElement(this.checkbox);
		
	}
public WebElement gettxtCategory(WebDriver driver) {
	
	return driver.findElement(this.txtCategory);
	
}
public WebElement gettxtNewProdMeta(WebDriver driver) {
	
	return driver.findElement(this.txtnewProdMeta);
	
}
public WebElement gettxtNewModel(WebDriver driver) {
	
	return driver.findElement(this.txtnewModel);
	
}
public WebElement gettxtNewPrice(WebDriver driver) {
	
	return driver.findElement(this.txtnewPrice);
	
}
public WebElement gettxtnewProd(WebDriver driver) {
	
	return driver.findElement(this.txtnewProd);
	
}
public WebElement getaddBtn(WebDriver driver) {
	
	return driver.findElement(this.addBtn);
	
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
public List<WebElement> getgrpCategory(WebDriver driver) {
	
	return driver.findElements(this.grpcategory);
	
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
public WebElement getLinksTab(WebDriver driver) {
	
	return driver.findElement(this.linksTab);
	
}
public WebElement getsaveBtn(WebDriver driver) {
	
	return driver.findElement(this.saveBtn);
	
}
public WebElement getmsg(WebDriver driver) {
	
	return driver.findElement(this.msg);
	
}
}
