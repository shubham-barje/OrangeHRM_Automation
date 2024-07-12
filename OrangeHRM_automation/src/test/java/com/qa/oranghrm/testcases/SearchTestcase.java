package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.LoginPage;
import com.qa.oragehrm.pages.SearchPage;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class SearchTestcase extends BaseClass{
	int TCID;
//	LoginPage lp;
	SearchPage sh;
	public SearchTestcase() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		
		Login(Props.getProperty("username"), Props.getProperty("password"));
		sh=new SearchPage();
	}
	
	@Test
	public void search() throws InterruptedException {
		TCID=9;
		sh.searching();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void close(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
		}
		
	}
}
