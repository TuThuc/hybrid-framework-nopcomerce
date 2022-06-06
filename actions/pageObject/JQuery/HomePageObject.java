package pageObject.JQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
WebDriver driver;

public HomePageObject(WebDriver driver) {
	this.driver = driver;
}

public void openPagingByPageNumber(String pageNumber) {
	waitForAllElementVisible(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
	clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
	
}


}
