package com.nopcomerce.user;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;

public class Level_22_Database_With_UI extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowerDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Verify_Database_With_UI() throws SQLException {
		log.info("TC_01 - Step 01: Get Employee list number at Customer Page");
		int employeeListNumberUI = homePage.getEmployeeListNumberUI();

		log.info("TC_01 - Step 02: Get Employee list number at Customer Page");
		int employeeListNumberInDB = homePage.getEmployeeListNumberInBD();

		log.info("TC_01 - Step 03: Verify Employee size in UI and DB are equal");
		verifyEquals(employeeListNumberUI, employeeListNumberInDB);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;

	private UserHomePageObject homePage;

}
