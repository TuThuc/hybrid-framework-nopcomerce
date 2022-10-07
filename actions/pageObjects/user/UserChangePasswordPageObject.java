package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getNotifyChangePasswordSuccess() {
		waitForElementVisible(driver, UserChangePasswordPageUI.NOTIFY_CHANGE_PASSWORD_SUCCESS);
		return getElementText(driver, UserChangePasswordPageUI.NOTIFY_CHANGE_PASSWORD_SUCCESS);

	}

	public void clickToCloseAtNotify() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CLOSE_NOTIFY);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_NOTIFY);

	}
}
