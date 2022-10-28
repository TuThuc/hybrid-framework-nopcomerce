package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDisplayedAtShoppingCartPage(String productName) {
		waitForElementVisible(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayedInDOM(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public UserProductDetailPageObject clickToEditButton() {
		waitForElementClickable(driver, UserShoppingCartPageUI.EDIT_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_BUTTON);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isEditProductInforDislayedAtShoppingCart(String editInfoProduct) {
		waitForElementVisible(driver, UserShoppingCartPageUI.INFO_PRODUCT, editInfoProduct);
		return isElementDisplayedInDOM(driver, UserShoppingCartPageUI.INFO_PRODUCT, editInfoProduct);
	}

	public Object getTotalPriceProduct() {
		waitForElementVisible(driver, UserShoppingCartPageUI.TOTAL_PRICE_PRODUCT);
		return getElementText(driver, UserShoppingCartPageUI.TOTAL_PRICE_PRODUCT);
	}

	public void clickToRemoveButton() {
		waitForElementClickable(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
	}

	public Object getMessageShoppingCartEmpty() {
		waitForElementVisible(driver, UserShoppingCartPageUI.EMPTY_DATA_MESSAGE);
		return getElementText(driver, UserShoppingCartPageUI.EMPTY_DATA_MESSAGE);
	}

	public boolean isProductUndisplayedAtShoppingCartPage(String productName) {
		waitForElementInvisibleNotInDOM(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementUnDisplayed(driver, UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public void inputToQtyTextbox(String qtyEdit) {
		waitForElementVisible(driver, UserShoppingCartPageUI.QTY_TEXTBOX);
		sendkeyToElement(driver, UserShoppingCartPageUI.QTY_TEXTBOX, qtyEdit);

	}

	public void checkToTermsOfServiceCheckbox() {
		waitForElementVisible(driver, UserShoppingCartPageUI.TERMS_OF_SERVICE_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, UserShoppingCartPageUI.TERMS_OF_SERVICE_CHECKBOX);

	}
}
