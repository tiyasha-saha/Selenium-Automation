package com.hrmproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	WebDriver ldriver;

	public Dashboard(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtDashboardHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[8]/a")
	WebElement sidebarDB;
	
	@FindBy(xpath = "//span/img[@alt='profile picture']")
	WebElement profileIcon;
	
	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	WebElement logout;

	public String dashBoardHeader()
	{
		return txtDashboardHeader.getText();
	}

	public boolean sidebarDbSelect() 
	{
		String state = sidebarDB.getAttribute("class");
		boolean isSelected = state.contains("active");
		return isSelected;
	}
	
	public void selectProfileIcon() 
	{
		profileIcon.click();
	}
	
	public void clickLogout() 
	{
		logout.click();
	}

}
