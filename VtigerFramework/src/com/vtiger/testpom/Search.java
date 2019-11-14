package com.vtiger.testpom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.Homepage;

public class Search extends BaseTest{
	@Test
	public static void testSearch() throws InterruptedException {
		String un =Excel.getData(EXCEL_PATH, SHEET, 1, 0);
		String passwd =Excel.getData(EXCEL_PATH, SHEET, 1, 1);
		String title =Excel.getData(EXCEL_PATH, SHEET, 1, 2);
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
		
		driver.findElement(By.id("qccombo")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//option[@value=\"Accounts\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("accountname")).sendKeys(nm+"a");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @name='button']")).click();
		Thread.sleep(5000);
		c.click();
		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(nm+"a");
		Select s = new Select(driver.findElement(By.id("bas_searchfield")));
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		Thread.sleep(5000);
		String validate = driver.findElement(By.xpath("//a[@title=\"Organizations\"]")).getText();
		if (validate.equalsIgnoreCase(nm+"a"))
		{
			System.out.println("Test case is pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}
	}
}