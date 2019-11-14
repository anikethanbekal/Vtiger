package com.vtiger.testpom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.Homepage;
import com.vtiger.pom.Organizations;

public class CreateOrganizationsInQuickCreate extends BaseTest {
	@Test
	public static void testCreateOrganizations() throws InterruptedException {
		String un =Excel.getData(EXCEL_PATH, SHEET, 1, 0);
		String passwd =Excel.getData(EXCEL_PATH, SHEET, 1, 1);
		String title =Excel.getData(EXCEL_PATH, SHEET, 1, 2);
		String module =Excel.getData(EXCEL_PATH, SHEET, 1, 3);
		String nm =Excel.getData(EXCEL_PATH, SHEET, 2, 4);
		
		com.vtiger.pom.LoginPage l = new com.vtiger.pom.LoginPage(driver);
		l.getUsername(un);
		l.getPassword(passwd);
		l.setLoginBtn();
		
		Homepage hp =  new Homepage(driver);
		hp.verifyHomePage(driver, 5, title);
		
		driver.findElement(By.id("qccombo")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//option[@value=\"Accounts\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("accountname")).sendKeys(nm);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @name='button']")).click();
	}
}