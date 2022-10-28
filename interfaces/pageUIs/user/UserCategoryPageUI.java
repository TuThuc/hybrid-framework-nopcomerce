package pageUIs.user;

public class UserCategoryPageUI {
	public static final String PRODUCT_SORTING_DROPDOWN = "xpath=//select[@id='products-orderby']";
	public static final String LIST_PRODUCT_NAME_TEXT = "xpath=//h2[@class='product-title']/a";
	public static final String LIST_PRODUCT_PRICE_TEXT = "xpath=//div[@class='prices']/span";
	public static final String DYNAMIC_PAGE_PAGING_BY_TEXT = "xpath=//div[@class='pager']//a[text()='%s']";
	public static final String PAGE_PAGING = "xpath=//div[@class='pager']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//button[text()='Add to cart']";
	public static final String ADD_TO_CART_SUCCESS_MESSAGE = "xpath=//p[@class='content']";
	public static final String CLOSE_BUTTON = "xpath=//span[@class='close']";

}
