package javabasic;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
@Listeners(commons.MethodListener.class)
public class Topic_07_Assert extends BaseTest {
	@Test
	public void TC_01() {
		String employee = "Tran van em";
		// Dùng để kiểm tra 1 điều kiện trả về là đúng(true)
		verifyTrue(employee.equals("Tran van. em"));
		//Assert.assertTrue(employee.equals("Tran van e"),"Employee not equal");
		// Dùng để kiểm tra 1 điều kiện trả về là sai(false)
	verifyFalse(employee.equals("dsdsd"));
	verifyEquals(employee,"Tran van em.");

	}
}
