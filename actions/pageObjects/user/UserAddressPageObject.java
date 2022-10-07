package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserAddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueAddressByText(WebDriver driver, String textValue) {
		waitForElementVisible(driver, UserAddressPageUI.DYNAMIC_ADDRESS_LIST_BY_TEXT, textValue);
		return getElementAttribute(driver, UserAddressPageUI.DYNAMIC_ADDRESS_LIST_BY_TEXT, "textContent", textValue);

	}

	public boolean isValueAddressDisplayed(WebDriver driver, String textValue) {
		waitForElementVisible(driver, UserAddressPageUI.DYNAMIC_ADDRESS_LIST_BY_CONTAINS_TEXT, textValue);
		return isElementDisplayed(driver, UserAddressPageUI.DYNAMIC_ADDRESS_LIST_BY_CONTAINS_TEXT, textValue);
	}

}
