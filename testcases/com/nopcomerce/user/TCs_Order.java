package com.nopcomerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_Register_Cookie;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.user.UserCategoryPageObject;
import pageObjects.user.UserCheckoutPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserProductDetailPageObject;
import pageObjects.user.UserShoppingCartPageObject;

public class TCs_Order extends BaseTest {
	Environment environment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		ConfigFactory.setProperty("env", appURL);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowerDriver(browserName, environment.appUrl());
		userData = UserDataMapper.getUserData();
		processor = userData.getProcessor();
		ram = userData.getRam();
		hdd = userData.getHDD();
		os = userData.getOS();
		software1 = userData.getSoftware1();
		software2 = userData.getSoftware2();
		editProcessor = userData.getEditProcessor();
		editRam = userData.getEditRam();
		editHDD = userData.getEditHDD();
		editOS = userData.getEditOS();
		editSoftware = userData.getEditSoftware();
		editQuantity = userData.getEditQuantity();

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);

		loginPage.refreshCurrentPage(driver);

		log.info("Precondition: Step 03: Open the desktops page");
		categogyPage = homePage.clickToSubmenuAtHeaderMenuByText(driver, "Computers", "Desktops ");

	}

	// @Test
	public void TC_01_AddProductToCart() {
		log.info("TC_01 - Step 01: Click to a product  at Categogy Page");
		productDetailPage = categogyPage.clickToProductByProductName("Build your own computer");

		log.info("TC_01 - Step 02: Select to Processor with value is: " + processor + "");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_1", processor);

		log.info("TC_01 - Step 03: Select to Ram with value is: " + ram + "");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_2", ram);

		log.info("TC_01 - Step 04: Select to HDD with value is :" + hdd + "");
		productDetailPage.clickToRadioByLabel(driver, hdd);

		log.info("TC_01 - Step 05: Select OS with value is: " + os + "");
		productDetailPage.clickToRadioByLabel(driver, os);

		log.info("TC_01 - Step 06: Select Software with value is :" + software1 + "");
		productDetailPage.clickToCheckboxByLabel(driver, software1);

		log.info("TC_01 - Step 07: Select Software with value is :" + software2 + "");
		productDetailPage.clickToCheckboxByLabel(driver, software2);

		log.info("TC_01 - Step 08: Click To 'Add to Cart' button");
		productDetailPage.clickToButtonByText(driver, "Add to cart");

		log.info("TC_01 - Step 09: Verify 'Add to cart' success message displayed");
		verifyEquals(productDetailPage.getPageSuccessNotification(), "The product has been added to your shopping cart");

		log.info("TC_01 - Step 010: Click To 'Close' button");
		productDetailPage.clickToCloseButton();

		log.info("TC_01 - Step 11: Move To 'Shopping Cart' link");
		productDetailPage.moveToShoppingCartLink();

		log.info("TC_01 - Step 12: Verify Product info displayed at Mini Shopping  cart");
		verifyEquals(productDetailPage.getProductMessageAtMiniShoppingCart(), "There are 1 item(s) in your cart.");

		verifyTrue(productDetailPage.isProductInforDislayedAtMiniShoppingCart(processor));

		verifyTrue(productDetailPage.isProductInforDislayedAtMiniShoppingCart(ram));

		verifyTrue(productDetailPage.isProductInforDislayedAtMiniShoppingCart(hdd));

		verifyTrue(productDetailPage.isProductInforDislayedAtMiniShoppingCart(os));

		verifyTrue(productDetailPage.isProductInforDislayedAtMiniShoppingCart(software1));

		verifyTrue(productDetailPage.isProductInforDislayedAtMiniShoppingCart(software2));

		verifyEquals(productDetailPage.getUnitPriceProductDisplayed(), "$1,500.00");

		verifyEquals(productDetailPage.getQuantityProductDisplayed(), "1");

		verifyEquals(productDetailPage.getSubTotalPriceProductDisplayed(), "$1,500.00");

		log.info("TC_01 - Step 13: Click To 'Shopping Cart' link");
		shoppingCartPage = productDetailPage.openShoppingCartPage();

		log.info("TC_01 - Step 14: Verify Product displayed at Shopping  cart");
		verifyTrue(shoppingCartPage.isProductDisplayedAtShoppingCartPage("Build your own computer"));

	}

	// @Test
	public void TC_02_EditProductInShoppingCart() throws InterruptedException {
		log.info("TC_02 - Step 01: Click to 'Edit' button");
		shoppingCartPage.clickToEditButton();

		log.info("TC_02 - Step 02: Select edit Processor with value is: " + editProcessor + "");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_1", editProcessor);

		log.info("TC_02 - Step 03: Select edit Ram with value is: " + editRam + "");
		productDetailPage.selectToDropdownByName(driver, "product_attribute_2", editRam);

		log.info("TC_02 - Step 04: Select edit HDD with value is :" + editHDD + "");
		productDetailPage.clickToRadioByLabel(driver, editHDD);

		log.info("TC_02 - Step 05: Select edit OS with value is: " + editOS + "");
		productDetailPage.clickToRadioByLabel(driver, editOS);

		log.info("TC_02 - Step 08: Input to quantity textbox with value is : " + editQuantity + "");
		productDetailPage.inputTextboxByID(driver, "product_enteredQuantity_1", editQuantity);

		log.info("TC_02 - Step 06: Uncheck to checkbox software value is:" + software1 + "");
		productDetailPage.unClickToCheckboxByLabel(driver, software1);

		log.info("TC_02 - Step 07: Uncheck to checkbox software value is:" + software2 + "");
		productDetailPage.unClickToCheckboxByLabel(driver, software2);

		log.info("TC_02 - Step 09: Verify price Product after edit info");
		verifyEquals(productDetailPage.getPriceProductAfterEditInfo(), "$1,320.00");

		log.info("TC_02 - Step 10: Click to 'Update' button");
		productDetailPage.clickToButtonByText(driver, "Update");

		log.info("TC_02 - Step 11: Verify 'Add to cart' success message displayed");
		verifyEquals(productDetailPage.getPageSuccessNotification(), "The product has been added to your shopping cart");

		log.info("TC_02 - Step 12: Click To 'Close' button");
		productDetailPage.clickToCloseButton();

		log.info("TC_02 - Step 13: Click To 'Shopping Cart' link");
		shoppingCartPage = productDetailPage.openShoppingCartPage();

		log.info("TC_02 - Step 14: Verify Product info after edit info displayed ");

		verifyTrue(shoppingCartPage.isEditProductInforDislayedAtShoppingCart(editProcessor));

		verifyTrue(shoppingCartPage.isEditProductInforDislayedAtShoppingCart(editRam));

		verifyTrue(shoppingCartPage.isEditProductInforDislayedAtShoppingCart(editHDD));

		verifyTrue(shoppingCartPage.isEditProductInforDislayedAtShoppingCart(editOS));

		verifyTrue(shoppingCartPage.isEditProductInforDislayedAtShoppingCart(editSoftware));

		log.info("TC_02 - Step 15: Verify Total Price Product after edit info displayed ");
		verifyEquals(shoppingCartPage.getTotalPriceProduct(), "$2,640.00");

	}

	// @Test
	public void TC_03_RemoveProductInShoppingCart() {
		log.info("TC_03 - Step 01: Click to  Remove button");
		shoppingCartPage.clickToRemoveButton();

		log.info("TC_03 - Step 02: Verify message shopping cart empty displayed ");
		verifyEquals(shoppingCartPage.getMessageShoppingCartEmpty(), "Your Shopping Cart is empty!");

		log.info("TC_03 - Step 03: Verify Product is Undisplayed at Shopping Cart ");
		verifyTrue(shoppingCartPage.isProductUndisplayedAtShoppingCartPage("Build your own computer"));
	}

	// @Test
	public void TC_04_UpdateProductInShoppingCart() {
		log.info("TC_04 - Step 01:  Click to image home page");
		homePage.clickToImageHomePage(driver);

		log.info("TC_04 - Step 02:  Open the desktops page");
		categogyPage = homePage.clickToSubmenuAtHeaderMenuByText(driver, "Computers", "Desktops ");

		log.info("TC_04 - Step 03: Click to a product  at Categogy Page");
		categogyPage.clickToAddToCartByProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("TC_04 - Step 04: Verify add  to cart success message is displayed ");
		verifyEquals(categogyPage.getAddToCartSuccessMessage(), "The product has been added to your shopping cart");

		log.info("TC_04 - Step 05: Click to close button");
		categogyPage.clickToCloseButton();

		log.info("TC_04 - Step 06: Click to 'Shopping cart' link");
		shoppingCartPage = categogyPage.openShoppingCartPage();

		log.info("TC_04 - Step 07: Edit quantity product");
		shoppingCartPage.inputToQtyTextbox("5");

		log.info("TC_04 - Step 08: Click to 'Update shopping cart' button");
		shoppingCartPage.clickToButtonByText(driver, "Update shopping cart");

		log.info("TC_04 - Step 09: Verify Total Price Product  after update info displayed ");
		verifyEquals(shoppingCartPage.getTotalPriceProduct(), "$2,500.00");
	}

	@Test
	public void TC_05_Checkout_PaymentMethodByCheque() {
		log.info("TC_05 - Step 01: Click To Image Home Page");
		loginPage.clickToImageHomePage(driver);

		log.info("TC_05 - Step 02: Click to a product  at Home Page");
		productDetailPage = homePage.clickToProductTitle(driver, "Apple MacBook Pro 13-inch");

		log.info("TC_05 - Step 03: Click To 'Add to Cart' button");
		productDetailPage.clickToButtonByText(driver, "Add to cart");

		log.info("TC_05 - Step 04: Verify 'Add to cart' success message displayed");
		verifyEquals(productDetailPage.getPageSuccessNotification(), "The product has been added to your shopping cart");

		log.info("TC_05 - Step 05: Click To 'Close' button");
		productDetailPage.clickToCloseButton();

		log.info("TC_05 - Step 06: Click To 'Shopping Cart' link");
		shoppingCartPage = productDetailPage.openShoppingCartPage();

		log.info("TC_05 - Step 07: Click To checkbox 'I agree with the terms .. ' ");
		shoppingCartPage.checkToTermsOfServiceCheckbox();

		log.info("TC_05 - Step 08: Click To checkout button");
		shoppingCartPage.clickToButtonByText(driver, " Checkout ");

		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);

		log.info("TC_05 - Step 08: Click To checkout button");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserDataMapper userData;
	String processor, ram, hdd, os, software1, software2, editProcessor, editRam, editHDD, editOS, editSoftware, editQuantity;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserProductDetailPageObject productDetailPage;
	private UserCategoryPageObject categogyPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserCheckoutPageObject checkoutPage;

}