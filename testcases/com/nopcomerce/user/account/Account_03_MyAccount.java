package com.nopcomerce.user.account;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_Register_Cookie;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInforPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import utlities.DataHelper;

public class Account_03_MyAccount extends BaseTest {
	Environment environment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		ConfigFactory.setProperty("env", appURL);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowerDriver(browserName, environment.appUrl());
		dataFaker = DataHelper.getDataHelper();
		userData = UserDataMapper.getUserData();
		firstName = userData.getFirstName();
		lastName = userData.getLastName();
		emailAddress = dataFaker.getEmailAddress();
		company = userData.getCompany();
		country = userData.getCountry();
		province = userData.getProvince();
		city = userData.getCity();
		address1 = userData.getAddress1();
		address2 = userData.getAddress2();
		zip = userData.getZip();
		phoneNumber = userData.getPhoneNumber();
		faxNumber = userData.getFaxNumber();

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		log.info("Pre-Condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		loginPage.refreshCurrentPage(driver);

		log.info("Pre-Condition - Step 03: Verify ' My Account' page is displayed ");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	// @Test
	public void MyAccount_01_UpdateInfoCustomer() {
		log.info("MyAccount_01 - Step 01: Click to My Account link");
		homePage.clickToFooterLinksByText(driver, "My account");

		custormerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);

		log.info("MyAccount_01 - Step 02: Click to Checkbox Gender");
		custormerInforPage.clickToCheckboxByLabel(driver, "Female");

		log.info("MyAccount_01 - Step 03: Enter to FirstName textbox with value is " + firstName + "'");
		custormerInforPage.inputTextboxByID(driver, "FirstName", firstName);

		log.info("MyAccount_01 - Step 03: Enter to LastName textbox with value is " + lastName + "'");
		custormerInforPage.inputTextboxByID(driver, "LastName", lastName);

		log.info("MyAccount_01 - Step 04: Select Day of Birthday");
		custormerInforPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDateUpdate());

		log.info("MyAccount_01 - Step 05: Select Month of Birthday");
		custormerInforPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonthUpdate());

		log.info("MyAccount_01 - Step 06: Select year of Birthday");
		custormerInforPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYearUpdate());

		log.info("MyAccount_01 - Step 07: Enter to emailAdress textbox with value is " + emailAddress + "");
		custormerInforPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("MyAccount_01 - Step 08: Enter to Company name textbox with value is " + company + "");
		custormerInforPage.inputTextboxByID(driver, "Company", company);

		log.info("MyAccount_01 - Step 09: Click Save button");
		custormerInforPage.clickToButtonByText(driver, "Save");

		log.info("MyAccount_01 - Step 10: Verify FirstName updated success");
		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("MyAccount_01 - Step 11: Verify LastName updated success");
		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("MyAccount_01 - Step 12: Verify Email updated success");
		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);

		log.info("MyAccount_01 - Step 13: Verify Company updated success");
		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Company"), company);
	}

	@Test
	public void MyAccount_02_UpdateAddressCustomer() {
		log.info("MyAccount_02 - Step 01: Click to My Account link");
		homePage.clickToFooterLinksByText(driver, "My account");
		custormerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);

		log.info("MyAccount_02 - Step 02: Open address page");
		addressPage = custormerInforPage.openAddressPage(driver);

		log.info("MyAccount_02 - Step 03: Click to Add New button");
		addressPage.clickToButtonByText(driver, "Add new");

		log.info("MyAccount_02 - Step 05: Enter to FirstName textbox with value is " + firstName + "'");
		addressPage.inputTextboxByID(driver, "Address_FirstName", firstName);

		log.info("MyAccount_02 - Step 06: Enter to LastName textbox with value is " + lastName + "'");
		addressPage.inputTextboxByID(driver, "Address_LastName", lastName);

		log.info("MyAccount_02 - Step 07: Enter to emailAdress textbox with value is " + emailAddress + "");
		addressPage.inputTextboxByID(driver, "Address_Email", emailAddress);

		log.info("MyAccount_02 - Step 08: Enter to Company name textbox with value is " + company + "");
		addressPage.inputTextboxByID(driver, "Address_Company", company);

		log.info("MyAccount_02 - Step 09: Select Country with value : " + country + "");
		addressPage.selectToDropdownByName(driver, "Address.CountryId", country);

		log.info("MyAccount_02 - Step 10: Select Province with value :" + province + "");
		addressPage.selectToDropdownByName(driver, "Address.StateProvinceId", province);

		log.info("MyAccount_02 - Step 11: Enter to City textbox with value is " + city + "'");
		addressPage.inputTextboxByID(driver, "Address_City", city);

		log.info("MyAccount_02 - Step 12: Enter to Address 1 textbox with value is " + address1 + "'");
		addressPage.inputTextboxByID(driver, "Address_Address1", address1);

		log.info("MyAccount_02 - Step 13: Enter to Address 2 textbox with value is " + address2 + "'");
		addressPage.inputTextboxByID(driver, "Address_Address2", address2);

		log.info("MyAccount_02 - Step 14: Enter to Zip textbox with value is " + zip + "'");
		addressPage.inputTextboxByID(driver, "Address_ZipPostalCode", zip);

		log.info("MyAccount_02 - Step 15: Enter to Phone Numver textbox with value is " + phoneNumber + "'");
		addressPage.inputTextboxByID(driver, "Address_PhoneNumber", zip);

		log.info("MyAccount_02 - Step 16: Enter to Fax Numver textbox with value is " + faxNumber + "'");
		addressPage.inputTextboxByID(driver, "Address_FaxNumber", faxNumber);

		log.info("MyAccount_02 - Step 17: Click to  Save button");
		addressPage.clickToButtonByText(driver, "Save");

		log.info("MyAccount_02 - Step 18: Verify data updated success");
		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "LastName"), lastName);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Company"), company);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_CountryId"), country);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_StateProvinceId"), province);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_City"), city);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_Address1"), address1);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_Address2"), address2);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_ZipPostalCode"), zip);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_PhoneNumber"), phoneNumber);

		verifyEquals(custormerInforPage.getTextboxValueByID(driver, "Address_FaxNumber"), faxNumber);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private DataHelper dataFaker;
	private UserDataMapper userData;
	private String emailAddress, firstName, lastName, company, country, province, city, address1, address2, zip, phoneNumber, faxNumber;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject custormerInforPage;
	private UserAddressPageObject addressPage;
}
