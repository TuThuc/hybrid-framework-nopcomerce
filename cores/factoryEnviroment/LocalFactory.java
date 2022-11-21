package factoryEnviroment;

import org.openqa.selenium.WebDriver;

import factoryBrower.BrowserList;
import factoryBrower.BrowserNotSupportedException;
import factoryBrower.ChromeDriverManager;
import factoryBrower.EdgeDriverManager;
import factoryBrower.FirefoxDriverManager;
import factoryBrower.HeadlessChromeDriverManager;
import factoryBrower.HeadlessFirefoxDriverManager;
import factoryBrower.IEDriverManager;
import factoryBrower.SafariDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver creatDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case H_CHROME:
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
		case H_FIREFOX:
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;
		case EDGE_CHROMIUM:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case IE:
			driver = new IEDriverManager().getBrowserDriver();
			break;

		default:
			throw new BrowserNotSupportedException(browserName);
		}
		
		return driver;
	}
}
