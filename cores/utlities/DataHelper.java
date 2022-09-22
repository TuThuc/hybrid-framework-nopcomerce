package utlities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	// Firstname/ lastname/ email/city/phone/ address/state/pin/zip code/country
	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getCity() {
		return faker.address().city();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddresss() {
		return faker.address().streetAddress();
	}

	public String getCountry() {
		return faker.address().country();
	}

	public String getZipcode() {
		return faker.address().zipCode();
	}

	// Number/text/ Special charater
	public String getPassword() {
		return faker.internet().password(8, 12, true, true);
	}
}
