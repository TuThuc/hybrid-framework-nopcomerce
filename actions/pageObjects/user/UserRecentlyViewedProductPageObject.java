package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserRecentlyViewedProductPageUI;

public class UserRecentlyViewedProductPageObject extends BasePage {
	WebDriver driver;

	public UserRecentlyViewedProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object getNumberRecentlyViewedProductDisplayed() {
		waitForAllElementVisible(driver, UserRecentlyViewedProductPageUI.LIST_PRODUCT_NAME);
		return getElementSize(driver, UserRecentlyViewedProductPageUI.LIST_PRODUCT_NAME);
	}

	public boolean isRecentlyViewedProductDisplayedByProductName(String productName) {
		waitForElementVisible(driver, UserRecentlyViewedProductPageUI.PRODUCT_NAME, productName);
		return isElementDisplayedInDOM(driver, UserRecentlyViewedProductPageUI.PRODUCT_NAME, productName);
	}

}
