package com.nopcomerce.user;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.CustomerInforPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAdress,  password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerInforPageObject custormerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowerDriver(browserName);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAdress = "afc" + generateFakeNumber() + "@mail.vn";	
	}

	@Test
	public void User_01_Register() {
		System.out.println(" Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Step 05: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
	}
	@Test
	public void User_02_Login() {
		System.out.println("Login_02 - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		System.out.println("Login_06 - Step 02: Input to required fields");

		loginPage.inputToEmailTextbox(emailAdress);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_06 - Step 03: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("Login_06 - Step 04: Verify Login Success");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	@Test
	public void User_03_Customer_Infor() {
	custormerInforPage = homePage.clickToMyAccountLink();
	Assert.assertTrue(custormerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {

		
	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
