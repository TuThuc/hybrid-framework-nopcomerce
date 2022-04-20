package javabasic;

import org.testng.annotations.Test;

public class Topic_04_Array {
	// @Test

	public void TC_01() {
		int arr[] = { 2, 7, 6, 8, 9 };
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("phan tu lon nhat mang la:" + max);
	}

	@Test

	public void TC_02() {
		int arr[] = { 2, 7, 6, 8, 9 };
		int tong = 0;
		for (int i = 0; i < arr.length; i++) {

			tong += arr[i];

		}
		System.out.println("tong cua mang:" + tong);
	}

}
