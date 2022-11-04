package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.HeaderLinkPageObject;
import pageUIs.user.UserCheckoutPageUI;

public class UserCheckoutPageObject extends HeaderLinkPageObject {
	WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isPaymentInfoDisplayed(String valuePaymentInfo) {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_INFO_BY_TEXT, valuePaymentInfo);
		return isElementDisplayedInDOM(driver, UserCheckoutPageUI.PAYMENT_INFO_BY_TEXT, valuePaymentInfo);
	}

	public boolean isBillingAddressDisplayed(String billingInfoText) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_INFO_BY_TEXT, billingInfoText);
		return isElementDisplayedInDOM(driver, UserCheckoutPageUI.BILLING_INFO_BY_TEXT, billingInfoText);
	}

	public void clickToButtonContinueByID(String idButton) {
		waitForElementVisible(driver, UserCheckoutPageUI.CONTINUE_BUTTON_BY_ID, idButton);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_BY_ID, idButton);

	}

	public boolean isShippingAddressDisplayed(String shippingAddressText) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_BY_TEXT, shippingAddressText);
		return isElementDisplayedInDOM(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_BY_TEXT, shippingAddressText);
	}

	public Object totalPriceProductCheckout() {
		waitForElementVisible(driver, UserCheckoutPageUI.TOTAL_PRICE_PRODUCT);
		return getElementText(driver, UserCheckoutPageUI.TOTAL_PRICE_PRODUCT);
	}

	public Object orderSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
		return getElementText(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
	}

	public boolean isOrderNumberDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return isElementDisplayedInDOM(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}

	public Object getPaymentMedthodDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_METHOD);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_METHOD);
	}

}
