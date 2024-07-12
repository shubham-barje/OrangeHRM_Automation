package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.CreateVacency;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class CreateVacencyTestCases extends BaseClass{
	int TCID;
	public CreateVacencyTestCases() throws IOException {
		super();
	}
	
	CreateVacency cv = new CreateVacency();
	
	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		Login(Props.getProperty("username"),Props.getProperty("password"));
		cv = new CreateVacency();
	}
	
	@Test
	public void createVacency() throws InterruptedException {
		TCID = 4;
//		cv.login(Props.getProperty("username"), Props.getProperty("password"));
		cv.recuruitment();
		
	}
	
	@Test
	public void vacencySerch() throws InterruptedException {
		TCID = 5;
//		cv.login(Props.getProperty("username"), Props.getProperty("password"));
		cv.searchVacnacies();
	}
	
	@Test
	public void missingInfo() throws InterruptedException {
		cv.missInfo();
	}
	@Test 
	public void invalid_info() throws InterruptedException {
		cv.invalid_info();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException, IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
			Thread.sleep(2000);

		}
		
	}
}
