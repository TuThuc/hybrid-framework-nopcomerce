package pageObjects.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.BasePageNopComerceUI;
import pageUIs.user.UserHomePageUI;
import utlities.SQLJTDSConnection;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to Register page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		// 2
		// return new RegisterPageObject(driver);
		// 3
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	@Step("Navigate to Login page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);

		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayedInDOM(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public UserCustomerInfoPageObject openCustomerInforPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);

		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public int getEmployeeListNumberUI() {
		// TODO Auto-generated method stub
		return 18;
	}

	public int getEmployeeListNumberInBD() throws SQLException {
		ArrayList<String> listNumber = new ArrayList<>();
		String sql = "Select * From [automationfc].[dbo].[EMPLOYEE]";
		Connection conn = null;
		try {
			conn = SQLJTDSConnection.getSQLServerConnection();
			System.out.println("Opened connection: " + conn);
			Statement statement = conn.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết qua trả về
			while (rs.next()) {
				listNumber.add(rs.getString("EMP_ID"));
			}
			System.out.println("sum:" + listNumber.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return listNumber.size();
	}

	public UserProductDetailPageObject clickToProductTitle(WebDriver driver, String productTitle) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_PRODUCT_TITLE_BY_TEXT, productTitle);
		clickToElement(driver, BasePageNopComerceUI.DYNAMIC_PRODUCT_TITLE_BY_TEXT, productTitle);
		return PageGeneratorManager.getProductDetailPage(driver);

	}

	public UserCategoryPageObject clickToSubmenuAtHeaderMenuByText(WebDriver driver, String valueMenuHeader, String valueSubMenuHeader) {
		waitForElementVisible(driver, BasePageNopComerceUI.DYNAMIC_TOP_MENU_HEADER_BY_TEXT, valueMenuHeader);
		hoverMouseToElement(driver, BasePageNopComerceUI.DYNAMIC_TOP_MENU_HEADER_BY_TEXT, valueMenuHeader);

		waitForElementVisible(driver, BasePageNopComerceUI.DYNAMIC_TOP_MENU_HEADER_BY_TEXT, valueSubMenuHeader);
		doubleClickToElement(driver, BasePageNopComerceUI.DYNAMIC_TOP_MENU_HEADER_BY_TEXT, valueSubMenuHeader);
		return PageGeneratorManager.getUserCategoryPage(driver);
	}

	public void AddProductToCompareListByProductName(WebDriver driver, String productName) {
		waitForElementVisible(driver, UserHomePageUI.ADD_TO_COMPARE_BY_PRODUCT_NAME, productName);
		clickToElement(driver, UserHomePageUI.ADD_TO_COMPARE_BY_PRODUCT_NAME, productName);

	}

	public Object getAddToCompareSuccessMessage() {
		waitForElementVisible(driver, UserHomePageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
		return getElementText(driver, UserHomePageUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
	}

	public void clickToCloseButton() {
		waitForElementVisible(driver, UserHomePageUI.CLOSE_BUTTON);
		clickToElement(driver, UserHomePageUI.CLOSE_BUTTON);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

}
