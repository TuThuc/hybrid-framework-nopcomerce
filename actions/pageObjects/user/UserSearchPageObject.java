package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getSearchErrorMessage() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.SEARCH_ERROR_MESSAGE);
	}

	public void clickToButtonSearch() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public int getNumberListProducByProductTitle() {
		waitForAllElementVisible(driver, UserSearchPageUI.LIST_PRODUCT_BY_PRODUCT_TITLE);
		return getElementSize(driver, UserSearchPageUI.LIST_PRODUCT_BY_PRODUCT_TITLE);
	}

	public boolean isListProductNameDisplayed(WebDriver driver, String productName) {
		waitForAllElementVisible(driver, UserSearchPageUI.LIST_PRODUCT_BY_PRODUCT_NAME, productName);
		return isListElementContainText(driver, UserSearchPageUI.LIST_PRODUCT_BY_PRODUCT_NAME, productName, productName);
	}

}
