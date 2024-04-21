package com.hrmproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "username")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement txtbtnLogin;

	@FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
	WebElement txtLoginPage;
	
	@FindBy(xpath = "//div[@class='oxd-alert-content oxd-alert-content--error']")
	WebElement txtInvalidCredentials;

	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit()
	{
		txtbtnLogin.click();
	}

	public boolean loginHeader() {
		boolean loginPageVisibility = txtLoginPage.isDisplayed();
		return loginPageVisibility;
	}
	
	public boolean invalidVisible() {
		boolean invalidVisibility = txtInvalidCredentials.isDisplayed();
		return invalidVisibility;
	}
	
	public String loginHeaderText()
	{
		return txtLoginPage.getText();
	}

}
