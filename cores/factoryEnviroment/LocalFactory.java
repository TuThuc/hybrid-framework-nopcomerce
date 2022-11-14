package factoryEnviroment;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver creatDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.dowload.dir", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
			options.addPreference("browser.dowload.userDownloadDir", true);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip, application/zip, application/x-zip-compressed, application/msword, "
					+ "application/csv,text/csv,image/png,image/jpeg, application/pdf, text/html, text/plain, application/excel," + "application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
			options.addPreference("pdfjs.disabled", true);
			options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
			options.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(options);
		} else if (browserList == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			// Brower Options: selenium 3.xx
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size = 1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();

			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting.popups", 0);
			prefs.put("dowload.default_directory", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			options.setExperimentalOption("prefs", prefs);
			options.setAcceptInsecureCerts(true);
			options.addArguments("--lang=vi");
			driver = new ChromeDriver(options);
		} else if (browserList == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size = 1920x1080");
			driver = new ChromeDriver(options);

		} else if (browserList == BrowserList.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserList == BrowserList.EDGE_LEGACY) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserList == BrowserList.IE) {
			WebDriverManager.iedriver().arch32().setup();

			driver = new InternetExplorerDriver();

		} else if (browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("100.0.4896.60").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\Admin\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else if (browserList == BrowserList.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Brower name invalid");
		}
		return driver;
	}
}
