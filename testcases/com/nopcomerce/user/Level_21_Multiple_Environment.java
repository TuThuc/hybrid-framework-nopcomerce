package com.nopcomerce.user;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;


public class Level_21_Multiple_Environment extends BaseTest {

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowerDriver(browserName, appUrl);
		System.out.println(driver.getCurrentUrl());

		
	}

	@Test
	public void User_01_Register() {
	}

	@Test
	public void User_02_Login() {
		
	}

	@Test
	public void User_03_My_Account() {
	

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	
}
