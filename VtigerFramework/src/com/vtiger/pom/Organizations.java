package com.vtiger.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Organizations {
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyModulePage(WebDriver driver, long ETO, String module) {
		try {
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(module));
			Reporter.log("Organizations Page is Displayed", true);
		} catch (Exception e) {
			Reporter.log("Organizations Page is not displayed", true);
			e.printStackTrace();
			Assert.fail();
		}
	}
}