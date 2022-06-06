package com.jquery.datatable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.JQuery.HomePageObject;
import pageObject.JQuery.PageGeneratorManager;
public class Level_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowerDriver(browserName, appURL);
		homePage =  PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("15");
		homePage.sleepInSecond(3);
		homePage.openPagingByPageNumber("5");
		homePage.sleepInSecond(3);
	}

	@Test
	public void User_02_Table_02() {
		
	}

	@Test
	public void Table_03() {
		
	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
