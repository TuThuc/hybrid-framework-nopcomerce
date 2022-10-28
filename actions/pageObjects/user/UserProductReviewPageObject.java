package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRadioRating() {
		waitForElementClickable(driver, UserProductReviewPageUI.RADIO_BUTTON_RATING);
		clickToElement(driver, UserProductReviewPageUI.RADIO_BUTTON_RATING);
	}

	public String getProductReviewSuccessMessage() {
		waitForElementVisible(driver, UserProductReviewPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
		return getElementText(driver, UserProductReviewPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
	}

	public void inputToReviewTextTextbox(String textValue) {
		waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXT_TEXTBOX, textValue);

	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);

	}

}
