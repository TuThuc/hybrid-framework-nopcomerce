package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {

		this.driver = driver;
	}
}
