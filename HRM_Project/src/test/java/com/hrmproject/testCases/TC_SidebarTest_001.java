package com.hrmproject.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrmproject.pageObjects.Sidebar;

public class TC_SidebarTest_001 extends BaseClass{

	public String sidebarTest() throws IOException, InterruptedException {

		TC_LoginTest_001 tc001 = new TC_LoginTest_001();
		logger.info("Loggin In...");
		tc001.loginTest();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Sidebar sd = new Sidebar(driver);

		String admin = sd.adminText();
		String pim = sd.pimText();
		String leave = sd.leaveText();
		String time = sd.timeText();
		String recruitment = sd.recruitmentText();
		String myinfo = sd.myinfoText();
		String performance = sd.performanceText();
		String dashboard = sd.dashboardText();
		String directory = sd.directoryText();
		String maintenance = sd.maintenanceText();
		String claim = sd.claimText();
		String buzz = sd.buzzText();

		Random rand = new Random();
		ArrayList<String> List = new ArrayList<String>();
		String[] stringList = new String[] {admin, pim, leave, time, recruitment, myinfo, performance, dashboard, directory, maintenance, claim, buzz};
		Collections.addAll(List, stringList);

		int numberOfElements = 2;
		String randomElement = "";

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(List.size());
			randomElement = List.get(randomIndex);
			//System.out.println(randomElement);
		}

		return randomElement;

	}

	@Test
	public void search() throws InterruptedException, IOException {

		String searchText = sidebarTest();
		Sidebar sd = new Sidebar(driver);
		logger.info("Searched for " + searchText);
		sd.searchBar(searchText);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		switch(searchText) {
		
		case "Admin":
			String expectedText1 = "Admin";
			String actualText1 = sd.adminHeader();
			Assert.assertEquals(expectedText1, actualText1);
			logger.info("Opened " + actualText1);
			break;

		case "PIM":
			String expectedText2 = "PIM";
			String actualText2 = sd.pimHeader();
			Assert.assertEquals(expectedText2, actualText2);
			logger.info("Opened " + actualText2);
			break;

		case "Leave":
			String expectedText3 = "Leave";
			String actualText3 = sd.leaveHeader();
			Assert.assertEquals(expectedText3, actualText3);
			logger.info("Opened " + actualText3);
			break;

		case "Time":
			String expectedText4 = "Time";
			String actualText4 = sd.timeHeader();
			Assert.assertEquals(expectedText4, actualText4);
			logger.info("Opened " + actualText4);
			break;

		case "Recruitment":
			String expectedText5 = "Recruitment";
			String actualText5 = sd.recruitmentHeader();
			Assert.assertEquals(expectedText5, actualText5);
			logger.info("Opened " + actualText5);
			break;
			
		case "My Info":
			String expectedText6 = "PIM";
			String actualText6 = sd.myinfoHeader();
			Assert.assertEquals(expectedText6, actualText6);
			logger.info("Opened " + actualText6);
			break;
			
		case "Performance":
			String expectedText7 = "Performance";
			String actualText7 = sd.performanceHeader();
			Assert.assertEquals(expectedText7, actualText7);
			logger.info("Opened " + actualText7);
			break;
			
		case "Dashboard":
			String expectedText8 = "Dashboard";
			String actualText8 = sd.dashboardHeader();
			Assert.assertEquals(expectedText8, actualText8);
			logger.info("Opened " + actualText8);
			break;
			
		case "Directory":
			String expectedText9 = "Directory";
			String actualText9 = sd.directoryHeader();
			Assert.assertEquals(expectedText9, actualText9);
			logger.info("Opened " + actualText9);
			break;
			
		case "Maintenance":
			String expectedText10 = "Maintenance";
			String actualText10 = sd.maintenanceHeader();
			Assert.assertEquals(expectedText10, actualText10);
			logger.info("Opened " + actualText10);
			break;
			
		case "Claim":
			String expectedText11 = "Claim";
			String actualText11 = sd.claimHeader();
			Assert.assertEquals(expectedText11, actualText11);
			logger.info("Opened " + actualText11);
			break;

		case "Buzz":
			String expectedText12 = "Buzz";
			String actualText12 = sd.buzzHeader();
			Assert.assertEquals(expectedText12, actualText12);
			logger.info("Opened " + actualText12);
			break;
		}
	}

}
