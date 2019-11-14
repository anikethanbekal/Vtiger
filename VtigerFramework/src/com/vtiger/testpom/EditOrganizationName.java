package com.vtiger.testpom;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.Homepage;

public class EditOrganizationName extends BaseTest{
	@Test
	public static void testEditOrganizationsName() throws InterruptedException {
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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @name='button']")).click();
		Thread.sleep(5000);
		ClickToOrganizationsModule c = new ClickToOrganizationsModule(driver);
		c.click();
		driver.findElement(By.xpath("//a[contains(.,'edit')]")).click();
	}
}