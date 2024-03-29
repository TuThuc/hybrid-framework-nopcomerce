package com.nopcomerce.user.study;

import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmailAdress, invalidEmail, notfoundEmail, password, incorrectPassword;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;

	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	public void beforeTest(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		Environment environment;
		ConfigFactory.setProperty("env", serverName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(envName, browserName, environment.appUrl(), ipAddress, portNumber, osName, osVersion);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		incorrectPassword = "654235";
		invalidEmail = "afc@mail.vn@gn";
		notfoundEmail = "afc" + generateFakeNumber() + "@mail.vn";
		existingEmailAdress = "afc" + generateFakeNumber() + "@mail.vn";

		System.out.println("Pre-condition - Step 01: Click to Register link");
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Pre-condition - Step 02: Input to required fields");

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();
		// Click logout quay về trang HomePage
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - Step 01: Click to Login link");
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		System.out.println("Login_01 - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02 - Step 01: Click to Login link");
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		System.out.println("Login_02 - Step 02: Input email, password fields");

		loginPage.inputToEmailTextbox(invalidEmail);
		System.out.println("Login_02 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_02 - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		System.out.println("Login_03 - Step 01: Click to Login link");
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		System.out.println("Login_03 - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(notfoundEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_03 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_03 - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Exist_Email_Empty_Email() {

		System.out.println("Login_04 - Step 01: Click to Login link");
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		System.out.println("Login_04 - Step 02: Input to email fields");

		loginPage.inputToEmailTextbox(existingEmailAdress);
		loginPage.inputToPasswordTextbox("");
		System.out.println("Login_04 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_04 - Step 04: Verify error message displayed");

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {

		System.out.println("Login_05 - Step 01: Click to Login link");
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		System.out.println("Login_05 - Step 02: Input to required fields");

		loginPage.inputToEmailTextbox(existingEmailAdress);
		loginPage.inputToPasswordTextbox(incorrectPassword);

		System.out.println("Login_05 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_05 - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Login_Success() {

		System.out.println("Login_06 - Step 01: Click to Login link");
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		System.out.println("Login_06 - Step 02: Input to required fields");

		loginPage.inputToEmailTextbox(existingEmailAdress);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_06 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		homePage = new UserHomePageObject(driver);
		System.out.println("Login_06 - Step 04: Verify Login Success");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
