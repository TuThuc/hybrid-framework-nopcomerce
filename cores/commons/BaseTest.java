package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	protected WebDriver getBrowerDriver(String browserName) {
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Brower name invalid");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
}
