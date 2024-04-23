package com.hrmproject.testCases;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrmproject.pageObjects.Add_Employee;

public class TC_AddEmpTest_001 extends BaseClass {

	@Test (priority = 1)
	public void EmpAddTest() throws IOException, InterruptedException {

		TC_LoginTest_001 tc001 = new TC_LoginTest_001();
		logger.info("Loggin In...");
		tc001.loginTest();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Add_Employee addemp = new Add_Employee(driver);

		addemp.pimSidebarOp();
		logger.info("Clicked PIM option from Sidebar");

		String expectedText1 = "PIM";
		String actualText1 = addemp.pimHeader();
		Assert.assertEquals(expectedText1, actualText1);
		logger.info("Opened " + actualText1);

		addemp.clickAddEmp();
		logger.info("Clicked Add Employee option");

		String expectedText2 = "Add Employee";
		String actualText2 = addemp.addEmpHeader();
		Assert.assertEquals(expectedText2, actualText2);
		logger.info("Opened " + actualText2);

		String fname = addemp.RandomFirstNameGenerator();
		addemp.getFname(fname);
		logger.info("Firstname Provided");

		String lname = addemp.RandomLastNameGenerator();
		addemp.getLname(lname);
		logger.info("Lastname Provided");

		String eid = addemp.RandomEmpIDGenerator();
		addemp.getEmpId(eid);
		logger.info("Employee ID Provided");

		Thread.sleep(3000);

		String filePath =  System.getProperty("user.dir") + "\\src\\test\\resources\\user.png";
		addemp.getImg(filePath);
		logger.info("Image Provided");

		Thread.sleep(3000);

		addemp.detSave();

		String expectedText3 = "Success" + "\n" + "Successfully Saved";
		String actualText3 = addemp.toastMessage();
		Assert.assertEquals(expectedText3, actualText3);
		logger.info("Message Shown: " + actualText3);

		Thread.sleep(4000);


	}

	@Test (priority = 2)
	public void addedEmployeeDetUpdate() throws InterruptedException 
	{
		Add_Employee addemp = new Add_Employee(driver);

		addemp.nationality();
		//addemp.nationalityParticular("Bruneian");
		logger.info("Nationality Selected");

		addemp.dobGenerate();

		logger.info("DOB Selected");

		addemp.genderSelect();

		logger.info("Gender Selected");

		Thread.sleep(6000);

		addemp.perDetSave();
		
		logger.info("Details Saved!");
	}


}