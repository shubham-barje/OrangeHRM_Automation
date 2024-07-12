package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.AdminPannel;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class AdminPannelTestCase extends BaseClass{
	int TCID;
	public AdminPannelTestCase() throws IOException{
		super();
	}
	
	AdminPannel ap;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		Login(Props.getProperty("username"), Props.getProperty("password"));
		ap = new AdminPannel();
	}
	@Test(priority=1)
	public void UserMangement() throws InterruptedException {
		TCID = 5;
		ap.adduser();
	}
	
	@Test(priority=2)
	public void SerachUserAdmin() throws InterruptedException {
		TCID=6;
		ap.usersearch();
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException, IOException {
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
			Thread.sleep(3000);
		}
		
	}
	
}
