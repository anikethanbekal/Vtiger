package com.vtiger.testpom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.ClickToOrganizationsModule;
import com.vtiger.pom.Homepage;

public class SendMailInOrganizations extends BaseTest{
	@Test
	public static void testEditOrganizationsName() throws InterruptedException {
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
		
		/*
		 * driver.findElement(By.id("qccombo")).click(); Thread.sleep(5000);
		 * driver.findElement(By.xpath("//option[@value=\"Accounts\"]")).click();
		 */
		Select s = new Select(driver.findElement(By.id("qccombo")));
		s.selectByIndex(1);
		Thread.sleep(5000);
		driver.findElement(By.name("accountname")).sendKeys(nm);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @name='button']")).click();
		Thread.sleep(5000);
		ClickToOrganizationsModule c = new ClickToOrganizationsModule(driver);
		c.click();
		Thread.sleep(2000);
		driver.findElement(By.name("selected_id")).click();
		//click on send mail button
		driver.findElement(By.xpath("//table[@class=\"small\"]/descendant::input[@value=\"Send Mail\"]")).click();
		driver.findElement(By.name("Select")).click();
		String parent = driver.getWindowHandle();
		Set<String> wins = driver.getWindowHandles();
		wins.remove(parent);
		for (String win : wins) {
			driver.switchTo().window(win).switchTo();
		}
		String mailtitle = driver.getTitle();
		String expect = "compose mail";
		
		if(expect.equalsIgnoreCase(mailtitle)) {
			System.out.println("Test case is pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}
	}
}