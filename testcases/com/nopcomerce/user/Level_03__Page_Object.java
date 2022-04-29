package com.nopcomerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03__Page_Object extends BasePage {
	WebDriver driver;
	String emailAdress;

	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Initial- Khoi tao
		// Che giau viec khoi tao cua 1 doi tuong
		emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Rgister_Empty_Data() {
		System.out.println("Home page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register page - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register Page - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		System.out.println("Home page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 02: Input to required fields");

		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox("123@!@#$");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register page - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	}

	@Test
	public void TC_03_Register_Success() {
		System.out.println("Home page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register Page - Step 02: Input to required fields");

		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register page - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register page - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_04_Register_Existing_Email() {

		System.out.println("Home page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 02: Input to required fields");

		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register page - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register page - Step 04: Verify success message displayed");

		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

		System.out.println("Home page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 02: Input to required fields");

		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register page - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {

		System.out.println("Home page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 02: Input to required fields");

		registerPage.inputToFirstnameTextbox("Automation");
		registerPage.inputToLastnameTextbox("FC");
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("654321");

		System.out.println("Register page - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
}
