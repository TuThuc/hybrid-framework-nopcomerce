package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserShoppingCartPageObject;
import pageObjects.user.UserWishlistPageObject;
import pageUIs.navigation.HeaderLinkPageUI;

public class HeaderLinkPageObject extends BasePage {
	WebDriver driver;

	public HeaderLinkPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject openRegisterPage() {
		waitForElementVisible(driver, HeaderLinkPageUI.REGISTER_LINK);
		clickToElement(driver, HeaderLinkPageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject openLoginPage() {
		waitForElementVisible(driver, HeaderLinkPageUI.LOGIN_LINK);
		clickToElement(driver, HeaderLinkPageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserWishlistPageObject openWishlistPage() {
		waitForElementVisible(driver, HeaderLinkPageUI.WISHLIST_LINK);
		clickToElement(driver, HeaderLinkPageUI.WISHLIST_LINK);
		return PageGeneratorManager.getUserWhistlistPage(driver);
	}

	public UserShoppingCartPageObject openShoppingCartPage() {
		waitForElementVisible(driver, HeaderLinkPageUI.SHOPPING_CART_LINK);
		clickToElement(driver, HeaderLinkPageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public UserCustomerInfoPageObject openCustomerInfoPage() {
		waitForElementVisible(driver, HeaderLinkPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HeaderLinkPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public UserHomePageObject openHomePage() {
		waitForElementVisible(driver, HeaderLinkPageUI.LOG_OUT_LINK);
		clickToElement(driver, HeaderLinkPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
