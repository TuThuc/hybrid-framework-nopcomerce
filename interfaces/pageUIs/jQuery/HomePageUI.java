package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGING_PAGE_BY_NUMBER = "xpath=//li[@class ='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGING_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class ='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active'][text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text'][text()='%s']/parent::div/following-sibling::input";
}
