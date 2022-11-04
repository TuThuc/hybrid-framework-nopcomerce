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
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
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
		firstName = userData.geFirstNameBilling();
		lastName = userData.getLastNameBilling();
		emailAddress = userData.getEmailAddressBilling();
		country = userData.getCountryBilling();
		province = userData.getProvinceBilling();
		city = userData.getCityBilling();
		address1 = userData.getAddress1Billing();
		address2 = userData.getAddress2Billing();
		zip = userData.getZipBilling();
		phoneNumber = userData.getPhoneNumberBilling();
		faxNumber = userData.getFaxNumber();
		cardHolderName = userData.getCardHoderName();
		cardNumber = userData.getCardNumber();
		cardCode = userData.getCardCode();
		totalPrice = "$3,600.00";

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);

		loginPage.refreshCurrentPage(driver);

		log.info("Precondition: Step 03: Open the desktops page");
		categogyPage = homePage.clickToSubmenuAtHeaderMenuByText(driver, "Computers", "Desktops ");

	}

	@Test
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

	@Test
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

	@Test
	public void TC_03_RemoveProductInShoppingCart() {
		log.info("TC_03 - Step 01: Click to  Remove button");
		shoppingCartPage.clickToRemoveButton();

		log.info("TC_03 - Step 02: Verify message shopping cart empty displayed ");
		verifyEquals(shoppingCartPage.getMessageShoppingCartEmpty(), "Your Shopping Cart is empty!");

		log.info("TC_03 - Step 03: Verify Product is Undisplayed at Shopping Cart ");
		verifyTrue(shoppingCartPage.isProductUndisplayedAtShoppingCartPage("Build your own computer"));
	}

	@Test
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

		log.info("TC_05 - Step 09: Enter to FirstName textbox with value is " + firstName + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_FirstName", firstName);

		log.info("TC_05 - Step 10: Enter to LastName textbox with value is " + lastName + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_LastName", lastName);

		log.info("TC_05 - Step 11: Enter to emailAdress textbox with value is " + emailAddress + "");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_Email", emailAddress);

		log.info("TC_05 - Step 12: Select Country with value : " + country + "");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", country);

		log.info("TC_05 - Step 13: Select Province with value :" + province + "");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.StateProvinceId", province);

		log.info("TC_05 - Step 14 : Enter to City textbox with value is " + city + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_City", city);

		log.info("TC_05 - Step 15: Enter to Address 1 textbox with value is " + address1 + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_Address1", address1);

		log.info("TC_05 - Step 16: Enter to Address 2 textbox with value is " + address2 + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_Address2", address2);

		log.info("TC_05 - Step 17: Enter to Zip textbox with value is " + zip + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zip);

		log.info("TC_05 - Step 18: Enter to Phone Number textbox with value is " + phoneNumber + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_PhoneNumber", zip);

		log.info("TC_05 - Step 19: Enter to Fax Number textbox with value is " + faxNumber + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_FaxNumber", faxNumber);

		log.info("TC_05 - Step 20: Click to  Continue button");
		checkoutPage.clickToButtonByText(driver, "Continue");

		log.info("TC_05 - Step 21: Click to  Continue button at shipping method");
		checkoutPage.clickToButtonContinueByID("shipping-method-buttons-container");

		log.info("TC_05 - Step 22: Click to  Continue button at payment method");
		checkoutPage.clickToButtonContinueByID("payment-method-buttons-container");

		log.info("TC_05 - Step 23: Verify Payment info displayed");
		verifyTrue(checkoutPage.isPaymentInfoDisplayed("New York, NY 10001"));

		log.info("TC_05 - Step 24: Click to  Continue button at payment Info");
		checkoutPage.clickToButtonContinueByID("payment-info-buttons-container");

		log.info("TC_05 - Step 25: Verify Billing address displayed");
		verifyTrue(checkoutPage.isBillingAddressDisplayed(emailAddress));
		verifyTrue(checkoutPage.isBillingAddressDisplayed(address1));

		log.info("TC_05 - Step 26: Verify Shipping address displayed");
		verifyTrue(checkoutPage.isShippingAddressDisplayed(faxNumber));
		verifyTrue(checkoutPage.isShippingAddressDisplayed(country));

		verifyEquals(checkoutPage.totalPriceProductCheckout(), totalPrice);

		log.info("TC_05 - Step 27: Click To Confirm Button");
		checkoutPage.clickToButtonContinueByID("confirm-order-buttons-container");

		log.info("TC_05 - Step 28: Verify Order successful message displayed");
		verifyEquals(checkoutPage.orderSuccessMessageDisplayed(), "Your order has been successfully processed!");

		log.info("TC_05 - Step 29: Verify Order number  displayed");
		verifyTrue(checkoutPage.isOrderNumberDisplayed());

		log.info("TC_05 - Step 30: Open My Account page");
		customerInfoPage = checkoutPage.openCustomerInfoPage();

		log.info("TC_05 - Step 31: Open Order page");
		orderPage = customerInfoPage.openOrderPage();

		log.info("TC_05 - Step 32: Verify total price displayed");
		verifyEquals(orderPage.totalPriceProductCheckout(), totalPrice);

	}

	@Test
	public void TC_06_Checkout_PaymentMethodByCard() {
		log.info("TC_06 - Step 01: Click To Image Home Page");
		loginPage.clickToImageHomePage(driver);

		log.info("TC_06 - Step 02: Click to a product  at Home Page");
		productDetailPage = homePage.clickToProductTitle(driver, "Apple MacBook Pro 13-inch");

		log.info("TC_06 - Step 03: Click To 'Add to Cart' button");
		productDetailPage.clickToButtonByText(driver, "Add to cart");

		log.info("TC_06 - Step 04: Verify 'Add to cart' success message displayed");
		verifyEquals(productDetailPage.getPageSuccessNotification(), "The product has been added to your shopping cart");

		log.info("TC_06 - Step 05: Click To 'Close' button");
		productDetailPage.clickToCloseButton();

		log.info("TC_06 - Step 06: Click To 'Shopping Cart' link");
		shoppingCartPage = productDetailPage.openShoppingCartPage();

		log.info("TC_06 - Step 07: Click To checkbox 'I agree with the terms .. ' ");
		shoppingCartPage.checkToTermsOfServiceCheckbox();

		log.info("TC_06 - Step 08: Click To checkout button");
		shoppingCartPage.clickToButtonByText(driver, " Checkout ");

		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);

		log.info("TC_06 - Step 09: Enter to FirstName textbox with value is " + firstName + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_FirstName", firstName);

		log.info("TC_06 - Step 10: Enter to LastName textbox with value is " + lastName + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_LastName", lastName);

		log.info("TC_06 - Step 11: Enter to emailAdress textbox with value is " + emailAddress + "");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_Email", emailAddress);

		log.info("TC_06 - Step 12: Select Country with value : " + country + "");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", country);

		log.info("TC_06 - Step 13: Select Province with value :" + province + "");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.StateProvinceId", province);

		log.info("TC_06 - Step 14 : Enter to City textbox with value is " + city + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_City", city);

		log.info("TC_06 - Step 15: Enter to Address 1 textbox with value is " + address1 + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_Address1", address1);

		log.info("TC_06 - Step 16: Enter to Address 2 textbox with value is " + address2 + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_Address2", address2);

		log.info("TC_06 - Step 17: Enter to Zip textbox with value is " + zip + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zip);

		log.info("TC_06 - Step 18: Enter to Phone Number textbox with value is " + phoneNumber + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_PhoneNumber", zip);

		log.info("TC_06 - Step 19: Enter to Fax Number textbox with value is " + faxNumber + "'");
		checkoutPage.inputTextboxByID(driver, "BillingNewAddress_FaxNumber", faxNumber);

		log.info("TC_06 - Step 20: Click to  Continue button");
		checkoutPage.clickToButtonByText(driver, "Continue");

		log.info("TC_06 - Step 21: Click to  Continue button at shipping method");
		checkoutPage.clickToButtonContinueByID("shipping-method-buttons-container");

		log.info("TC_06 - Step 22: Click to 'Credit Card' checkbox");
		checkoutPage.clickToCheckboxByLabel(driver, "Credit Card");

		log.info("TC_06 - Step 23: Click to  Continue button at payment method");
		checkoutPage.clickToButtonContinueByID("payment-method-buttons-container");

		log.info("TC_06 - Step 24: Input to 'Cardholder name' textbox");
		checkoutPage.inputTextboxByID(driver, "CardholderName", cardHolderName);

		log.info("TC_06 - Step 25: Input to 'Card number' textbox");
		checkoutPage.inputTextboxByID(driver, "CardNumber", cardNumber);

		log.info("TC_06 - Step 26: Select to 'Expriration date' dropdown");
		checkoutPage.selectToDropdownByName(driver, "ExpireMonth", "12");

		log.info("TC_06 - Step 27: Select to 'Expriration date' dropdown");
		checkoutPage.selectToDropdownByName(driver, "ExpireYear", "2023");

		log.info("TC_06 - Step 28: Input to 'Card code' textbox");
		checkoutPage.inputTextboxByID(driver, "CardCode", cardCode);

		log.info("TC_06 - Step 29: Click to  Continue button at payment Info");
		checkoutPage.clickToButtonContinueByID("payment-info-buttons-container");

		log.info("TC_06 - Step 30: Verify Billing address displayed");
		verifyTrue(checkoutPage.isBillingAddressDisplayed(firstName));
		verifyTrue(checkoutPage.isBillingAddressDisplayed(emailAddress));
		verifyTrue(checkoutPage.isBillingAddressDisplayed(address1));

		verifyEquals(checkoutPage.getPaymentMedthodDisplayed(), "Credit Card");

		log.info("TC_06 - Step 31: Verify Shipping address displayed");
		verifyTrue(checkoutPage.isShippingAddressDisplayed(faxNumber));
		verifyTrue(checkoutPage.isShippingAddressDisplayed(country));

		verifyEquals(checkoutPage.totalPriceProductCheckout(), totalPrice);

		log.info("TC_06 - Step 32: Click To Confirm Button");
		checkoutPage.clickToButtonContinueByID("confirm-order-buttons-container");

		log.info("TC_06 - Step 33: Verify Order successful message displayed");
		verifyEquals(checkoutPage.orderSuccessMessageDisplayed(), "Your order has been successfully processed!");

		log.info("TC_06 - Step 34: Verify Order number  displayed");
		verifyTrue(checkoutPage.isOrderNumberDisplayed());

		log.info("TC_06 - Step 35: Open My Account page");
		customerInfoPage = checkoutPage.openCustomerInfoPage();

		log.info("TC_06 - Step 36: Open Order page");
		orderPage = customerInfoPage.openOrderPage();

		log.info("TC_06 - Step 37: Verify total price displayed");
		verifyEquals(orderPage.totalPriceProductCheckout(), totalPrice);

	}

	@Test
	public void TC_07_ReOrder() {
		log.info("TC_07 - Step 01: Click to 'detail' order button");
		orderPage.clickToButtonByText(driver, "Details");

		log.info("TC_07 - Step 02: Click to 'Re-order'  button");
		orderPage.clickToButtonByText(driver, "Re-order");

		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);

		log.info("TC_07 - Step 03: Edit Qty product ");
		shoppingCartPage.inputToQtyTextbox("10");

		log.info("TC_07 - Step 04: Click To Update shopping cart button");
		shoppingCartPage.clickToButtonByText(driver, "Update shopping cart");

		log.info("TC_07 - Step 04: Click To checkbox 'I agree with the terms .. ' ");
		shoppingCartPage.checkToTermsOfServiceCheckbox();

		log.info("TC_07 - Step 05: Click To checkout button");
		shoppingCartPage.clickToCheckOutButton();

		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);

		log.info("TC_07 - Step 06: Click to  Continue button");
		checkoutPage.clickToButtonByText(driver, "Continue");

		log.info("TC_07 - Step 07: select shipping method checkbox");
		checkoutPage.clickToCheckboxByLabel(driver, "2nd Day Air ($0.00)");

		log.info("TC_07 - Step 08: Click to  Continue button at shipping method");
		checkoutPage.clickToButtonContinueByID("shipping-method-buttons-container");

		log.info("TC_07 - Step 09: Click to  Continue button at payment method");
		checkoutPage.clickToButtonContinueByID("payment-method-buttons-container");

		log.info("TC_07 - Step 10: Verify Payment info displayed");
		verifyTrue(checkoutPage.isPaymentInfoDisplayed("New York, NY 10001"));

		log.info("TC_07 - Step 11: Click to  Continue button at payment Info");
		checkoutPage.clickToButtonContinueByID("payment-info-buttons-container");

		log.info("TC_07 - Step 13: Verify Billing address displayed");
		verifyTrue(checkoutPage.isBillingAddressDisplayed(emailAddress));
		verifyTrue(checkoutPage.isBillingAddressDisplayed(address1));

		verifyEquals(checkoutPage.totalPriceProductCheckout(), "$18,000.00");

		log.info("TC_07 - Step 14: Click To Confirm Button");
		checkoutPage.clickToButtonContinueByID("confirm-order-buttons-container");

		log.info("TC_07 - Step 15: Verify Order successful message displayed");
		verifyEquals(checkoutPage.orderSuccessMessageDisplayed(), "Your order has been successfully processed!");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserDataMapper userData;

	String processor, ram, hdd, os, software1, software2, editProcessor, editRam, editHDD, editOS, editSoftware, editQuantity, firstName, lastName, emailAddress, country, province, city, address1, address2, zip, phoneNumber, faxNumber,
			totalPrice, cardHolderName, cardNumber, cardCode;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserProductDetailPageObject productDetailPage;
	private UserCategoryPageObject categogyPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserCheckoutPageObject checkoutPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrderPageObject orderPage;

}