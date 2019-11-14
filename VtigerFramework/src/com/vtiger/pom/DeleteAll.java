package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAll {
	public DeleteAll(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="selectall") 
	private WebElement selectall;
	public void clickSelectAll(){
		selectall.click();
	}
	
	@FindBy( xpath="//table[@class=\"small\"]/descendant::input[@value=\"Delete\"]")
	private WebElement delete;
	public void clickDelete() {
		delete.click();
	}

	@FindBy()
	private WebElement confirm;
	public void confirm(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}
 