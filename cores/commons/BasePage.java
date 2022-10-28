package commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.UserHomePO;
import pageUIs.jQuery.uploadFile.BasePageJQueryUI;
import pageUIs.user.BasePageNopComerceUI;

//Common class
/**
 * @author Admin
 *
 */
public class BasePage {
	WebDriver driver;

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	// Nhiệm vụ mở 1 URL bất kỳ
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String expectedID) {
		Set<String> allTabIDs = driver.getWindowHandles();

		for (String id : allTabIDs) {

			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {

		Set<String> allTabIDs = driver.getWindowHandles();

		for (String id : allTabIDs) {

			driver.switchTo().window(id);

			String actualTitle = driver.getTitle();

			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);

		}

	}
	// Locator type: id=/ css=/ class=/ name=/ xpath=
	// Locator type: Id=/ Css=/ class=/ Name=/ Xpath=
	// Locator type: ID=/ CSS=/ class=/ NAME=/ XPATH=

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not support");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		// System.out.println("Locator Type before" + locatorType);
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		// System.out.println("Value map before" + dynamicValues);
		// System.out.println("Locator Type after" + locatorType);
		return locatorType;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public void clearValueInToElementByDeleteKey(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdownList(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		// Step 1: Click vao element cho nó xổ hết ra
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		List<WebElement> allitems = new WebDriverWait(driver, longTimeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childXpath)));
		for (WebElement item : allitems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectItemDefautDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locatorType) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		// Nếu như mình gán = 5 apply cho tất cả các step về sau: findElement/
		// findElements
		overrideImplicitTimeout(driver, longTimeout);

		if (elements.size() == 0) {

			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {

			return true;
		} else {

			return false;
		}
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		overrideImplicitTimeout(driver, longTimeout);

		if (elements.size() == 0) {

			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {

			return true;
		} else {

			return false;
		}
	}

	public boolean isListElementContainText(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		boolean state = true;
		for (WebElement element : elements) {
			if (!element.getText().contains(textValue)) {
				state = false;
				break;
			}
		}
		return state;

	}

	public void overrideImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementDisplayedInDOM(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}

	public boolean isElementDisplayedInDOM(WebDriver driver, String locatorType, String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();

	}

	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locatorType)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void highlightElement(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public String getElementValueByJSXpath(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return (String) jsExecutor.executeScript("return $document.evaluete(\"" + xpathLocator + "\", document, null, XpathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;

	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInvisibleInDOM(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementInvisibleInDOM(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementInvisibleInDOM(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, locatorType)));
	}

	public void waitForAllElementInvisibleInDOM(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}

	/*
	 * Wait for element undisplayed in DOM or not in DOM and override implicit timeout
	 */
	public void waitForElementInvisibleNotInDOM(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, longTimeout);
	}

	public void waitForElementInvisibleNotInDOM(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		overrideImplicitTimeout(driver, longTimeout);
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementPresense(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileName) {
		String filePath = GlobalConstants.UPLOAD_FILE;
		// Đường dẫn của tất cả các file
		// 1 file: test.png
		// nhiều file String[] fileNames = {"test.png", "test1.png"}
		String fullFileName = "";
		for (String file : fileName) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public boolean isProductNameSortByAscending(WebDriver driver, String locatorType, String... dynamicValues) {
		ArrayList<String> productUIList = new ArrayList<String>();
		List<WebElement> productNameTexts = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));

		for (WebElement productName : productNameTexts) {
			productUIList.add(productName.getText());
		}
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending(WebDriver driver, String locatorType, String... dynamicValues) {
		ArrayList<String> productUIList = new ArrayList<String>();
		List<WebElement> productNameTexts = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		for (WebElement productName : productNameTexts) {
			productUIList.add(productName.getText());
		}
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		Collections.reverse(productSortList);
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending(WebDriver driver, String locatorType) {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		List<WebElement> priceProducts = getListWebElement(driver, locatorType);
		for (WebElement priceProduct : priceProducts) {

			productUIList.add(Float.parseFloat(priceProduct.getText().replace("$", "").replace(",", "")));
		}
		ArrayList<Float> productPriceSortLists = new ArrayList<Float>();
		for (Float priceSortProduct : productUIList) {
			productPriceSortLists.add(priceSortProduct);
		}
		Collections.sort(productPriceSortLists);
		return productPriceSortLists.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending(WebDriver driver, String locatorType) {

		ArrayList<Float> productUIList = new ArrayList<Float>();
		List<WebElement> priceProducts = getListWebElement(driver, locatorType);
		for (WebElement priceProduct : priceProducts) {
			productUIList.add(Float.parseFloat(priceProduct.getText().replace("$", "").replace(",", "")));
		}
		ArrayList<Float> productPriceSortLists = new ArrayList<Float>();
		for (Float priceSortProduct : productUIList) {
			productPriceSortLists.add(priceSortProduct);
		}
		Collections.sort(productPriceSortLists);
		Collections.reverse(productPriceSortLists);
		return productPriceSortLists.equals(productUIList);
	}

	public boolean isProductNumberSortByAscending(WebDriver driver, String locatorType) {
		ArrayList<Integer> productUIList = new ArrayList<Integer>();
		List<WebElement> numberProducts = getListWebElement(driver, locatorType);
		for (WebElement numberProduct : numberProducts) {
			productUIList.add(Integer.parseInt(numberProduct.getText()));
		}
		ArrayList<Integer> numberProductSortLists = new ArrayList<Integer>();
		for (Integer numberSortProduct : productUIList) {
			numberProductSortLists.add(numberSortProduct);
		}
		Collections.sort(numberProductSortLists);
		return numberProductSortLists.equals(productUIList);
	}

	public boolean isDataDateSortedByAscending(WebDriver driver, String locatorType) {
		ArrayList<Date> arrayListUI = new ArrayList<Date>();
		List<WebElement> elementList = getListWebElement(driver, locatorType);
		for (WebElement element : elementList) {
			arrayListUI.add(convertStringToDate(element.getText()));
		}
		ArrayList<Date> arraySortedList = new ArrayList<Date>();
		for (Date sortedList : arrayListUI) {
			arraySortedList.add(sortedList);
		}
		Collections.sort(arraySortedList);
		return arraySortedList.equals(arrayListUI);
	}

	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public boolean isDataDisplayedByPageSize(WebDriver driver, String locatorType, int pageSize, String... dynamicValues) {
		int elementSize = getElementSize(driver, getDynamicXpath(locatorType, dynamicValues));
		boolean status = true;
		if (elementSize <= pageSize) {
			status = true;
		} else {
			status = false;
		}

		return status;

	}

	// Tối ưu ở bài học Level_09_Dynamic_Locator
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopComerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getMyProductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		default:
			throw new RuntimeException("Invalid Page Name at My Account area");

		}

	}

	// Pattern Object
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopComerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}

	/**
	 * Enter to dynamic Textbox by ID
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, BasePageNopComerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageNopComerceUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);

	}

	/**
	 * Click to dynamic Button by text
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageNopComerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);

	}

	/**
	 * Click to dynamic header links by class Name
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param className
	 */
	public void clickToHeaderLinksByText(WebDriver driver, String textValue) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_HEADER_LINK_BY_TEXT, textValue);
		clickToElement(driver, BasePageNopComerceUI.DYNAMIC_HEADER_LINK_BY_TEXT, textValue);

	}

	/**
	 * Click to dynamic footer links by Text
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param textValue
	 */
	public void clickToFooterLinksByText(WebDriver driver, String textLink) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_FOOTER_LINK_BY_TEXT, textLink);
		clickToElement(driver, BasePageNopComerceUI.DYNAMIC_FOOTER_LINK_BY_TEXT, textLink);

	}

	/**
	 * Select item in Dropdown by name attribute
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param dropdownAttributeName
	 * @param itemValue
	 */

	public void selectToDropdownByName(WebDriver driver, String dropdownAttributeName, String dropdownItemText) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, BasePageNopComerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownItemText, dropdownAttributeName);
	}

	/**
	 * Click to dynamic Checkbox by label
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param radioButtonLabelName
	 */
	public void clickToCheckboxByLabel(WebDriver driver, String checkboxButtonLabelName) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxButtonLabelName);
		checkToDefaultCheckboxRadio(driver, BasePageNopComerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxButtonLabelName);
	}

	/**
	 * unClick to dynamic Checkbox by label
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param radioButtonLabelName
	 */
	public void unClickToCheckboxByLabel(WebDriver driver, String checkboxButtonLabelName) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxButtonLabelName);
		uncheckToDefaultCheckboxRadio(driver, BasePageNopComerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxButtonLabelName);
	}

	/**
	 * Click to dynamic Radio by label
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param radioButtonLabelName
	 * @param itemValue
	 */
	public void clickToRadioByLabel(WebDriver driver, String radioButtonLabelName) {
		waitForElementClickable(driver, BasePageNopComerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
		checkToDefaultCheckboxRadio(driver, BasePageNopComerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
	}

	/**
	 * Get error message at textbox by ID
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param errorID
	 */
	public String getErrorMessageAtTextboxByID(WebDriver driver, String errorID) {
		waitForElementVisible(driver, BasePageNopComerceUI.DYNAMIC_ERROR_MESSAGE_AT_TEXTBOX_BY_ID, errorID);
		return getElementText(driver, BasePageNopComerceUI.DYNAMIC_ERROR_MESSAGE_AT_TEXTBOX_BY_ID, errorID);

	}

	/**
	 * Get value in textbox by textboxID
	 * 
	 * @author Tu Thuc
	 * @param driver
	 * @param textboxID
	 */
	public String getTextboxValueByID(WebDriver driver, String textboxID) {
		waitForElementVisible(driver, BasePageNopComerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageNopComerceUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	public BasePage clickToImageHomePage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopComerceUI.IMAGE_HOME_PAGE);
		clickToElement(driver, BasePageNopComerceUI.IMAGE_HOME_PAGE);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	// Level_08_Switch_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopComerceUI.LOGOUT__LINK_AT_USER);
		clickToElement(driver, BasePageNopComerceUI.LOGOUT__LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopComerceUI.LOGOUT__LINK_AT_ADMIN);
		clickToElement(driver, BasePageNopComerceUI.LOGOUT__LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public UserHomePO openEndUserSite(WebDriver driver, String endUserUrl) {
		openPageUrl(driver, endUserUrl);
		return pageObjects.wordpress.PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminDashboardPO openAdminSite(WebDriver driver, String adminUrl) {
		openPageUrl(driver, adminUrl);
		return pageObjects.wordpress.PageGeneratorManager.getAdminDashboardPage(driver);
	}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

}