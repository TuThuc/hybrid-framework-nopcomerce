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

	//@Test

	public void TC_02() {
		int arr[] = { 2, 7, 6, 8, 9 };
		int tong = 0;
		for (int i = 0; i < arr.length; i++) {

			tong += arr[i];

		}
		System.out.println("tong cua mang:" + tong);
	}
	//@Test

	public void TC_03() {
		int arr[] = { 2, 7, 6, 8, 9 };
		int tong = 0;
		for (int i = 0; i < arr.length; i++) {

			tong = arr[0]+ arr[arr.length-1];

		}
		System.out.println("tong cua phan tu dau va phan tu cuoi:" + tong);
	}

	//@Test

	public void TC_04() {
		int arr[] = { 2, 7, 6, 8, 9, 16, 17, 20, 21 };
		// int tong = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			}

		}
	}
	//@Test

	public void TC_05() {
		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int tong = 0;
		for (int i = 0; i < arr.length; i++) {

			if ( arr[i] > 0 && arr[i] % 2 != 0) {
			System.out.println(arr[i]);	
			tong +=arr[i];
			}
			
		}
		System.out.println(tong);
	}
	//@Test

	public void TC_06() {
		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
		//int tong = 0;
		for (int i = 0; i < arr.length; i++) {

			if ( arr[i] >= 0 && arr[i] <= 10) {
			System.out.println(arr[i]);	
			//tong +=arr[i];
			}
			
		}
		//System.out.println(a);
	}
	@Test

	public void TC_07() {
		int arr[] = { 3, 5, 7, 30, 10, 5, 8, 23,0,-5 };
		int tong = 0;
		float tbc = 0;
		for (int i = 0; i < arr.length; i++) {

			tong +=arr[i];
				
			//tong +=arr[i];
			
			
			}
		System.out.println(tong);
		tbc= tong / arr.length;
		
		System.out.println(tbc);
		}
		//System.out.println(a);
	
}
