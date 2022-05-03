package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
private WebDriver driver;
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		

	}

	public String getErrorMessageAtFirstnameTextbox() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getErrorMessageAtLastnameTextbox() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getErrorMessageAtEmailTextbox() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getErrorMessageAtPasswordTextbox() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inputToFirstnameTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void inputToLastnameTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void inputToEmailTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void inputToPasswordTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void inputToConfirmPasswordTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToLogoutLink() {
		// TODO Auto-generated method stub

	}

	public String getErrorExistingEmailMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
