package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.LoginPage;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class LoginTestCases extends BaseClass{
	int TCID;
	public LoginTestCases() throws IOException {
		super();
	}

	LoginPage lp = new LoginPage();
	
	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		lp =new LoginPage();
	}
	
	@Test
	public void login() throws InterruptedException {
		
		lp.loginOrangeHrm(Props.getProperty("username"), Props.getProperty("password"));
	}
	
	@Test
	public void verifyTitle() {
		String actResult = lp.verifyTitle();
		String expResult = "OrangeHRM";
		Assert.assertEquals(actResult, expResult);
	}
	
	@DataProvider(name = "creadentials")
	public Object[][] getData(){
		return new Object[][]
		{
			{"Valid","Admin","admin123"},
			{"InValidUn","Admin100","admin123"},
			{"blankUN","","admin123"},
		};
	}
	
	@Test(dataProvider="creadentials")
	
	public void verifyLoginFunctionality(String senario,String username,String password) throws InterruptedException 
	{
		lp.Login(username, password);
		if(senario.equals("Valid")) 
		{
			TCID =1;
			String actResult = lp.verifyTitle();
			String expResult = "OrangeHRM";
			Assert.assertEquals(actResult, expResult);
			Thread.sleep(3000);
		}
		else if (senario.equals("InValidUn"))
		{
			TCID=2;
			String actResult = lp.getErrorTestCredentialUn();
			String expResult = "Invalid credentials";
			Assert.assertEquals(actResult, expResult);
			Thread.sleep(3000);
		}
		else if (senario.equals("blankUN"))
		{
			TCID=3;
			String actResult = lp.getErrorText();
			String expResult = "Required";
			Assert.assertEquals(actResult, expResult);
			Thread.sleep(3000);
		}
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) 
		{
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
		}
	}
}
