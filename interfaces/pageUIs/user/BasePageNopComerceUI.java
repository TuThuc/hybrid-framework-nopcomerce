package pageUIs.user;

public class BasePageNopComerceUI {
	public static final String LOGOUT__LINK_AT_USER = "css=a[class = 'ico-logout']";
	public static final String LOGOUT__LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String LIST_PRODUCT_BY_TITLE = "xpath=//h2[@class='product-title']";
	public static final String IMAGE_HOME_PAGE = "css=div.header-logo>a";

	// Pattern Object
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";

	public static final String DYNAMIC_TEXTBOX_BY_ID = "Xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "Xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "Xpath=//select[@name='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "Xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_RADIO_BY_LABEL = "Xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String DYNAMIC_ERROR_MESSAGE_AT_TEXTBOX_BY_ID = "xpath=//span[@id='%s']";
	public static final String DYNAMIC_HEADER_LINK_BY_TEXT = "Xpath=//span[text()='%s']";
	public static final String DYNAMIC_FOOTER_LINK_BY_TEXT = "Xpath=//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_TITLE_BY_TEXT = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String DYNAMIC_TOP_MENU_HEADER_BY_TEXT = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";

}
