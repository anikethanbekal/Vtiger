package com.vtiger.testpom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.Homepage;
import com.vtiger.pom.Organizations;

public class DuplicateOrganizations extends BaseTest {
	@Test
	public static void testDuplicateOrganizations() throws InterruptedException {
		String un =Excel.getData(EXCEL_PATH, SHEET, 1, 0);
		String passwd =Excel.getData(EXCEL_PATH, SHEET, 1, 1);
		String title =Excel.getData(EXCEL_PATH, SHEET, 1, 2);
		String module =Excel.getData(EXCEL_PATH, SHEET, 1, 3);
		String nm =Excel.getData(EXCEL_PATH, SHEET, 1, 4);
		String replace ="Duplicate";
		com.vtiger.pom.LoginPage l = new com.vtiger.pom.LoginPage(driver);
		l.getUsername(un);
		l.getPassword(passwd);
		l.setLoginBtn();
		
		Homepage hp =  new Homepage(driver);
		hp.verifyHomePage(driver, 5, title);
		
		ClickToOrganizationsModule c = new ClickToOrganizationsModule(driver);
		c.click();
		
		Thread.sleep(5000);
		Organizations o = new Organizations(driver);
		o.verifyModulePage(driver, 5, module);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("accountname")).sendKeys(nm);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@align=\"center\"][1]/input[@title=\"Save [Alt+S]\"][1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Duplicate")).click();
		driver.findElement(By.name("accountname")).clear();
		driver.findElement(By.name("accountname")).sendKeys(replace);
		driver.findElement(By.xpath("//div[@align=\"center\"][1]/input[@title=\"Save [Alt+S]\"][1]")).click();
		String duplicate = driver.findElement(By.id("dtlview_Organization Name")).getText();
		System.out.println(duplicate);
		System.out.println(replace	);
		if (duplicate.equalsIgnoreCase(replace))
		{
			System.out.println("Test case is pass");
		}
		else {
			System.out.println("Test case is fail");
		}
	}
}
