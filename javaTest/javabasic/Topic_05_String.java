package javabasic;

import org.testng.annotations.Test;

public class Topic_05_String {
	String courseName = "Automation Testing Advanced";
	String courseSchool = "Automation Testing 345 Tutorials Online";
	String ProductPrice = "$100.00";

	// @Test
	public void TC_01() {
		char courseNameArr[] = courseName.toCharArray();
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;
		for (char character : courseNameArr) {
			// Uppercase
			if (character <= 'Z' && character >= 'A') {
				countUpper++;

			}
			// Lowercase
			if (character <= 'z' && character >= 'a') {
				countLower++;

			}
			// Number
			if (character <= '9' && character >= '0') {
				countNumber++;

			}

		}
		System.out.println(countUpper);
		System.out.println(countLower);
		System.out.println(countNumber);
	}

	// @Test
	public void TC_02() {
		char courseSchoolArr[] = courseSchool.toCharArray();
		int countA = 0;
		int countNumber = 0;
		for (char chacracterA : courseSchoolArr) {
			if (chacracterA == 'T') {
				countA++;
			}
		}
		boolean containText = courseSchool.contains("Testing");
		boolean startText = courseSchool.startsWith("Automation");
		boolean endText = courseSchool.endsWith("Online");
		int vitriText = courseSchool.indexOf("Tutorials");
		String replaceText = courseSchool.replace("Online", "Offline");
		for (char cNumber : courseSchoolArr) {
			if (cNumber <= '9' && cNumber >= '0') {
				countNumber++;
			}
		}

		System.out.println(countA);
		System.out.println(containText);
		System.out.println(startText);
		System.out.println(endText);
		System.out.println(vitriText);
		System.out.println(replaceText);
		System.out.println(countNumber);

	}

	@Test
	public void TC_03() {
		char courseSchoolArr[] = courseSchool.toCharArray();
		for (int i = courseSchoolArr.length - 1; i >= 0; i--) {
			System.out.print(courseSchoolArr[i]);
		}
		// Sap xep Sort Data(Asc/Desc)

		float productPriceF = Float.parseFloat(ProductPrice);
		System.out.println(productPriceF);

	}
}
