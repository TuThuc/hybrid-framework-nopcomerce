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

	static class Email {
		@JsonProperty("invalidEmail")
		private String invalidEmail;

		@JsonProperty("emailNotExist")
		private String emailNotExist;
	}

	// public String getInvalidEmail() {
	// return email.invalidEmail;
	// }

	// public String getEmailNotExist() {
	// return email.emailNotExist;
	// }

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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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
