package com.nopcomerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;
import utlities.DataHelper;

public class TCs_Register extends BaseTest {
	Environment environment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		ConfigFactory.setProperty("env", appURL);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowerDriver(browserName, environment.appUrl());
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
		log.info("Precondition - Navigate to 'Register' link");
		registerPage = homePage.openRegisterPage();
		urlCurent = homePage.getPageUrl(driver);
	}

	@Test
	public void Register_01_RegisterWithEmptyData() {

		log.info("Register_01 - Step 01: Click to Checkbox Gender");
		registerPage.clickToCheckboxByLabel(driver, "Female");

		log.info("Register_01 - Step 02: Enter to FirstName textbox with value is " + "'");
		registerPage.inputTextboxByID(driver, "FirstName", "");

		log.info("Register_01- Step 03: Enter to LastName textbox with value is " + "'");
		registerPage.inputTextboxByID(driver, "LastName", "");

		log.info("Register_01 - Step 04: Select Day of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_01 - Step 05: Select Month of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_01 - Step 06: Select year of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_01 - Step 07: Enter to emailAdress textbox with value is " + "'");
		registerPage.inputTextboxByID(driver, "Email", "");

		log.info("Register_01 - Step 08: Click to Radio ");
		registerPage.clickToRadioByLabel(driver, "Newsletter:");

		log.info("Register_01 - Step 09: Enter to password textbox with value is " + "'");
		registerPage.inputTextboxByID(driver, "Password", "");

		log.info("Register_01 - Step 10: Enter to ConfirmPasswod textbox with value is " + "'");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", "");

		log.info("Register_01 - Step 11: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register_01 - Step 12: Verify error message displayed");
		verifyEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		verifyEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required");
	}

	@Test
	public void Register_02_RegisterWithInvalidEmail() {
		log.info("Register_02 - Step 01: Open Register Page");
		homePage.openPageUrl(driver, urlCurent);

		log.info("Register_02 - Step 02: Click to Checkbox Gender");
		registerPage.clickToCheckboxByLabel(driver, "Female");

		log.info("Register_02 - Step 02: Enter to FirstName textbox with value is " + firstName + "'");
		registerPage.inputTextboxByID(driver, "FirstName", firstName);

		log.info("Register_02- Step 03: Enter to LastName textbox with value is " + lastName + "'");
		registerPage.inputTextboxByID(driver, "LastName", lastName);

		log.info("Register_02 - Step 04: Select Day of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_02 - Step 05: Select Month of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_02 - Step 06: Select year of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_02 - Step 07: Enter to emailAdress textbox with value is " + lastName + "'");
		registerPage.inputTextboxByID(driver, "Email", lastName);

		log.info("Register_02 - Step 08: Click to Radio ");
		registerPage.clickToRadioByLabel(driver, "Newsletter:");

		log.info("Register_02 - Step 09: Enter to password textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Register_02 - Step 10: Enter to ConfirmPasswod textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register_02 - Step 11: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_02 - Step 12: Verify error message displayed");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_RegisterSuccessfull() {
		log.info("Register_02 - Step 01: Open Register Page");
		homePage.openPageUrl(driver, urlCurent);

		log.info("Register_03 - Step 01: Click to Checkbox Gender");
		registerPage.clickToCheckboxByLabel(driver, "Female");

		log.info("Register_03 - Step 02: Enter to FirstName textbox with value is " + firstName + "'");
		registerPage.inputTextboxByID(driver, "FirstName", firstName);

		log.info("Register_03 - Step 03: Enter to LastName textbox with value is " + lastName + "'");
		registerPage.inputTextboxByID(driver, "LastName", lastName);

		log.info("Register_03 - Step 04: Select Day of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_03 - Step 05: Select Month of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_03 - Step 06: Select year of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_03 - Step 07: Enter to emailAdress textbox with value is " + emailAddress + "'");
		registerPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Register_03 - Step 08: Click to Radio ");
		registerPage.clickToRadioByLabel(driver, "Newsletter:");

		log.info("Register_03 - Step 09: Enter to password textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Register_03 - Step 10: Enter to ConfirmPasswod textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register_03 - Step 11: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_03 - Step 12: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register_03 - Step 13: Click to Logout link");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void Register_04_RegisterWithExistingEmail() {
		log.info("Register_02 - Step 01: Open Register Page");
		homePage.openPageUrl(driver, urlCurent);

		log.info("Register_04 - Step 01: Click to Checkbox Gender");
		registerPage.clickToCheckboxByLabel(driver, "Female");

		log.info("Register_04 - Step 02: Enter to FirstName textbox with value is " + firstName + "'");
		registerPage.inputTextboxByID(driver, "FirstName", firstName);

		log.info("Register_04 - Step 03: Enter to LastName textbox with value is " + lastName + "'");
		registerPage.inputTextboxByID(driver, "LastName", lastName);

		log.info("Register_04 - Step 04: Select Day of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_04 - Step 05: Select Month of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_04 - Step 06: Select year of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_04 - Step 07: Enter to emailAdress textbox with value is " + emailAddress + "'");
		registerPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Register_04 - Step 08: Click to Radio ");
		registerPage.clickToRadioByLabel(driver, "Newsletter:");

		log.info("Register_04 - Step 09: Enter to password textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Register_04 - Step 10: Enter to ConfirmPasswod textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register_04 - Step 11: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_04 - Step 12: Verify error existing email message displayed");
		verifyEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_RegisterWithPasswordLessThan6Char() {
		log.info("Register_02 - Step 01: Open Register Page");
		homePage.openPageUrl(driver, urlCurent);

		log.info("Register_05 - Step 01: Click to Checkbox Gender");
		registerPage.clickToCheckboxByLabel(driver, "Female");

		log.info("Register_05 - Step 02: Enter to FirstName textbox with value is " + firstName + "'");
		registerPage.inputTextboxByID(driver, "FirstName", firstName);

		log.info("Register_05 - Step 03: Enter to LastName textbox with value is " + lastName + "'");
		registerPage.inputTextboxByID(driver, "LastName", lastName);

		log.info("Register_05 - Step 04: Select Day of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_05 - Step 05: Select Month of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_05 - Step 06: Select year of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_05 - Step 07: Enter to emailAdress textbox with value is " + emailAddress + "'");
		registerPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Register_05 - Step 08: Click to Radio ");
		registerPage.clickToRadioByLabel(driver, "Newsletter:");

		log.info("Register_05 - Step 09: Enter to password textbox with value is " + userData.getInvalidPassword() + "'");
		registerPage.inputTextboxByID(driver, "Password", userData.getInvalidPassword());

		log.info("Register_05 - Step 10: Enter to ConfirmPasswod textbox with value is " + userData.getInvalidPassword() + "");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", userData.getInvalidPassword());

		log.info("Register_05 - Step 11: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_05 - Step 12: Verify error message displayed");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characterss");
	}

	@Test
	public void Register_06_RegisterWithInvalidConfirmPassword() {
		log.info("Register_02 - Step 01: Open Register Page");
		homePage.openPageUrl(driver, urlCurent);

		log.info("Register_06 - Step 01: Click to Checkbox Gender");
		registerPage.clickToCheckboxByLabel(driver, "Female");

		log.info("Register_06 - Step 02: Enter to FirstName textbox with value is " + firstName + "'");
		registerPage.inputTextboxByID(driver, "FirstName", firstName);

		log.info("Register_06 - Step 03: Enter to LastName textbox with value is " + lastName + "'");
		registerPage.inputTextboxByID(driver, "LastName", lastName);

		log.info("Register_06 - Step 04: Select Day of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_06 - Step 05: Select Month of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_06 - Step 06: Select year of Birthday");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_06 - Step 07: Enter to emailAdress textbox with value is " + emailAddress + "'");
		registerPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("Register_06 - Step 08: Click to Radio ");
		registerPage.clickToRadioByLabel(driver, "Newsletter:");

		log.info("Register_06 - Step 09: Enter to password textbox with value is " + validPassword + "'");
		registerPage.inputTextboxByID(driver, "Password", validPassword);

		log.info("Register_06 - Step 10: Enter to ConfirmPasswod textbox with value is " + userData.getInvalidPassword() + "");
		registerPage.inputTextboxByID(driver, "ConfirmPassword", userData.getInvalidPassword());

		log.info("Register_06 - Step 11: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_06 - Step 12: Verify error message displayed");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private DataHelper dataFaker;
	private UserDataMapper userData;
	private String emailAddress, firstName, lastName, validPassword, day, month, year, urlCurent;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
