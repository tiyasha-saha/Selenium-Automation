package com.hrmproject.pageObjects;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_Employee {

	WebDriver ldriver;

	public Add_Employee(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[2]/a")
	WebElement pimSidebar;

	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtPimHeader;

	@FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']//li[3]")
	WebElement btnAddEmp;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	WebElement txtAddEmp;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;

	@FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//input")
	WebElement empID;

	@FindBy(xpath = "//input[@type='file']")
	WebElement btnImgUpload;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@class='oxd-toast-content oxd-toast-content--success']")
	WebElement toastSuccess;

	@FindBy(xpath = "//form[@class='oxd-form']/div[3]/div[1]/div[1]//div[@class='oxd-select-text-input']")
	WebElement selectNationality;
	
	//	@FindBy(xpath = "//form[@class='oxd-form']/div[3]/div[1]/div[1]//i[contains(@class, 'oxd-icon bi-caret')]")
	//	WebElement selectNationalityUpdate;

	@FindBy(xpath = "//form[@class='oxd-form']/div[3]/div[1]/div[1]//div[@class='oxd-select-text--after']")
	WebElement newpath;

	@FindBy(xpath = "//div[@role='listbox']")
	WebElement nation;

	public void pimSidebarOp()
	{
		pimSidebar.click();
	}

	public String pimHeader()
	{
		return txtPimHeader.getText();
	}

	public void clickAddEmp() {
		btnAddEmp.click();
	}

	public String addEmpHeader()
	{
		return txtAddEmp.getText();
	}

	public void getFname(String fname) {
		firstName.sendKeys(fname);
	}

	public void getLname(String lname) {
		lastName.sendKeys(lname);
	}

	public void getEmpId(String eid) {

		empID.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));;
		empID.sendKeys(eid);
	}

	public void getImg(String img) {

		File uploadFile = new File(img);
		btnImgUpload.sendKeys(uploadFile.getAbsolutePath());
	}

	public void detSave() {
		btnSave.click();
	}

	public String toastMessage() {

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(6));
		WebElement messageSuccess = wait.until(ExpectedConditions.visibilityOf(toastSuccess));
		String successMessage = messageSuccess.getText();
		return successMessage;

	}

	public String RandomFirstNameGenerator() {

		String[] FIRST_NAMES = {"Emily", "Sophia", "Emma", "Olivia", "Ava", "Isabella", "Abigail", "Charlotte", "Harper", "Evelyn", "Amelia", "Elizabeth", "Ella", "Madison", "Scarlett", "Victoria", "Grace", "Chloe", "Samantha"};
		Random random = new Random();
		int index = random.nextInt(FIRST_NAMES.length);
		return FIRST_NAMES[index];

	}

	public String RandomLastNameGenerator() {

		String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
		Random random = new Random();
		int index = random.nextInt(LAST_NAMES.length);
		return LAST_NAMES[index];

	}

	public String RandomEmpIDGenerator() {

		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		String formattedNumber = String.format("%04d", randomNumber);
		return "0" + formattedNumber;
	}

	public void nationality() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,350)", "");
		newpath.click();

		Thread.sleep(5000);

		List<WebElement> options = newpath.findElements(By.xpath("//div[@role='option']"));


		ArrayList<String> optionTexts = new ArrayList<String>();


		for (int i = 1; i < options.size(); i++) {
			WebElement option = options.get(i);
			String text = option.getText();
			optionTexts.add(text);
		}
		System.out.println(optionTexts);

		Random rand = new Random();

		int numberOfElements = 2;
		String randomElement = "";

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(optionTexts.size());
			randomElement = optionTexts.get(randomIndex);
		}

		System.out.println(randomElement);
		
		selectNationality.sendKeys(randomElement);
		selectNationality.sendKeys(Keys.ENTER);

		Thread.sleep(5000);


	}



}
