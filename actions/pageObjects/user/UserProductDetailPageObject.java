package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductReviewPageObject clickToAddYourReview() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}

}
