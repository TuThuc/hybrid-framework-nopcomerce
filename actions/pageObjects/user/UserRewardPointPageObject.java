package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;

public class UserRewardPointPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public UserRewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
