package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickToOrganizationsModule {
	public ClickToOrganizationsModule(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href=\"index.php?module=Accounts&action=index\"]") 
	private WebElement org;
	public void click() {
		org.click();
	}
}
