package com.vtiger.testpom;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.DeleteAll;
import com.vtiger.pom.Homepage;
import com.vtiger.pom.Organizations;

public class DeleteAllOragnizationsNames extends BaseTest{
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
		DeleteAll d = new DeleteAll(driver);
		d.clickSelectAll();
		d.clickDelete();
		d.confirm(driver);
		System.out.println("All the entries are deleted");
	}
}