package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueReviewTitle(WebDriver driver, String textTitle) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT, textTitle);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT, textTitle);
	}

	public Object getValueReviewText(WebDriver driver2, String reviewText) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT, reviewText);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TEXT, reviewText);
	}
}
