package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageObject.navigation.SideBarMyAccountPageObject;
import pageUIs.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
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

	public UserHomePageObject clickToLogoutLink() {
		waitForElementVisible(driver, UserChangePasswordPageUI.LOGOUT_LINK);
		clickToElement(driver, UserChangePasswordPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);

	}
}
