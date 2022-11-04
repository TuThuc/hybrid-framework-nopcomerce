package com.nopcommerce.data;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {
	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resource/UserData.json"), UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAddress")
	private String emailAddress;
	@JsonProperty("date")
	private String date;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	@JsonProperty("password")
	private Password password;

	static class Password {
		@JsonProperty("validPassword")
		private String validPassword;

		@JsonProperty("invalidPassword")
		private String invalidPassword;

		@JsonProperty("wrongPassword")
		private String wrongPassword;

		@JsonProperty("newPassword")
		private String newPassword;
	}

	public String getValidPassword() {
		return password.validPassword;
	}

	public String getInvalidPassword() {
		return password.invalidPassword;
	}

	public String getWrongPassword() {
		return password.wrongPassword;
	}

	public String getNewPassword() {
		return password.newPassword;
	}

	@JsonProperty("email")
	private Email email;

	static class Email {
		@JsonProperty("invalidEmail")
		private String invalidEmail;

		@JsonProperty("emailNotExist")
		private String emailNotExist;
	}

	public String getInvalidEmail() {
		return email.invalidEmail;
	}

	public String getEmailNotExist() {
		return email.emailNotExist;
	}

	@JsonProperty("login")
	private Login login;

	static class Login {
		@JsonProperty("username")
		private String username;

		@JsonProperty("password")
		private String password;
	}

	public String getUsername() {
		return login.username;
	}

	public String getLoginPassword() {
		return login.password;
	}

	@JsonProperty("updateCustomerInfo")
	private UpdateCustomerInfo updateCustomerInfo;

	static class UpdateCustomerInfo {
		@JsonProperty("fender")
		private String fender;

		@JsonProperty("firstName")
		private String firstName;

		@JsonProperty("lastName")
		private String lastName;

		@JsonProperty("date")
		private String date;

		@JsonProperty("month")
		private String month;

		@JsonProperty("year")
		private String year;

		@JsonProperty("company")
		private String company;
	}

	public String getFender() {
		return updateCustomerInfo.fender;

	}

	public String getFirstName() {
		return updateCustomerInfo.firstName;
	}

	public String getLastName() {
		return updateCustomerInfo.lastName;
	}

	public String getDateUpdate() {
		return updateCustomerInfo.date;
	}

	public String getMonthUpdate() {
		return updateCustomerInfo.month;
	}

	public String getYearUpdate() {
		return updateCustomerInfo.year;
	}

	public String getCompany() {
		return updateCustomerInfo.company;
	}

	@JsonProperty("addressCustomer")
	private AddressCustomer addressCustomer;

	static class AddressCustomer {
		@JsonProperty("country")
		private String country;

		@JsonProperty("province")
		private String province;

		@JsonProperty("city")
		private String city;

		@JsonProperty("address1")
		private String address1;

		@JsonProperty("address2")
		private String address2;

		@JsonProperty("zip")
		private String zip;

		@JsonProperty("phoneNumber")
		private String phoneNumber;

		@JsonProperty("faxNumber")
		private String faxNumber;
	}

	public String getCountry() {
		return addressCustomer.country;

	}

	public String getProvince() {
		return addressCustomer.province;
	}

	public String getCity() {
		return addressCustomer.city;
	}

	public String getAddress1() {
		return addressCustomer.address1;
	}

	public String getAddress2() {
		return addressCustomer.address2;
	}

	public String getZip() {
		return addressCustomer.zip;
	}

	public String getPhoneNumber() {
		return addressCustomer.phoneNumber;
	}

	public String getFaxNumber() {
		return addressCustomer.faxNumber;
	}

	@JsonProperty("subjects")
	private List<Subject> subjects;

	public List<Subject> getSubjects() {
		return subjects;
	}

	public static class Subject {
		@JsonProperty("name")
		private String name;
		@JsonProperty("point")
		private Float point;

		public String getName() {
			return name;
		}

		public float getPoint() {
			return point;
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	@JsonProperty("productReview")
	private ProductReview productReview;

	static class ProductReview {
		@JsonProperty("reviewTitle")
		private String reviewTitle;

		@JsonProperty("reviewText")
		private String reviewText;
	}

	public String getReviewTitle() {
		return productReview.reviewTitle;
	}

	public String getReviewText() {
		return productReview.reviewText;
	}

	@JsonProperty("productName")
	private ProductName productName;

	static class ProductName {
		@JsonProperty("productNameNotExist")
		private String productNameNotExist;

		@JsonProperty("productNameRelative")
		private String productNameRelative;

		@JsonProperty("productNameAbsolute")
		private String productNameAbsolute;

		@JsonProperty("productNameSearchCategories")
		private String productNameSearchCategories;
	}

	public String getProductNameNotExist() {
		return productName.productNameNotExist;
	}

	public String getProductNameRelative() {
		return productName.productNameRelative;
	}

	public String getProductNameSearchCategories() {
		return productName.productNameSearchCategories;
	}

	public String getProductNameAbsolute() {
		return productName.productNameAbsolute;
	}

	@JsonProperty("productInfoAddToCart")
	private ProductInforAddToCart productInfoAddToCart;

	static class ProductInforAddToCart {
		@JsonProperty("processor")
		private String processor;

		@JsonProperty("ram")
		private String ram;

		@JsonProperty("hdd")
		private String hdd;

		@JsonProperty("os")
		private String os;

		@JsonProperty("software1")
		private String software1;

		@JsonProperty("software2")
		private String software2;

	}

	public String getProcessor() {
		return productInfoAddToCart.processor;
	}

	public String getRam() {
		return productInfoAddToCart.ram;
	}

	public String getHDD() {
		return productInfoAddToCart.hdd;
	}

	public String getOS() {
		return productInfoAddToCart.os;
	}

	public String getSoftware1() {
		return productInfoAddToCart.software1;
	}

	public String getSoftware2() {
		return productInfoAddToCart.software2;
	}

	@JsonProperty("editProductInfoInShoppingCart")
	private EditProductInforInShoppingCart editProductInfoInShoppingCart;

	static class EditProductInforInShoppingCart {
		@JsonProperty("editProcessor")
		private String editProcessor;

		@JsonProperty("editRam")
		private String editRam;

		@JsonProperty("editHDD")
		private String editHDD;

		@JsonProperty("editOS")
		private String editOS;

		@JsonProperty("editSoftware")
		private String editSoftware;

		@JsonProperty("editQuantity")
		private String editQuantity;

	}

	public String getEditProcessor() {
		return editProductInfoInShoppingCart.editProcessor;
	}

	public String getEditRam() {
		return editProductInfoInShoppingCart.editRam;
	}

	public String getEditHDD() {
		return editProductInfoInShoppingCart.editHDD;
	}

	public String getEditOS() {
		return editProductInfoInShoppingCart.editOS;
	}

	public String getEditSoftware() {
		return editProductInfoInShoppingCart.editSoftware;
	}

	public String getEditQuantity() {
		return editProductInfoInShoppingCart.editQuantity;
	}

	@JsonProperty("billingAddress")
	private BillingAddress billingAddress;

	static class BillingAddress {
		@JsonProperty("firstName")
		private String firstName;

		@JsonProperty("lastName")
		private String lastName;

		@JsonProperty("emailAddress")
		private String emailAddress;

		@JsonProperty("country")
		private String country;

		@JsonProperty("province")
		private String province;

		@JsonProperty("city")
		private String city;

		@JsonProperty("address1")
		private String address1;

		@JsonProperty("address2")
		private String address2;

		@JsonProperty("zip")
		private String zip;

		@JsonProperty("phoneNumber")
		private String phoneNumber;

		@JsonProperty("faxNumber")
		private String faxNumber;
	}

	public String geFirstNameBilling() {
		return billingAddress.firstName;
	}

	public String getLastNameBilling() {
		return billingAddress.lastName;
	}

	public String getEmailAddressBilling() {
		return billingAddress.emailAddress;
	}

	public String getCountryBilling() {
		return billingAddress.country;

	}

	public String getProvinceBilling() {
		return billingAddress.province;
	}

	public String getCityBilling() {
		return billingAddress.city;
	}

	public String getAddress1Billing() {
		return billingAddress.address1;
	}

	public String getAddress2Billing() {
		return billingAddress.address2;
	}

	public String getZipBilling() {
		return billingAddress.zip;
	}

	public String getPhoneNumberBilling() {
		return billingAddress.phoneNumber;
	}

	@JsonProperty("creditCard")
	private CreditCard creditCard;

	static class CreditCard {
		@JsonProperty("cardHoderName")
		private String cardHoderName;

		@JsonProperty("cardNumber")
		private String cardNumber;

		@JsonProperty("cardCode")
		private String cardCode;
	}

	public String getCardHoderName() {
		return creditCard.cardHoderName;
	}

	public String getCardNumber() {
		return creditCard.cardNumber;
	}

	public String getCardCode() {
		return creditCard.cardCode;
	}

}
