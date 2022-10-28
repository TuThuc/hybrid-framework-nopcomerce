package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SideBarMyAccountPageObject;
import pageUIs.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getValueReviewTitle(WebDriver driver, String textTitle) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT, textTitle);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT, textTitle);
	}

	public Object getValueReviewText(String reviewText) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT, reviewText);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TEXT, reviewText);
	}
}
