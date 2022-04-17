package javabasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_01_Condition_Excercise {
	WebDriver driver;
Scanner scanner = new Scanner(System.in);
//@Test
public void TC_01() {
	int numberA = scanner.nextInt();
	int numberB= scanner.nextInt();
	if (numberA>= numberB) {
		System.out.println("Số " + numberA + " lớn hơn hoặc bằng " + numberB);
	}else {
	System.out.println("Số " + numberA + " nhỏ hơn " +numberB);
}}
//@Test
public void TC_02() {
	String tenA = scanner.nextLine();
	String tenB = scanner.nextLine();
	if(tenA.equals(tenB)) {
	System.out.println("hai người cùng tên");
	}else {
		System.out.println("hai người khác tên");
	}
}
//@Test
public void TC_03() {
	int number1 = scanner.nextInt();
	int number2= scanner.nextInt();
	int number3= scanner.nextInt();
	
	if (number1> number2 && number1 >number3) {
		System.out.println("Số " + number1 + " lớn nhất " );
	}else if(number2>number3){
	System.out.println("Số " + number2 + " lớn nhất " );
}else {
	System.out.println(number3 +" lớn nhất");
}
	}
//@Test
public void TC_04() {
	int number = scanner.nextInt();
	
	if (number>=10 && number <=100) {
		System.out.println(number + " nam trong [10,100]");
	}
	else {
		System.out.println(number + " khong nam trong [10,100]" );
	}
}
//@Test
public void TC_05() {
String tenHS = scanner.nextLine();
float diemHS = scanner.nextFloat();
if(diemHS>=0 && diemHS <5) {
	System.out.println(tenHS + " dat diem D");
}else if(diemHS>=5 && diemHS <7.5) {
	System.out.println(tenHS + " dat diem C");
}else if(diemHS>7.5 && diemHS <8.5) {
	System.out.println(tenHS + " dat diem B");	
}else if(diemHS>=8.5 && diemHS <=10) {
	System.out.println(tenHS + " dat diem A");
}
}
@Test
public void TC_06() {
int numberMounth	= scanner.nextInt();
if(numberMounth == 1 ||numberMounth == 12) {
	System.out.println("So ngay thang " + numberMounth + " la 31" );
	}else if(numberMounth == 2) {
		System.out.println("So ngay thang " + numberMounth + " la 28" );
}else {
	System.out.println("So ngay thang " + numberMounth + " la 30" );
}
}
}

