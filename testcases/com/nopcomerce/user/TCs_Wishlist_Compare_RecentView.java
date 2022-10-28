package com.nopcomerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.user.UserCategoryPageObject;
import pageObjects.user.UserCompareProductPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserRecentlyViewedProductPageObject;
import pageObjects.user.UserShoppingCartPageObject;
import pageObjects.user.UserWishlistPageObject;

public class TCs_Wishlist_Compare_RecentView extends BaseTest {
	Environment environment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		ConfigFactory.setProperty("env", appURL);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowerDriver(browserName, environment.appUrl());
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);

		loginPage.refreshCurrentPage(driver);

		log.info("Pre-Condition - Step 03: Click To Image Home Page");
		loginPage.clickToImageHomePage(driver);

		log.info("Pre-condition - Step 04: Click to a product  at Home Page");
		productDetailPage = homePage.clickToProductTitle(driver, "Apple MacBook Pro 13-inch");

	}

	@Test
	public void TC_01_AddToWishlist() {

		log.info("TC_01 - Step 01: Click to add to wishlist");
		productDetailPage.clickToAddToWishlist();

		log.info("TC_01 - Step 02: Verify success message is displayed ");
		verifyEquals(productDetailPage.getPageSuccessNotification(), "The product has been added to your wishlist");

		log.info("TC_01 - Step 03: Click to close button");
		productDetailPage.clickToCloseButton();

		log.info("TC_01 - Step 04: Click to Wishlist link ");
		productDetailPage.clickToHeaderLinksByText(driver, "Wishlist");

		wishlistPage = PageGeneratorManager.getUserWhistlistPage(driver);

		log.info("TC_01 - Step 05: Verify Product is displayed at wishlist Page ");
		verifyTrue(wishlistPage.isProductDisplayedAtWishlist("Apple MacBook Pro 13-inch"));

		log.info("TC_01 - Step 06: Click to wishlist URL");
		wishlistPage.clickToWishlistURL();

		log.info("TC_01 - Step 07: Verify Product is displayed at wishlist Page ");
		verifyTrue(wishlistPage.isProductDisplayedAtWishlist("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_02_AddToCarFromWishlistPage() {
		log.info("TC_02 - Step 01: Back To Wishlist Page ");
		wishlistPage.backToPage(driver);

		log.info("TC_02 - Step 02: Click to Checkbox Add to cart");
		wishlistPage.clickToCheckboxAddToCart();

		log.info("TC_02 - Step 03: Click to button Add to cart");
		wishlistPage.clickToButtonByText(driver, "Add to cart");

		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);

		log.info("TC_02 - Step 04: Verify Product is displayed at wishlist Page ");
		verifyTrue(shoppingCartPage.isProductDisplayedAtShoppingCartPage("Apple MacBook Pro 13-inch"));

		log.info("TC_02 - Step 05: Click to Wishlist link ");
		shoppingCartPage.clickToHeaderLinksByText(driver, "Wishlist");

		wishlistPage = PageGeneratorManager.getUserWhistlistPage(driver);

		log.info("TC_02 - Step 06: Verify Product is Undisplayed at wishlist Page ");
		verifyTrue(wishlistPage.isProductUnDisplayedAtWishlistPage("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_03_RemoveProductInWishlistPage() {
		log.info("TC_03 - Step 01: Click To Image Home Page");
		loginPage.clickToImageHomePage(driver);

		log.info("TC_03 - Step 02: Click to a product  at Home Page");
		productDetailPage = homePage.clickToProductTitle(driver, "Apple MacBook Pro 13-inch");

		log.info("TC_03 - Step 03: Click to add to wishlist");
		productDetailPage.clickToAddToWishlist();

		log.info("TC_03 - Step 04: Verify success message is displayed ");
		verifyEquals(productDetailPage.getPageSuccessNotification(), "The product has been added to your wishlist");

		log.info("TC_03 - Step 05: Click to close button");
		productDetailPage.clickToCloseButton();

		log.info("TC_03 - Step 06: Click to Wishlist link ");
		productDetailPage.clickToHeaderLinksByText(driver, "Wishlist");

		wishlistPage = PageGeneratorManager.getUserWhistlistPage(driver);

		log.info("TC_03 - Step 07: Click to  Remove button");
		wishlistPage.clickToRomoveButton();

		log.info("TC_03 - Step 08: Verify message is displayed ");
		verifyEquals(wishlistPage.getMessageWishlistEmpty(), "The wishlist is empty!");

		log.info("TC_03 - Step 09: Verify Product is Undisplayed at wishlist Page ");
		verifyTrue(wishlistPage.isProductUnDisplayedAtWishlistPage("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_04_AddProductToCompare() {
		log.info("TC_04 - Step 01: Click To Image Home Page");
		loginPage.clickToImageHomePage(driver);

		log.info("TC_04 - Step 02: Add Product to Compare list");
		homePage.AddProductToCompareListByProductName(driver, "Apple MacBook Pro 13-inch");

		log.info("TC_04 - Step 03: Verify add  to compare success message is displayed ");
		verifyEquals(homePage.getAddToCompareSuccessMessage(), "The product has been added to your product comparison");

		log.info("TC_04 - Step 04: Click to close button");
		homePage.clickToCloseButton();

		log.info("TC_04 - Step 05: Add Product to Compare list");
		homePage.AddProductToCompareListByProductName(driver, "Build your own computer");

		log.info("TC_04 - Step 06: Verify add  to compare success message is displayed ");
		verifyEquals(homePage.getAddToCompareSuccessMessage(), "The product has been added to your product comparison");

		log.info("TC_04 - Step 07: Click to close button");
		homePage.clickToCloseButton();

		log.info("TC_04 - Step 08: Open Compare Product list Page ");
		homePage.clickToFooterLinksByText(driver, "Compare products list");

		compareProductPage = PageGeneratorManager.getUserCompareProductPage(driver);

		log.info("TC_04 - Step 09: Verify Product info is displayed ");
		verifyEquals(compareProductPage.getProductNameByText("Apple MacBook Pro 13-inch"), "Apple MacBook Pro 13-inch");

		verifyEquals(compareProductPage.getProductNameByText("Build your own computer"), "Build your own computer");

		verifyEquals(compareProductPage.getProductPriceByText("$1,800.00"), "$1,800.00");

		verifyEquals(compareProductPage.getProductPriceByText("$1,200.00"), "$1,200.00");

		log.info("TC_04 - Step 10: Click To Clear list button");
		compareProductPage.clickToClearListButton();

		log.info("TC_04 - Step 11: Verify  message is displayed ");
		verifyEquals(compareProductPage.getMessageCompareProductEmpty(), "You have no items to compare.");

		log.info("TC_04 - Step 12: Verify  Product  is undisplayed after click clear list button ");
		verifyTrue(compareProductPage.isProductUnDisplayedAtCompareProductPage("Apple MacBook Pro 13-inch"));
		verifyTrue(compareProductPage.isProductUnDisplayedAtCompareProductPage("Build your own computer"));

	}

	@Test
	public void TC_05_RecentlyViewedProducts() {
		log.info("TC_05 - Step 01: Click To Image Home Page");
		loginPage.clickToImageHomePage(driver);

		log.info("TC_05 - Step 02: Open the notebook product list");
		categogyPage = homePage.clickToSubmenuAtHeaderMenuByText(driver, "Computers", "Notebooks");

		log.info("TC_05 - Step 03: Click to a product at Page ");
		productDetailPage = categogyPage.clickToProductByProductName("Apple MacBook Pro 13-inch");

		log.info("TC_05 - Step 04: Back to notebook product list page");
		productDetailPage.backToPage(driver);

		log.info("TC_05 - Step 05: Click to a product at Page ");
		productDetailPage = categogyPage.clickToProductByProductName("Asus N551JK-XO076H Laptop");

		log.info("TC_05 - Step 06: Back to notebook product list page");
		productDetailPage.backToPage(driver);

		log.info("TC_05 - Step 07: Click to a product at Page ");
		productDetailPage = categogyPage.clickToProductByProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook");

		log.info("TC_05 - Step 08: Back to notebook product list page");
		productDetailPage.backToPage(driver);

		log.info("TC_05 - Step 09: Click to a product at Page ");
		productDetailPage = categogyPage.clickToProductByProductName("Lenovo Thinkpad X1 Carbon Laptop");

		log.info("TC_05 - Step 10: Back to notebook product list page");
		productDetailPage.backToPage(driver);

		log.info("TC_05 - Step 11: Click to a product at Page ");
		productDetailPage = categogyPage.clickToProductByProductName("Samsung Series 9 NP900X4C Premium Ultrabook");

		log.info("TC_05 - Step 12: open Recently viewed product page ");
		productDetailPage.clickToFooterLinksByText(driver, "Recently viewed products");

		recentlyViewedProductPage = PageGeneratorManager.getUserRecentlyViewedProductPage(driver);

		log.info("TC_05 - Step 13: Verify the number of products displayed on the page ");
		verifyEquals(recentlyViewedProductPage.getNumberRecentlyViewedProductDisplayed(), 3);

		log.info("TC_05 - Step 14: Verify the product name displayed on the page");
		verifyTrue(recentlyViewedProductPage.isRecentlyViewedProductDisplayedByProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook"));

		log.info("TC_05 - Step 15: Verify the product name displayed on the page");
		verifyTrue(recentlyViewedProductPage.isRecentlyViewedProductDisplayedByProductName("Lenovo Thinkpad X1 Carbon Laptop"));

		log.info("TC_05 - Step 16: Verify the product name displayed on the page");
		verifyTrue(recentlyViewedProductPage.isRecentlyViewedProductDisplayedByProductName("Samsung Series 9 NP900X4C Premium Ultrabook"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserProductDetailPageObject productDetailPage;
	private UserWishlistPageObject wishlistPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserCompareProductPageObject compareProductPage;
	private UserCategoryPageObject categogyPage;
	private UserRecentlyViewedProductPageObject recentlyViewedProductPage;

}
