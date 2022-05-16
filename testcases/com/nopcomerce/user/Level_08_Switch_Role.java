package com.nopcomerce.user;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;



public class Level_08_Switch_Role extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowerDriver(browserName);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userPassword = "123456";
		userEmailAddress = "tuthuc176216@gmail.com";	
		adminEmailAddress = "admin@yourstore.com";
		adminPassword="admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
      userHomePage =  userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());	
		//userHomePage.clickToLogoutLink();
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage  = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	}
	@Test
	public void Role_02_Admin_To_User() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage  = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	private String  userEmailAddress,  userPassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	

}
