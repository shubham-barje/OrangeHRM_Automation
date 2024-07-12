package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.AddEmp;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class AddEmpTestCase extends BaseClass{
	int TCID;
	
	public AddEmpTestCase() throws IOException{
		super();
	}
	AddEmp addEmp = new AddEmp();
	
	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		Login(Props.getProperty("username"),Props.getProperty("password"));
		addEmp = new AddEmp();
	}
	
	@Test(priority=1)
	public void emp_add() throws InterruptedException {
		TCID = 7;
		addEmp.Emp_details();
	}
	
	@Test(priority=2)
	public void verifyIn_Emp_list() throws InterruptedException {
		TCID = 8;
		addEmp.Emp_list();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException  {
		if(result.getStatus() == ITestResult.SUCCESS) 
		{
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
			Thread.sleep(3000);
		}
		
	}
	
}
