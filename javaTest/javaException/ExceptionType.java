package javaException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExceptionType {
		WebDriver driver;
		String emailAdress;
		String projectPath = System.getProperty("user.dir");

		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://demo.nopcommerce.com/");
		}
		@Test 
		public void TC_Exception(){
			driver.findElement(By.xpath("/a[text()='Registers']")).click();
		}
	}
