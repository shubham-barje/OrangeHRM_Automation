package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.LeavePage;
import com.qa.oragehrm.pages.LoginPage;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class LeaveTestCase extends BaseClass {
	int TCID;
	WebDriver driver;
	LoginPage lp;
	LeavePage l;

	public LeaveTestCase() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initilization();
		lp = new LoginPage();
		Login(Props.getProperty("username"), Props.getProperty("password"));
		l = new LeavePage();
	}

	@Test(priority = 1)
	public void verifyLeave() throws InterruptedException {
		TCID = 12;
		l.LeaveTest();
	}

	@AfterMethod
	public void close(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
		}

	}
}
