package factoryBrower;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.BROWSER_LOG);
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.dowload.dir", GlobalConstants.DOWNLOAD_FILE);
		options.addPreference("browser.dowload.userDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip, application/zip, application/x-zip-compressed, application/msword, "
				+ "application/csv,text/csv,image/png,image/jpeg, application/pdf, text/html, text/plain, application/excel," + "application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
		options.addPreference("pdfjs.disabled", true);
		
		options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
		options.setAcceptInsecureCerts(true);
		return new FirefoxDriver(options);
		
	}

}
