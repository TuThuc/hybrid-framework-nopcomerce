package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageObject.navigation.HeaderLinkPageObject;
import pageUIs.navigation.HeaderLinkPageUI;
import pageUIs.user.UserProductDetailPageUI;

public class UserProductDetailPageObject extends HeaderLinkPageObject {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserProductReviewPageObject clickToAddYourReview() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}

	public void clickToAddToWishlist() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, UserProductDetailPageUI.CLOSE_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.CLOSE_BUTTON);
	}

	public String getPageSuccessNotification() {
		waitForElementVisible(driver, UserProductDetailPageUI.PAGE_SUCCESS_NOTIFICATION);
		return getElementText(driver, UserProductDetailPageUI.PAGE_SUCCESS_NOTIFICATION);

	}

	public void moveToShoppingCartLink() {
		waitForElementVisible(driver, HeaderLinkPageUI.SHOPPING_CART_LINK);
		hoverMouseToElement(driver, HeaderLinkPageUI.SHOPPING_CART_LINK);
	}

	public Object getProductMessageAtMiniShoppingCart() {
		waitForElementVisible(driver, UserProductDetailPageUI.QUANTITY_PRODUCT_MESSAGE);
		return getElementText(driver, UserProductDetailPageUI.QUANTITY_PRODUCT_MESSAGE);

	}

	public boolean isProductInforDislayedAtMiniShoppingCart(String infoProduct) {
		waitForElementVisible(driver, UserProductDetailPageUI.INFO_PRODUCT_AT_MINI_SHOPPING_CART, infoProduct);
		return isElementDisplayedInDOM(driver, UserProductDetailPageUI.INFO_PRODUCT_AT_MINI_SHOPPING_CART, infoProduct);
	}

	public Object getUnitPriceProductDisplayed() {
		waitForElementVisible(driver, UserProductDetailPageUI.UNIT_PRICE_PRODUCT);
		return getElementText(driver, UserProductDetailPageUI.UNIT_PRICE_PRODUCT);
	}

	public Object getQuantityProductDisplayed() {
		waitForElementVisible(driver, UserProductDetailPageUI.QUANTITY_PRODUCT);
		return getElementText(driver, UserProductDetailPageUI.QUANTITY_PRODUCT);
	}

	public Object getSubTotalPriceProductDisplayed() {
		waitForElementVisible(driver, UserProductDetailPageUI.SUB_TOTAL_PRICE_PRODUCT);
		return getElementText(driver, UserProductDetailPageUI.SUB_TOTAL_PRICE_PRODUCT);
	}

	public Object getPriceProductAfterEditInfo() throws InterruptedException {
		Thread.sleep(5000);
		waitForElementVisible(driver, UserProductDetailPageUI.PRICE_PRODUCT_AFTER_EDIT);
		return getElementText(driver, UserProductDetailPageUI.PRICE_PRODUCT_AFTER_EDIT);
	}

}
