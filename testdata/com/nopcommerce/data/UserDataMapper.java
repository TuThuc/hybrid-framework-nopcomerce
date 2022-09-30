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
}
