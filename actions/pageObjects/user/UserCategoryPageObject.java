package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageObject.navigation.HeaderLinkPageObject;
import pageUIs.user.BasePageNopComerceUI;
import pageUIs.user.UserCategoryPageUI;
import pageUIs.user.UserHomePageUI;

public class UserCategoryPageObject extends HeaderLinkPageObject {
	WebDriver driver;

	public UserCategoryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isListProductNameSortByAscending() {
		waitForElementInvisibleInDOM(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT);
		return isProductNameSortByAscending(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT);
	}

	public boolean isListProductNameSortByDescending() {
		waitForElementInvisibleInDOM(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT);
		return isProductNameSortByDescending(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT);
	}

	public boolean isListProductPriceSortByAscending() {
		waitForElementInvisibleInDOM(driver, UserCategoryPageUI.LIST_PRODUCT_PRICE_TEXT);
		return isProductPriceSortByAscending(driver, UserCategoryPageUI.LIST_PRODUCT_PRICE_TEXT);
	}

	public boolean isListProductPriceSortByDescending() {
		waitForElementInvisibleInDOM(driver, UserCategoryPageUI.LIST_PRODUCT_PRICE_TEXT);
		return isProductPriceSortByDescending(driver, UserCategoryPageUI.LIST_PRODUCT_PRICE_TEXT);
	}

	public boolean isPagePagingDisplayedByText(String textPaging) {
		waitForElementVisible(driver, UserCategoryPageUI.DYNAMIC_PAGE_PAGING_BY_TEXT, textPaging);
		return isElementDisplayedInDOM(driver, UserCategoryPageUI.DYNAMIC_PAGE_PAGING_BY_TEXT, textPaging);
	}

	public void clickToPageNumbePagingrByText(String textPaging) {
		waitForElementVisible(driver, UserCategoryPageUI.DYNAMIC_PAGE_PAGING_BY_TEXT, textPaging);
		clickToElement(driver, UserCategoryPageUI.DYNAMIC_PAGE_PAGING_BY_TEXT, textPaging);
	}

	public boolean isProductListDisplayedByPageSizeReloadPage(int numberPage) {
		waitForElementInvisibleInDOM(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT);
		return isDataDisplayedByPageSize(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT, numberPage);
	}

	public boolean isProductListDisplayedByPageSizeNotReloadPage(int numberPage) {
		waitForAllElementVisible(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT);
		return isDataDisplayedByPageSize(driver, UserCategoryPageUI.LIST_PRODUCT_NAME_TEXT, numberPage);
	}

	public boolean isPagePagingUndisplayed() {
		isElementUnDisplayed(driver, UserCategoryPageUI.PAGE_PAGING);
		return isElementUnDisplayed(driver, UserCategoryPageUI.PAGE_PAGING);
	}

	public UserProductDetailPageObject clickToProductByProductName(String productName) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_PRODUCT_TITLE_BY_TEXT, productName);
		clickToElement(driver, BasePageNopComerceUI.DYNAMIC_PRODUCT_TITLE_BY_TEXT, productName);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public void clickToAddToCartByProductName(String productName) {
		waitForElementClickable(driver, UserCategoryPageUI.ADD_TO_CART_BUTTON, productName);
		clickToElement(driver, UserCategoryPageUI.ADD_TO_CART_BUTTON, productName);
	}

	public Object getAddToCartSuccessMessage() {
		waitForElementVisible(driver, UserCategoryPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
		return getElementText(driver, UserCategoryPageUI.ADD_TO_CART_SUCCESS_MESSAGE);
	}

	public void clickToCloseButton() {
		waitForElementVisible(driver, UserHomePageUI.CLOSE_BUTTON);
		clickToElement(driver, UserHomePageUI.CLOSE_BUTTON);
	}

}
