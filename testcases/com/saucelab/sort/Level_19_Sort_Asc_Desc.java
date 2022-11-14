package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.sauceLab.LoginPageObject;
import pageObject.sauceLab.PageGeneratorManager;
import pageObject.sauceLab.ProductPageObject;

public class Level_19_Sort_Asc_Desc extends BaseTest {

	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		driver = getBrowserDriver(envName, browserName, serverName, ipAddress, portNumber, osName, osVersion);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}

	// @Test
	public void Sort_01_Name() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Name (A to Z)");

		Assert.assertTrue(productPage.isProductNameSortByAscending());
		// Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");

		Assert.assertTrue(productPage.isProductNameSortByDescending());

	}

	@Test
	public void Sort_02_Price() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Price (low to high)");

		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		// Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");

		Assert.assertTrue(productPage.isProductPriceSortByDescending());

	}

	@Parameters("envName")
	@AfterClass(alwaysRun = true)
	public void afterClass(String envName) {
		closeBrowserAndDriver(envName);
	}

	private WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;

}
