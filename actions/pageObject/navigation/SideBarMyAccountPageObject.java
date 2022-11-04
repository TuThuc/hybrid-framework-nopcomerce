package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserMyProductReviewPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRewardPointPageObject;
import pageUIs.navigation.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {
	WebDriver driver;

	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Tối ưu ở bài học Level_07_Switch_Page
	public UserAddressPageObject openAddressPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.ADDRESS_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserCustomerInfoPageObject openCustomerInforPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR__LINK);
		clickToElement(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR__LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public UserMyProductReviewPageObject openMyProductReviewPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.REWARD_POINTS_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserOrderPageObject openOrderPage() {
		waitForElementVisible(driver, SideBarMyAccountPageUI.ORDER__LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ORDER__LINK);
		return PageGeneratorManager.getUserOrderPage(driver);
	}

}
