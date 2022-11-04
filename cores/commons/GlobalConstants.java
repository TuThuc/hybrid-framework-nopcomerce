package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5 " + File.separator;
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT" + File.separator;
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;

	public static final String BROWSER_USERNAME = "tuthuc1";
	public static final String BROWSER_AUTOMATE_KEY = "b6H118BpMUuq4mqJAGPo";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static final String SAUCE_USERNAME = "oauth-tuthuc176216-91dbe";
	public static final String SAUCE_AUTOMATE_KEY = "bc18b83f-ee05-4afd-b38e-1ab69390a95c";
	public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

	public static final String BITBAR_AUTOMATE_KEY = "ZS3i8gl3teNETEe9IxPP1BYxx4maizOf";
	public static final String BITBAR_URL = "https://appium.bitbar.com/wd/hub";

}
