package pageUIs.user;

public class UserCheckoutPageUI {

	public static final String PAYMENT_INFO_BY_TEXT = "xpath=//p[contains(string(),'%s')]";
	public static final String BILLING_INFO_BY_TEXT = "xpath=//div[@class= 'billing-info']//li[contains(text(),'%s')]";
	public static final String CONTINUE_BUTTON_BY_ID = "xpath=//div[@id='%s']/button";
	public static final String SHIPPING_ADDRESS_BY_TEXT = "xpath=//div[@class= 'shipping-info']//li[contains(string(),'%s')]";
	public static final String TOTAL_PRICE_PRODUCT = "xpath=//span[@class='value-summary']/strong";
	public static final String ORDER_SUCCESS_MESSAGE = "xpath=//strong[text()='Your order has been successfully processed!']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']/strong";
	public static final String PAYMENT_METHOD = "xpath=//li[@class='payment-method']/span[@class='value']";

}
