package com.nopcomerce.user.study;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {

	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		driver = getBrowserDriver(envName, browserName, serverName, ipAddress, portNumber, osName, osVersion);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		emailAdress = Common_01_Register_End_User.emailAddress;
		validPassword = Common_01_Register_End_User.validPassword;
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to EmailAdress textbox with value is " + emailAdress + "'");
		loginPage.inputToEmailTextbox(emailAdress);

		log.info("Login - Step 03: Enter to Password textbox with value is " + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);

		log.info("Login - Step 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify 'MyAccount' link is displayed ");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Navigate to Customer infor page");
		custormerInforPage = homePage.openCustomerInforPage();

		log.info("Login - Step 07: Verify 'Customer infor' page is displayed ");
		verifyFalse(custormerInforPage.isCustomerInforPageDisplayed());

	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Relative_Product_Name() {

	}

	@Test
	public void Search_03_Absolute_Product_Name() {

	}

	@Test
	public void Search_04_Parent_Category() {

	}

	@Test
	public void Search_05_Incorrect_Manufactorer() {

	}

	@Test
	public void Search_06_Incorrect_Manufactorer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAdress, validPassword;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	private UserCustomerInfoPageObject custormerInforPage;

}
