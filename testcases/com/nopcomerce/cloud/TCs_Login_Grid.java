package com.nopcomerce.cloud;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import utlities.DataHelper;

public class TCs_Login_Grid extends BaseTest {
	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		driver = getBrowserDriver(envName, browserName, serverName, ipAddress, portNumber, osName, osVersion);
		dataFaker = DataHelper.getDataHelper();
		userData = UserDataMapper.getUserData();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		validPassword = userData.getValidPassword();

		emailAddress = dataFaker.getEmailAddress();
		day = userData.getDate();
		month = userData.getMonth();
		year = userData.getYear();
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Precondition - Step 01: Navigate to 'Register' link");
		registerPage = homePage.openRegisterPage();

		log.info("Precondition - Step 02: Click to Checkbox Gender");
		registerPage.clickToCheckboxByLabel(driver, "Female");

		log.info("Precondition - Step 03: Enter to FirstName textbox with value is " + firstName + "'");
		registerPage.inputTextboxByID(driver, "FirstName", firstName);

		log.info("Precondition - Step 04: Enter to LastName textbox with value is " + lastName + "'");
		registerPage.inputTextboxByID(driver, "LastName", lastName);

		log.info("Precondition - Step 05: Select Day of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Precondition - Step 06: Select Month of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Precondition - Step 07: Select year of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Precondition - Step 08: Enter to emailAdress textbox with value is " + emailAddress + "'");
		registerPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Precondition - Step 09: Click to Radio ");
		// registerPage.clickToRadioByLabel(driver, "Newsletter:");

		log.info("Precondition - Step 10: Enter to password textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Precondition - Step 11: Enter to ConfirmPasswod textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Precondition - Step 12: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Precondition - Step 13: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Precondition - Step 14: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Precondition - Step 15: Click to Login link");
		loginPage = homePage.openLoginPage();
		urlCurent = homePage.getPageUrl(driver);
	}

	@Test
	public void Login_01_LoginWithEmptyData() {
		log.info("Login_01 - Step 01: Input to emailAddress textbox with value is" + "");
		loginPage.inputTextboxByID(driver, "Email", "");

		log.info("Login_01 - Step 02: Input to Password textbox with value is" + "");
		loginPage.inputTextboxByID(driver, "Password", "");

		log.info("Login_01 - Step 03: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");

		log.info("Login_01 - Step 04: Verify error message displayed");
		verifyEquals(loginPage.getErrorMessageAtTextboxByID(driver, "Email-error"), "Please enter your email");
	}

	@Test
	public void Login_02_LoginWithInvalidEmail() {
		log.info("Login_02 - Step 01: Open Login page");
		loginPage.openPageUrl(driver, urlCurent);

		log.info("Login_02 - Step 02: Input to emailAddress textbox with value is" + userData.getInvalidEmail() + "");
		loginPage.inputTextboxByID(driver, "Email", userData.getInvalidEmail());

		log.info("Login_02 - Step 03: Input to Password textbox with value is" + validPassword + "");
		loginPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Login_02 - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");

		log.info("Login_02 - Step 05: Verify error message displayed");
		verifyEquals(loginPage.getErrorMessageAtTextboxByID(driver, "Email-error"), "Wrong email");
	}

	@Test
	public void Login_03_LoginWithEmailYetRegister() {
		log.info("Login_03 - Step 01: Open Login page");
		loginPage.openPageUrl(driver, urlCurent);

		log.info("Login_03 - Step 02: Input to emailAddress textbox with value is" + userData.getEmailNotExist() + "");
		loginPage.inputTextboxByID(driver, "Email", userData.getEmailNotExist());

		log.info("Login_03 - Step 03: Input to Password textbox with value is" + validPassword + "");
		loginPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Login_03 - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");

		log.info("Login_03 - Step 05: Verify error message displayed");
		verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_LoginWithExistEmailAndEmptyPassword() {
		log.info("Login_04 - Step 01: Open Login page");
		loginPage.openPageUrl(driver, urlCurent);

		log.info("Login_04 - Step 02: Input to emailAddress textbox with value is" + emailAddress + "");
		loginPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Login_04 - Step 03: Input to Password textbox with value is" + "");
		loginPage.inputTextboxByID(driver, "Password", "");

		log.info("Login_02 - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");

		log.info("Login_02 - Step 05: Verify error message displayed");
		verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_LoginWithExistEmailAndInvalidPassword() {
		log.info("Login_04 - Step 01: Open Login page");
		loginPage.openPageUrl(driver, urlCurent);

		log.info("Login_04 - Step 02: Input to emailAddress textbox with value is" + emailAddress + "");
		loginPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Login_04 - Step 03: Input to Password textbox with value is" + userData.getInvalidPassword() + "");
		loginPage.inputTextboxByID(driver, "Password", userData.getInvalidPassword());

		log.info("Login_04 - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");

		log.info("Login_04 - Step 05: Verify error message displayed");
		verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_LoginSuccessful() {
		log.info("Login_04 - Step 01: Open Login page");
		loginPage.openPageUrl(driver, urlCurent);

		log.info("Login_04 - Step 02: Input to emailAddress textbox with value is" + emailAddress + "");
		loginPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Login_04 - Step 03: Input to Password textbox with value is" + validPassword + "");
		loginPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Login_04 - Step 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login_04 - Step 05: Verify HomePage displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Parameters("envName")
	@AfterClass(alwaysRun = true)
	public void afterClass(String envName) {
		closeBrowserAndDriver(envName);
	}

	private WebDriver driver;
	private DataHelper dataFaker;
	private UserDataMapper userData;
	private String emailAddress, firstName, lastName, validPassword, day, month, year, urlCurent;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
}