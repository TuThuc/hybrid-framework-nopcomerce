package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.HeaderLinkPageObject;
import pageUIs.user.UserOrderPageUI;

public class UserOrderPageObject extends HeaderLinkPageObject {
	WebDriver driver;

	public UserOrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public Object totalPriceProductCheckout() {
		waitForElementVisible(driver, UserOrderPageUI.TOTAL_PRICE_ORDER);
		return getElementText(driver, UserOrderPageUI.TOTAL_PRICE_ORDER);
	}

}
