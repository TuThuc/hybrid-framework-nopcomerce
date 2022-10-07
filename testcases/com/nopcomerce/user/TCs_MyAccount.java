package com.nopcomerce.user;

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
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInforPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyProductReviewPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserProductReviewPageObject;
import utlities.DataHelper;

public class TCs_MyAccount extends BaseTest {
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
		oldPassword = userData.getValidPassword();
		newPassword = userData.getNewPassword();
		reviewTitle = userData.getReviewTitle();
		reviewText = userData.getReviewText();

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		log.info("Pre-Condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		loginPage.refreshCurrentPage(driver);

		log.info("Pre-Condition - Step 03: Verify ' My Account' page is displayed ");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
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

		log.info("MyAccount_02 - Step 01: Open address page");
		addressPage = custormerInforPage.openAddressPage(driver);

		log.info("MyAccount_02 - Step 02: Click to Add New button");
		addressPage.clickToButtonByText(driver, "Add new");

		log.info("MyAccount_02 - Step 03: Enter to FirstName textbox with value is " + firstName + "'");
		addressPage.inputTextboxByID(driver, "Address_FirstName", firstName);

		log.info("MyAccount_02 - Step 04: Enter to LastName textbox with value is " + lastName + "'");
		addressPage.inputTextboxByID(driver, "Address_LastName", lastName);

		log.info("MyAccount_02 - Step 05: Enter to emailAdress textbox with value is " + emailAddress + "");
		addressPage.inputTextboxByID(driver, "Address_Email", emailAddress);

		log.info("MyAccount_02 - Step 06: Enter to Company name textbox with value is " + company + "");
		addressPage.inputTextboxByID(driver, "Address_Company", company);

		log.info("MyAccount_02 - Step 07: Select Country with value : " + country + "");
		addressPage.selectToDropdownByName(driver, "Address.CountryId", country);

		log.info("MyAccount_02 - Step 08: Select Province with value :" + province + "");
		addressPage.selectToDropdownByName(driver, "Address.StateProvinceId", province);

		log.info("MyAccount_02 - Step 09 : Enter to City textbox with value is " + city + "'");
		addressPage.inputTextboxByID(driver, "Address_City", city);

		log.info("MyAccount_02 - Step 10: Enter to Address 1 textbox with value is " + address1 + "'");
		addressPage.inputTextboxByID(driver, "Address_Address1", address1);

		log.info("MyAccount_02 - Step 11: Enter to Address 2 textbox with value is " + address2 + "'");
		addressPage.inputTextboxByID(driver, "Address_Address2", address2);

		log.info("MyAccount_02 - Step 12: Enter to Zip textbox with value is " + zip + "'");
		addressPage.inputTextboxByID(driver, "Address_ZipPostalCode", zip);

		log.info("MyAccount_02 - Step 13: Enter to Phone Number textbox with value is " + phoneNumber + "'");
		addressPage.inputTextboxByID(driver, "Address_PhoneNumber", zip);

		log.info("MyAccount_02 - Step 14: Enter to Fax Number textbox with value is " + faxNumber + "'");
		addressPage.inputTextboxByID(driver, "Address_FaxNumber", faxNumber);

		log.info("MyAccount_02 - Step 15: Click to  Save button");
		addressPage.clickToButtonByText(driver, "Save");

		log.info("MyAccount_02 - Step 16: Verify data updated success");

		verifyTrue(addressPage.isValueAddressDisplayed(driver, firstName));

		// verifyTrue(addressPage.isValueAddressDisplayed(driver, emailAddress));

		// verifyTrue(addressPage.isValueAddressDisplayed(driver, faxNumber));

		verifyEquals(addressPage.getValueAddressByText(driver, company), company);

		verifyEquals(addressPage.getValueAddressByText(driver, address1), address1);

		verifyEquals(addressPage.getValueAddressByText(driver, address2), address2);

		verifyEquals(addressPage.getValueAddressByText(driver, country), country);

		verifyTrue(addressPage.isValueAddressDisplayed(driver, zip));

	}

	@Test
	public void MyAccount_03_Change_Password() {

		log.info("MyAccount_03 - Step 02: Open Change password page");
		addressPage.openPagesAtMyAccountByPageName(driver, "Change password");
		changePasswordPage = PageGeneratorManager.getUserChangePasswordPage(driver);

		log.info("MyAccount_03 - Step 03: Enter to Old Password textbox with value is " + oldPassword + "'");
		changePasswordPage.inputTextboxByID(driver, "OldPassword", oldPassword);

		log.info("MyAccount_03 - Step 04: Enter to New Password textbox with value is " + newPassword + "'");
		changePasswordPage.inputTextboxByID(driver, "NewPassword", newPassword);

		log.info("MyAccount_03 - Step 05: Enter to Confirm Password textbox with value is " + newPassword + "");
		changePasswordPage.inputTextboxByID(driver, "ConfirmNewPassword", newPassword);

		log.info("MyAccount_03 - Step 06: Click to  Change Password button");
		changePasswordPage.clickToButtonByText(driver, "Change password");

		log.info("MyAccount_03 - Step 07: Verify notify change password success");
		verifyEquals(changePasswordPage.getNotifyChangePasswordSuccess(), "Password was changed");

		log.info("MyAccount_03 - Step 08: Click close notify change password success");
		changePasswordPage.clickToCloseAtNotify();

		log.info("MyAccount_03 - Step 08: Click to Logout Link");
		changePasswordPage.clickToHeaderLinksByClassName(driver, "ico-logout");
		loginPage = PageGeneratorManager.getUserLoginPage(driver);

		log.info("MyAccount_03 - Step 09: Click to Login Link");
		loginPage.clickToHeaderLinksByClassName(driver, "ico-login");

		log.info("MyAccount_03 - Step 10: Enter to Email textbox with value is " + emailAddress + "'");
		loginPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("MyAccount_03 - Step 11: Enter to Password textbox with value is " + oldPassword + "'");
		loginPage.inputTextboxByID(driver, "Password", oldPassword);

		log.info("MyAccount_03 - Step 12: Click to Login Link");
		loginPage.clickToButtonByText(driver, "Log in");

		log.info("MyAccount_03 - Step 13: Verify error message displayed");
		verifyEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		log.info("MyAccount_03 - Step 14: Enter to Email textbox with value is " + emailAddress + "'");
		loginPage.inputTextboxByID(driver, "Email", emailAddress);

		log.info("MyAccount_03 - Step 15: Enter to Password textbox with value is " + newPassword + "'");
		loginPage.inputTextboxByID(driver, "Password", newPassword);

		log.info("MyAccount_03 - Step 16: Click to Login Link");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("MyAccount_03 - Step 17: Verify HomePage displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void MyAccount_04_Add_Product_Review() {

		log.info("MyAccount_04 - Step 01: Click Add to cart at a product");
		productDetailPage = homePage.clickToProductTitle(driver, "Build your own computer");

		log.info("MyAccount_04 - Step 02: Click  to Add your review");
		productReviewPage = productDetailPage.clickToAddYourReview();

		log.info("MyAccount_04 - Step 03: Enter  to Review title textbox with value is: " + reviewTitle + "");
		productReviewPage.inputTextboxByID(driver, "AddProductReview_Title", reviewTitle);

		log.info("MyAccount_04 - Step 04: Enter  to Review text textbox with value is: " + reviewText + "");
		productReviewPage.inputToReviewTextTextbox(reviewText);

		log.info("MyAccount_04 - Step 05: Click to Radio button");
		productReviewPage.clickToRadioRating();

		log.info("MyAccount_04 - Step 06: Click to Submit review button");
		productReviewPage.clickToButtonByText(driver, "Submit review");

		log.info("MyAccount_04 - Step 07: Verify message add Product review succsess ");
		verifyEquals(productReviewPage.getProductReviewSuccessMessage(), "Product review is successfully added.");

		log.info("MyAccount_04 - Step 08: Click to My account link ");
		productReviewPage.clickToHeaderLinksByClassName(driver, "ico-account");

		custormerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);

		log.info("MyAccount_04 - Step 09: open My Product Reviews ");
		custormerInforPage.openPagesAtMyAccountByPageName(driver, "My product reviews");

		myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);

		log.info("MyAccount_04 - Step 10: Verify Product Review Title displayed ");
		verifyEquals(myProductReviewPage.getValueReviewTitle(driver, reviewTitle), reviewTitle);

		log.info("MyAccount_04 - Step 11: Verify Product Review text displayed ");
		verifyEquals(myProductReviewPage.getValueReviewText(driver, reviewText), reviewText);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private DataHelper dataFaker;
	private UserDataMapper userData;
	private String emailAddress, firstName, lastName, company, country, province, city, address1, address2, zip, phoneNumber, faxNumber, oldPassword, newPassword, reviewTitle, reviewText;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject custormerInforPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserProductDetailPageObject productDetailPage;
	private UserProductReviewPageObject productReviewPage;
	private UserMyProductReviewPageObject myProductReviewPage;
}
