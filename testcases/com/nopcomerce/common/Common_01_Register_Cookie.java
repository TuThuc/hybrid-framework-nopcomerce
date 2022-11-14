package com.nopcomerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import utlities.DataHelper;

public class Common_01_Register_Cookie extends BaseTest {
	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		driver = getBrowserDriver(envName, browserName, serverName, ipAddress, portNumber, osName, osVersion);
		dataFaker = DataHelper.getDataHelper();
		userData = UserDataMapper.getUserData();
		validPassword = userData.getValidPassword();
		emailAddress = dataFaker.getEmailAddress();
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 01: Navigate to 'Register' link");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Enter to FirstName textbox with value is " + dataFaker.getFirstName() + "'");
		registerPage.inputTextboxByID(driver, "FirstName", dataFaker.getFirstName());

		log.info("Register - Step 03: Enter to LastName textbox with value is " + dataFaker.getLastName() + "'");
		registerPage.inputTextboxByID(driver, "LastName", dataFaker.getLastName());

		log.info("Register - Step 04: Enter to emailAdress textbox with value is " + emailAddress + "'");
		registerPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Register - Step 05: Enter to password textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Register - Step 06: Enter to ConfirmPasswod textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Login - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Input to emailAddress textbox with value is" + emailAddress + "");
		loginPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03: Input to Password textbox with value is" + validPassword + "");
		loginPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Login - Step 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login_04 - Step 05: Verify HomePage displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		loggedCookies = homePage.getAllCookies(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private DataHelper dataFaker;
	private UserDataMapper userData;
	private String emailAddress, validPassword;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	public static Set<Cookie> loggedCookies;

}
