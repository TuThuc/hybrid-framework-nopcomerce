package com.nopcomerce.user.study;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;

public class Level_22_Database_With_UI extends BaseTest {

	@Parameters({ "envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
		driver = getBrowserDriver(envName, browserName, serverName, ipAddress, portNumber, osName, osVersion);
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

	@Parameters("envName")
	@AfterClass(alwaysRun = true)
	public void afterClass(String envName) {
		closeBrowserAndDriver(envName);
	}

	private WebDriver driver;

	private UserHomePageObject homePage;

}
