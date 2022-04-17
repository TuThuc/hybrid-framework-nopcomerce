package javabasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_02_Switch_Case {
WebDriver driver;
Scanner scanner = new Scanner(System.in);
@Test
public void TC_01() {
	int mounth = scanner.nextInt();
	switch (mounth) {
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
		System.out.println("Thang co 31 ngay");
		break;
	case 2:
		System.out.println("Thang co 28 ngay");
		break;
	case 4:
	case 6:
	case 9:
	case 11:
		System.out.println("Thang co 30 ngay");
break;
default:
	System.out.println("Nhap lai thang trong khoang 1-12");
	break;
		
		
		
		
			
	}
}

}
