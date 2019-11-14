package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name") 
	private WebElement username;
	public void getUsername(String text) {
		username.sendKeys(text);
	}
	
	@FindBy(name="user_password")
	private WebElement passwd;
	public void getPassword(String text) {
		passwd.sendKeys(text);
	}

	@FindBy(id="submitButton") private WebElement loginBtn;
	public void setLoginBtn() {
		loginBtn.click();
	}
}
 