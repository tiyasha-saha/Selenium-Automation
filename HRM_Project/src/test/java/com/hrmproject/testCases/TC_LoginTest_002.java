package com.hrmproject.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrmproject.pageObjects.Dashboard;
import com.hrmproject.pageObjects.LoginPage;
import com.hrmproject.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseClass{

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\hrmproject\\testData\\LoginData.xlsx";
		System.out.println("File path: " + path); 

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String [rownum][colcount];

		for(int i=1; i<=rownum ; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.println("Data at [" + i + "][" + j + "]: " + logindata[i-1][j]); 
			}
		}
		return logindata;
	}
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		logger.info("URL is opened.");

		lp.setUserName(username);
		logger.info("Username Provided");

		lp.setPassword(password);
		logger.info("Password Provided");

		lp.clickSubmit();
		logger.info("Clicked Submit Button");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		if(isDashboardVisible()==true)
		{
			Assert.assertTrue(true);
			logger.info("Successfully logged In.");
		}
		else 
		{
			logger.info("Login Unsuccessful.");
			Assert.assertTrue(false);
		}

	}
	
	public boolean isDashboardVisible() throws IOException
	{
		try {
			Dashboard db = new Dashboard(driver);
			String expectedText = "Dashboard";
			String actualText = db.dashBoardHeader();
			Assert.assertEquals(expectedText, actualText);
			Thread.sleep(3000);
			db.selectProfileIcon();
            db.clickLogout();
			return true;
		} catch (Exception e) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			captureScreen(driver, "loginFailure" + timeStamp);
			return false;
		}
	}

	
}
