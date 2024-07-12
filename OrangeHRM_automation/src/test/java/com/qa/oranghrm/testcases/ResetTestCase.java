package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.ResetPage;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class ResetTestCase extends BaseClass{
	ResetPage password;
	int TCID;
	public ResetTestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	  public void setUp() throws IOException {
		  initilization();
		  password = new ResetPage();
	  }
	@Test(priority=1)
	public void ForgetPasswordTest() {
		TCID= 13;
		password.Forgetyourpassword();
	}
	
	@Test(priority=2)
	public void verifyResetpassword() {
		TCID = 14;
		password.Username(Props.getProperty("username"));
	}
	
	
	@AfterMethod
	public void close(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
		}

	}
}
