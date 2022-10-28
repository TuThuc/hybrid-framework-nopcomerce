package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;
import pageUIs.user.UserCustomerInforPageUI;

public class UserCustomerInfoPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayedInDOM(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

}
