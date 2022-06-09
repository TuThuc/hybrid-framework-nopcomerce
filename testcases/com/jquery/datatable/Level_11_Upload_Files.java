package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.JQuery_Datatable.HomePageObject;

public class Level_11_Upload_Files extends BaseTest {
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowerDriver(browserName, appURL);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {

	}

	@Test
	public void Upload_02_Multi_File_Per_Time() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
