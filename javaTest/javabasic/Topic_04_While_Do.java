package javabasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_04_While_Do {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	//@Test
	public void TC_01() {

		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		while(numberA< numberB) {
if(numberA%3==0&&numberA%5==0) {
	System.out.println(numberA);
	
}
numberA++;
		}
	}
	//@Test
		public void TC_02() {

			int numberA = scanner.nextInt();
			int i = 0;
			//int numberB = scanner.nextInt();
			while(numberA>0) {
	if(numberA%2!=0) {
		i+= numberA;
		
	}
	numberA--;
			}
	System.out.println(i);
			
		}
	//@Test
	public void TC_03() {

		int numberA = scanner.nextInt();
		int i = 1;
		//int numberB = scanner.nextInt();
		while(numberA>0) {
 {
	i= numberA*i;
	
}
numberA--;
		}
System.out.println(i);
		
	}
	@Test
			public void TC_04() {

//				int numberA = scanner.nextInt();
		int tong=0;
			int i = 1;
				//int numberB = scanner.nextInt();
				while(i<=10) {
		if(i%2==0) {
			System.out.println(i);
			 tong +=i ;
			
		}
		i++;
				}
		System.out.println(tong);
				
			}
}
