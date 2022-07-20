package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;

public class Post_01_Creat_Update_Delete_Search extends BaseTest {

	@Parameters({ "browser", "adminUrl", "endUserUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-condition - Step 01: Open browser and admin Site");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowerDriver(browserName, this.adminUrl);

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

		log.info("Creat_Post - Step 05: Enter to post body ");
		adminPostAddNewPage.enterToAddNewBody(postBodyValue);

		log.info("Creat_Post - Step 06: Click to 'Pre - Publish' button ");
		adminPostAddNewPage.clickToPrePushlistButton();

		log.info("Creat_Post - Step 07: Click to 'Publish' button ");
		adminPostAddNewPage.clickToPushlistButton();

		log.info("Creat_Post - Step 08: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02: Enter to 'Search textbox'");
		adminPostSearchPage.enterToSearchTexbox(postTitleValue);

		log.info("Search_Post - Step 03: Click to 'Search posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Search_Post - Step 04: Verify search table contains" + postTitleValue + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Title", postTitleValue));

		log.info("Search_Post - Step 05: Verify search table contains" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("Author", postTitleValue));

		log.info("Search_Post - Step 06: Open End User site ");
		userHomePage = adminPostSearchPage.openEndUserSite(this.endUserUrl);

		log.info("Search_Post - Step 07: Verify Post infor displayed on at Home Page");
		userHomePage.isPostInforDisplayed(postTitleValue);
		userHomePage.isPostInforDisplayed(postBodyValue);
		userHomePage.isPostInforDisplayed(postTitleValue);
		userHomePage.isPostInforDisplayed(postTitleValue);

		log.info("Search_Post - Step 08: Click to Post title");

		log.info("Search_Post - Step 09: Verify Post infor displayed on at Post Detail Page");
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
	String authorName = "automationfc";
	String adminUrl, endUserUrl;
	String currentDay = "20/07/2022";
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetailPage;

}
