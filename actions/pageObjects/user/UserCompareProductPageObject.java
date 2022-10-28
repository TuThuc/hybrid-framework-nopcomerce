package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserCompareProductPageUI;

public class UserCompareProductPageObject extends BasePage {
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductUnDisplayedAtCompareProductPage(String productName) {
		waitForElementInvisibleNotInDOM(driver, UserCompareProductPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return isElementUnDisplayed(driver, UserCompareProductPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public Object getProductNameByText(String productName) {
		waitForElementVisible(driver, UserCompareProductPageUI.PRODUCT_NAME_BY_TEXT, productName);
		return getElementText(driver, UserCompareProductPageUI.PRODUCT_NAME_BY_TEXT, productName);
	}

	public Object getProductPriceByText(String productPrice) {
		waitForElementVisible(driver, UserCompareProductPageUI.PRODUCT_PRICE_BY_TEXT, productPrice);
		return getElementText(driver, UserCompareProductPageUI.PRODUCT_PRICE_BY_TEXT, productPrice);
	}

	public Object getMessageCompareProductEmpty() {
		waitForElementVisible(driver, UserCompareProductPageUI.COMPARE_PRODUCT_EMPTY_MESSAGE);
		return getElementText(driver, UserCompareProductPageUI.COMPARE_PRODUCT_EMPTY_MESSAGE);
	}

	public void clickToClearListButton() {
		waitForElementVisible(driver, UserCompareProductPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductPageUI.CLEAR_LIST_BUTTON);

	}

}
