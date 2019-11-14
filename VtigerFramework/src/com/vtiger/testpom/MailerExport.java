package com.vtiger.testpom;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.Homepage;
import com.vtiger.pom.Organizations;

public class MailerExport extends BaseTest {
	@Test
	public static void testMailerExport() throws InterruptedException {
		String un =Excel.getData(EXCEL_PATH, SHEET, 1, 0);
		String passwd =Excel.getData(EXCEL_PATH, SHEET, 1, 1);
		String title =Excel.getData(EXCEL_PATH, SHEET, 1, 2);
		String module =Excel.getData(EXCEL_PATH, SHEET, 1, 3);
		String nm =Excel.getData(EXCEL_PATH, SHEET, 1, 4);
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
		c.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@class=\"small\"]/descendant::input[@value=\"Mailer Export\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title=\"Export\"]")).click();
	}
}
