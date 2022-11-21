package factoryBrower;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		Map<String, Object> chromaePrefs = new HashMap<String, Object>();
		chromaePrefs.put("profile.default_content_setting.popups", 0);
		chromaePrefs.put("dowload.default_directory", GlobalConstants.DOWNLOAD_FILE);
		options.setExperimentalOption("prefs", chromaePrefs);
		chromaePrefs.put("credentials_enable_service", false);
		chromaePrefs.put("profile.password_manager_enabled", false);
		options.setAcceptInsecureCerts(true);
		options.addArguments("--lang=vi");
		return new ChromeDriver(options);
	}

}
