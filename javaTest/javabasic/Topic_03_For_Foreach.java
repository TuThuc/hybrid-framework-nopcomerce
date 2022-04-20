package javabasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_03_For_Foreach {
WebDriver driver;
Scanner scanner = new Scanner(System.in);
//@Test
public void TC_01() {

int number = scanner.nextInt();
for(int i= 1; i<=number; i ++) {

	System.out.print(" "+ i);
}
			
	}
//@Test
public void TC_02() {
	int numberA = scanner.nextInt();
int numberB = scanner.nextInt();
for(int i= numberA; i<= numberB; i++) {
	System.out.print(" " +i);
}
}
@Test
public void TC_03() {
	int mounth = scanner.nextInt();
//int numberB = scanner.nextInt();
switch(mounth)
{case 1:{
	System.out.print("JAN ");	
	break;
}
case 2:{
	System.out.print("FE ");
	break;
}
}	
}
}




