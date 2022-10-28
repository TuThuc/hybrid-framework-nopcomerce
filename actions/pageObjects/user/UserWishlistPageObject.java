package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage {
	WebDriver driver;

	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDisplayedAtWishlist(String productName) {
		waitForElementVisible(driver, UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayedInDOM(driver, UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public void clickToWishlistURL() {
		waitForElementClickable(driver, UserWishlistPageUI.WISHLIST_URL_SHARING);
		clickToElement(driver, UserWishlistPageUI.WISHLIST_URL_SHARING);
	}

	public void clickToCheckboxAddToCart() {
		waitForElementClickable(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX_BY_LABEL);
		checkToDefaultCheckboxRadio(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX_BY_LABEL);

	}

	public boolean isProductUnDisplayedAtWishlistPage(String productName) {
		waitForElementInvisibleNotInDOM(driver, UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementUnDisplayed(driver, UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public void clickToRomoveButton() {
		waitForElementClickable(driver, UserWishlistPageUI.REMOVE_BUTTON);
		clickToElement(driver, UserWishlistPageUI.REMOVE_BUTTON);

	}

	public Object getMessageWishlistEmpty() {
		waitForElementVisible(driver, UserWishlistPageUI.EMPTY_DATA_MESSAGE);
		return getElementText(driver, UserWishlistPageUI.EMPTY_DATA_MESSAGE);
	}

}
