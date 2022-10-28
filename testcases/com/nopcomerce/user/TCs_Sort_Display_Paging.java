package com.nopcomerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.user.UserCategoryPageObject;
import pageObjects.user.UserHomePageObject;

public class TCs_Sort_Display_Paging extends BaseTest {
	Environment environment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		ConfigFactory.setProperty("env", appURL);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowerDriver(browserName, environment.appUrl());
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Precondition: Open the notebook page");
		categogyPage = homePage.clickToSubmenuAtHeaderMenuByText(driver, "Computers", "Notebooks");
	}

	@Test
	public void TC_01_SortWithNameAToZ() {
		log.info("TC_01 - Step 01: Select Sort list produce name A to Z");
		categogyPage.selectToDropdownByName(driver, "products-orderby", "Name: A to Z");

		log.info("TC_01 - Step 02: Verify list product name sort ascending");
		verifyTrue(categogyPage.isListProductNameSortByAscending());
	}

	@Test
	public void TC_02_SortWithNameZToA() {
		log.info("TC_02- Step 01: Select Sort list produce name Z to A");
		categogyPage.selectToDropdownByName(driver, "products-orderby", "Name: Z to A");

		log.info("TC_02 - Step 02: Verify list product name sort descending");
		verifyTrue(categogyPage.isListProductNameSortByDescending());
	}

	@Test
	public void TC_03_SortWithPriceLowToHigh() {
		log.info("TC_03 - Step 01: Select Sort with list produce price Low to High");
		categogyPage.selectToDropdownByName(driver, "products-orderby", "Price: Low to High");

		log.info("TC_03 - Step 02: Verify list product sort price ascending");
		verifyTrue(categogyPage.isListProductPriceSortByAscending());
	}

	@Test
	public void TC_04_SortWithPriceHighToLow() {
		log.info("TC_04 - Step 01: Selcet Sort with list produce price High to Low");
		categogyPage.selectToDropdownByName(driver, "products-orderby", "Price: High to Low");

		log.info("TC_04 - Step 02: Verify list product sort price descending");
		verifyTrue(categogyPage.isListProductPriceSortByDescending());
	}

	@Test
	public void TC_05_DisplayWithThreeProducts() {
		log.info("TC_01 - Step 01: Select display with Page size = 3");
		categogyPage.selectToDropdownByName(driver, "products-pagesize", "3");

		log.info("TC_01 - Step 02: Verify product displayed");
		verifyTrue(categogyPage.isProductListDisplayedByPageSizeReloadPage(3));

		log.info("TC_01 - Step 03: Verify Paging Next icon displayed ");
		verifyTrue(categogyPage.isPagePagingDisplayedByText("Next"));

		log.info("TC_01 - Step 04: Click to Paging Page 2 ");
		categogyPage.clickToPageNumbePagingrByText("2");

		log.info("TC_02 - Step 03: Verify Paging Previous displayed ");
		verifyTrue(categogyPage.isPagePagingDisplayedByText("Previous"));

	}

	@Test
	public void TC_06_DisplayWithSixProducts() {
		log.info("TC_06 - Step 01: Select display with Page size = 6");
		categogyPage.selectToDropdownByName(driver, "products-pagesize", "6");

		log.info("TC_06 - Step 02: Verify product displayed");
		verifyTrue(categogyPage.isProductListDisplayedByPageSizeNotReloadPage(6));

		log.info("TC_06 - Step 03: Verify Paging undisplayed ");
		verifyTrue(categogyPage.isPagePagingUndisplayed());

	}

	@Test
	public void TC_07_DisplayWithNineProducts() {
		log.info("TC_07 - Step 01: Select display with Page size = 9");
		categogyPage.selectToDropdownByName(driver, "products-pagesize", "9");

		log.info("TC_07 - Step 02: Verify product displayed");
		verifyTrue(categogyPage.isProductListDisplayedByPageSizeReloadPage(9));

		log.info("TC_07 - Step 03: Verify Paging undisplayed ");
		verifyTrue(categogyPage.isPagePagingUndisplayed());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserCategoryPageObject categogyPage;

}
