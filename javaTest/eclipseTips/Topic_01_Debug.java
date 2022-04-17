package eclipseTips;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Topic_01_Debug {
	WebDriver driver;
	
	
		
	
@Test
		public void TC_01() {
	
	System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("https://www.facebook.com/");
	String headerText = driver.findElement(By.xpath("//img[@alt='Facebook']/parent::div/following-sibling::h2")).getText();
	Assert.assertEquals(headerText, "Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn.");
	boolean logiStatus = driver.findElement(By.name("login")).isDisplayed();
	Assert.assertTrue(logiStatus);
}
}
	
