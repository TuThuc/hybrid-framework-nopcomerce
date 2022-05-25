package javaOPP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super  extends BaseOPP{
	private WebDriver driver;
	public long longTimeout = 14;
	// long shortTimeout = 10;
	private int secondNumber;
	public Topic_05_This_Super() {
		super();
		System.out.println("Con  cua class con");
	}
	public void setImplicitWait() {
	 long shortTimeout = 10;
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(super.shortTimeout, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		
	Topic_05_This_Super topic = new Topic_05_This_Super();
	}

}
