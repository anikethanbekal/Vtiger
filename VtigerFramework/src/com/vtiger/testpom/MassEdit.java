package com.vtiger.testpom;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.Homepage;

public class MassEdit extends BaseTest {
	@Test
	public static void testMassEdit() throws InterruptedException {
		String un =Excel.getData(EXCEL_PATH, SHEET, 1, 0);
		String passwd =Excel.getData(EXCEL_PATH, SHEET, 1, 1);
		String title =Excel.getData(EXCEL_PATH, SHEET, 1, 2);
		String nm =Excel.getData(EXCEL_PATH, SHEET, 2, 4);
		String before = "www.google.com";
		
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
		
		driver.findElement(By.id("qccombo")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//option[@value=\"Accounts\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("accountname")).sendKeys(nm+"a");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @name='button']")).click();
		Thread.sleep(5000);
		c.click();
		driver.findElement(By.name("selectall")).click();
		driver.findElement(By.xpath("//table[@class=\"small\"]/descendant::input[@value=\"Mass Edit\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"website\"]")).sendKeys(before);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(5000);	
	}
}