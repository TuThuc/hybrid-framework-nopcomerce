package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
public  LoginPageObject(WebDriver driver) {
	this.driver = driver;
}
public void clickToLoginButton() {
	waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	
}
public String getErrorMessageAtEmailTextbox() {
	waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
}
public void inputToEmailTextbox(String emailAdress) {
	waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAdress);
	
}
public void inputToPasswordTextbox(String password) {
	waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	
}
public String getErrorMessageLoginUnsuccess() {
	waitForElementVisible(driver, LoginPageUI.ERROR_LOGIN_UNSUCCESS);
	return getElementText(driver, LoginPageUI.ERROR_LOGIN_UNSUCCESS);
}
public String getTextWellcomeHomePage() {
	waitForElementVisible(driver, HomePageUI.WELLCOME_TEXT_HOMEPAGE);
	return getElementText(driver, HomePageUI.WELLCOME_TEXT_HOMEPAGE);
}
}
