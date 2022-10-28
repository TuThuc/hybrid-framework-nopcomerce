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
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserSearchPageObject;

public class TCs_Search extends BaseTest {
	Environment environment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		ConfigFactory.setProperty("env", appURL);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowerDriver(browserName, environment.appUrl());
		// dataFaker = DataHelper.getDataHelper();
		userData = UserDataMapper.getUserData();
		productNameRelative = userData.getProductNameRelative();
		productNameAbsolute = userData.getProductNameAbsolute();
		productNameSearchWithCategories = userData.getProductNameSearchCategories();

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
	public void Search_01_SearchWithEmptyData() {
		log.info("Search_01 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_01 - Step 02: Enter to Search textbox with value is:" + "");
		searchPage.inputTextboxByID(driver, "q", "");

		log.info("Search_01 - Step 03: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_01 - Step 04: Verify message error displayed");
		verifyEquals(searchPage.getSearchErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_02_SearchWithDataNotExist() {
		log.info("Search_02 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_02 - Step 02: Enter to Search textbox with value is:" + userData.getProductNameNotExist() + "");
		searchPage.inputTextboxByID(driver, "q", userData.getProductNameNotExist());

		log.info("Search_02 - Step 03: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_02 - Step 04: Verify message error displayed");
		verifyEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_03_SearchWithProductNameRelative() {
		log.info("Search_03 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_03 - Step 02: Enter to Search textbox with value is:" + productNameRelative + "");
		searchPage.inputTextboxByID(driver, "q", productNameRelative);

		log.info("Search_03 - Step 03: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_03 - Step 04: Verify the number of resulting searches displayed");
		verifyEquals(searchPage.getNumberProducByProductTitle(), 2);

		log.info("Search_03 - Step 05: Verify the product name of resulting  contains  text is " + productNameRelative + "");
		verifyTrue(searchPage.isListProductNameDisplayed(driver, productNameRelative));

	}

	@Test
	public void Search_04_SearchWithProductNameAbsolute() {
		log.info("Search_03 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_03 - Step 02: Enter to Search textbox with value is:" + productNameAbsolute + "");
		searchPage.inputTextboxByID(driver, "q", productNameAbsolute);

		log.info("Search_03 - Step 03: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_03 - Step 04: Verify the number of resulting searches displayed");
		verifyEquals(searchPage.getNumberProducByProductTitle(), 1);

		log.info("Search_03 - Step 05: Verify the product name of resulting  contains  text is " + productNameAbsolute + "");
		verifyTrue(searchPage.isListProductNameDisplayed(driver, productNameAbsolute));

	}

	@Test
	public void Search_05_AdvancedSearchWithParentCategories() {
		log.info("Search_05 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_05 - Step 02: Enter to Search textbox with value is:" + productNameSearchWithCategories + "");
		searchPage.inputTextboxByID(driver, "q", productNameSearchWithCategories);

		log.info("Search_05 - Step 03: Click to Advanced search checkbox");
		searchPage.clickToCheckboxByLabel(driver, "Advanced search");

		log.info("Search_05 - Step 04: Select to Category dropdown");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search_05 - Step 05: unClick to Automatically search sub categories checkbox");
		searchPage.unClickToCheckboxByLabel(driver, "Automatically search sub categories");

		log.info("Search_05 - Step 06: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_05 - Step 07: Verify message error displayed");
		verifyEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_06_AdvancedSearchWithSubCategories() {
		log.info("Search_06 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_06 - Step 02: Enter to Search textbox with value is:" + productNameSearchWithCategories + "");
		searchPage.inputTextboxByID(driver, "q", productNameSearchWithCategories);

		log.info("Search_06 - Step 03: Click to Advanced search checkbox");
		searchPage.clickToCheckboxByLabel(driver, "Advanced search");

		log.info("Search_06 - Step 04: Select to Category dropdown");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search_06 - Step 05: Click to Automatically search sub categories checkbox");
		searchPage.clickToCheckboxByLabel(driver, "Automatically search sub categories");

		log.info("Search_06 - Step 06: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_06 - Step 07: Verify the number of resulting searches displayed");
		verifyEquals(searchPage.getNumberProducByProductTitle(), 1);

		log.info("Search_06 - Step 08: Verify the product name of resulting  contains  text is " + productNameSearchWithCategories + "");
		verifyTrue(searchPage.isListProductNameDisplayed(driver, productNameSearchWithCategories));

	}

	@Test
	public void Search_07_AdvancedSearchWithIncorrectManufacturer() {
		log.info("Search_08 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_07 - Step 02: Enter to Search textbox with value is:" + productNameSearchWithCategories + "");
		searchPage.inputTextboxByID(driver, "q", productNameSearchWithCategories);

		log.info("Search_07 - Step 03: Click to Advanced search checkbox");
		searchPage.clickToCheckboxByLabel(driver, "Advanced search");

		log.info("Search_07 - Step 04: Select to Category dropdown");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search_07 - Step 05: Click to Automatically search sub categories checkbox");
		searchPage.clickToCheckboxByLabel(driver, "Automatically search sub categories");

		log.info("Search_07 - Step 06: Select to Manufacturer dropdown");
		searchPage.selectToDropdownByName(driver, "mid", "HP");

		log.info("Search_07 - Step 07: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_07 - Step 09: Verify message error displayed");
		verifyEquals(searchPage.getSearchErrorMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_08_AdvancedSearchWithCorrectManufacturer() {
		log.info("Search_08 - Step 01: Click to Search link");
		homePage.clickToFooterLinksByText(driver, "Search");

		searchPage = PageGeneratorManager.getUserSearchPage(driver);

		log.info("Search_08 - Step 02: Enter to Search textbox with value is:" + productNameSearchWithCategories + "");
		searchPage.inputTextboxByID(driver, "q", productNameSearchWithCategories);

		log.info("Search_08 - Step 03: Click to Advanced search checkbox");
		searchPage.clickToCheckboxByLabel(driver, "Advanced search");

		log.info("Search_08 - Step 04: Select to Category dropdown");
		searchPage.selectToDropdownByName(driver, "cid", "Computers");

		log.info("Search_08 - Step 05: Click to Automatically search sub categories checkbox");
		searchPage.clickToCheckboxByLabel(driver, "Automatically search sub categories");

		log.info("Search_08 - Step 06: Select to Manufacturer dropdown");
		searchPage.selectToDropdownByName(driver, "mid", "Apple");

		log.info("Search_08 - Step 07: Click to Search button");
		searchPage.clickToButtonSearch();

		log.info("Search_08 - Step 08: Verify the number of resulting searches displayed");
		verifyEquals(searchPage.getNumberProducByProductTitle(), 1);

		log.info("Search_08 - Step 09: Verify the product name of resulting  contains  text is " + productNameSearchWithCategories + "");
		verifyTrue(searchPage.isListProductNameDisplayed(driver, productNameSearchWithCategories));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserDataMapper userData;
	String productNameRelative, productNameAbsolute, productNameSearchWithCategories;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserSearchPageObject searchPage;

}
