package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	private WebElement registerLink;
}
