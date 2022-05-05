package com.nopcomerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class Level_03_Page_Object_02_Login {
	private WebDriver driver;
	private String emailAdress, password;

	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private LoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		password = "123456";
		emailAdress = "tuthuc176216@gmail.com";

	}

	@Test
	public void Login_01_Login_Empty_Data() {
		System.out.println("Login_01 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		System.out.println("Login_01 - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Login_Invalid_Email() {
		System.out.println("Login_02 - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		System.out.println("Login_02 - Step 02: Input email, password fields");

		loginPage.inputToEmailTextbox("123@!@#$");
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_02 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_02 - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03__Login_Email_Not_Register() {
		System.out.println("Login_03 - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		System.out.println("Login_03 - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox("thuctv@gmail.com");
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_03 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_03 - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccess(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Login_Password_Empty() {

		System.out.println("Login_04 - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		System.out.println("Login_04 - Step 02: Input to email fields");

		loginPage.inputToEmailTextbox(emailAdress);

		System.out.println("Login_04 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_04 - Step 04: Verify error message displayed");

		Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccess(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_05_Login_Invalid_Password() {

		System.out.println("Loginr_05 - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		System.out.println("Login_05 - Step 02: Input to required fields");

		loginPage.inputToEmailTextbox(emailAdress);
		loginPage.inputToPasswordTextbox("123#@");

		System.out.println("Login_05 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_05 - Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccess(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_06_Login_Success() {

		System.out.println("Login_06 - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		System.out.println("Login_06 - Step 02: Input to required fields");

		loginPage.inputToEmailTextbox(emailAdress);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_06 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_06 - Step 04: Verify Login Success");
		Assert.assertEquals(loginPage.getTextWellcomeHomePage(), "Welcome to our store");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

}
