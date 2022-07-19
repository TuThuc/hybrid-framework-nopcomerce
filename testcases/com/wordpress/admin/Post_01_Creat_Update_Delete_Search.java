package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;

public class Post_01_Creat_Update_Delete_Search extends BaseTest {

	@Parameters({ "browser", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-condition - Step 01: Open browser and admin Url");
		driver = getBrowerDriver(browserName, adminUrl);

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Enter to Username textbox with value " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-condition - Step 03: Enter to Password textbox with value " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-condition - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Creat_New_Post() {
		log.info("Creat_Post - Step 01: Click to 'Post' menu link ");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Creat_Post - Step 02: Get 'Search Post' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Creat_Post - Step 03: Click to 'Add New' button ");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Creat_Post - Step 04: Enter to post title ");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitleValue);

		log.info("Creat_Post - Step 05: Enter to body ");
		adminPostAddNewPage.enterToAddNewBody(postBodyValue);

		log.info("Creat_Post - Step 06: Click to 'Publish' button ");
		adminPostAddNewPage.clickToPrePushlistButton();
		

		log.info("Creat_Post - Step 07: Click to 'Publish' button ");
		adminPostAddNewPage.clickToPushlistButton();

		log.info("Creat_Post - Step 03: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Bài viết đã được đăng."));
	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

	}

	@Test
	public void Post_02_View_Post() {
		log.info("View_Post - Step 03: Verify 'Post published' message is displayed");
	}

	@Test
	public void Post_03_View_Post() {

	}

	@Test
	public void Post_04_Edit_Post() {

	}

	@Test
	public void Post_05_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String adminPassword = "automationfc";
	private String adminUsername = "automationfc";
	int randomNumber = generateFakeNumber();
	String searchPostUrl;
	String postTitleValue = "Live codeing Title" + randomNumber;
	String postBodyValue = "Live codeing Body" + randomNumber;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
}
