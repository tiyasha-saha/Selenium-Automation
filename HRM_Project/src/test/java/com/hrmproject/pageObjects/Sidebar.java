package com.hrmproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar {
	
	WebDriver ldriver;

	public Sidebar(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Search
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchOp;
	
	@FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']/a")
	WebElement searchItem;
	
	//Admin
	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[1]/a")
	WebElement adminSidebar;
	
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6[1]")
	WebElement txtAdminHeader;
	
	//PIM
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtPimHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[2]/a")
	WebElement pimSidebar;
	
	//Leave
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtLeaveHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[3]/a")
	WebElement leaveSidebar;
	
	//Time
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtTimeHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[4]/a")
	WebElement timeSidebar;
	
	//Recruitment
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtRecruitmentHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[5]/a")
	WebElement recruitmentSidebar;
	
	//Myinfo
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtMyinfoHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[6]/a")
	WebElement myinfoSidebar;
	
	//Performance
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6[1]")
	WebElement txtPerformanceHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[7]/a")
	WebElement performanceSidebar;

	//Dashboard
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtDashboardHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[8]/a")
	WebElement dashboardSidebar;
	
	//Directory
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtDirectoryHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[9]/a")
	WebElement directorySidebar;
	
	//Maintenance
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6[1]")
	WebElement txtMaintenanceHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[10]/a")
	WebElement maintenanceSidebar;
	
	//Claim
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtClaimHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[11]/a")
	WebElement claimSidebar;

	//Buzz
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement txtBuzzHeader;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[12]/a")
	WebElement buzzSidebar;
	
	//Sidebar
	public void searchBar(String searchText)
	{
		//searchOp.click();
		searchOp.sendKeys(searchText);
		searchItem.click();
	}
	
	public String adminText()
	{
		return adminSidebar.getText();
	}
	
	public String pimText()
	{
		return pimSidebar.getText();
	}
	
	public String leaveText()
	{
		return leaveSidebar.getText();
	}
	
	public String timeText()
	{
		return timeSidebar.getText();
	}
	
	public String recruitmentText()
	{
		return recruitmentSidebar.getText();
	}
	
	public String myinfoText()
	{
		return myinfoSidebar.getText();
	}
	
	public String performanceText()
	{
		return performanceSidebar.getText();
	}
	
	public String dashboardText()
	{
		return dashboardSidebar.getText();
	}
	
	public String directoryText()
	{
		return directorySidebar.getText();
	}
	
	public String maintenanceText()
	{
		return maintenanceSidebar.getText();
	}
	
	public String claimText()
	{
		return claimSidebar.getText();
	}
	
	public String buzzText()
	{
		return buzzSidebar.getText();
	}
	

	//Header
	public String adminHeader() {
		return txtAdminHeader.getText();
	}
	
	public String pimHeader() {
		return txtPimHeader.getText();
	}
	
	public String leaveHeader() {
		return txtLeaveHeader.getText();
	}
	
	public String timeHeader() {
		return txtTimeHeader.getText();
	}
	
	public String recruitmentHeader() {
		return txtRecruitmentHeader.getText();
	}
	
	public String myinfoHeader() {
		return txtMyinfoHeader.getText();
	}
	
	public String performanceHeader() {
		return txtPerformanceHeader.getText();
	}
	
	public String dashboardHeader() {
		return txtDashboardHeader.getText();
	}
	
	public String directoryHeader() {
		return txtDirectoryHeader.getText();
	}
	
	public String maintenanceHeader() {
		return txtMaintenanceHeader.getText();
	}
	
	public String claimHeader() {
		return txtClaimHeader.getText();
	}
	
	public String buzzHeader() {
		return txtBuzzHeader.getText();
	}
}
