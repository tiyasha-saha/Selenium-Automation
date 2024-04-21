package com.hrmproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrmproject.pageObjects.Dashboard;
import com.hrmproject.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		Dashboard db = new Dashboard(driver);

		logger.info("URL is opened.");
		
		if(lp.loginHeader()== true) {
			logger.info("Login page is visible.");
			
		}
		else {
			logger.info("Login page isn't visible.");
		}

		lp.setUserName(username);
		logger.info("Entered Username.");

		lp.setPassword(password);
		logger.info("Entered Password.");

		lp.clickSubmit();
		logger.info("Clicked Submit button.");
		
		String expectedText = "Dashboard";
		String actualText = db.dashBoardHeader();
		Assert.assertEquals(expectedText, actualText);
		logger.info("Checked if entered Dashboard");
		
//		if(expectedText.equals(actualText)) {
//			logger.info("Entered Dashboard");
//		}
//		else {
//			logger.info("Dashboard isn't visible");
//		}
		
		if(db.sidebarDbSelect()== true) {
			logger.info("Dashboard is visible");
		}
		else {
			logger.info("Dashboard isn't visible");
		}
		Thread.sleep(2000);
		
	}
	
	@Test
	public void logoutTest() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		Dashboard db = new Dashboard(driver);
		db.selectProfileIcon();
		db.clickLogout();
		Thread.sleep(2000);
		logger.info("Logged out of the website.");
		
		if(lp.loginHeader()== true) {
			logger.info("Succesfully logged out.");
		}
		else {
			logger.info("Still not logged out.");
		}
	}

}
