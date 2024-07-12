package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.LoginPage;
import com.qa.oragehrm.pages.LogoutPage;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class LogoutTestCase extends BaseClass{
	int TCID;
	LoginPage lp;
	WebDriver driver;
	LogoutPage lop;
	public LogoutTestCase() throws IOException {
		super();
		
	}
	@BeforeMethod
	  public void setUp() throws IOException, InterruptedException  {
		  initilization();
		  lp=new LoginPage();
		  Login(Props.getProperty("username"), Props.getProperty("password"));
		  lop=new LogoutPage();
		  
	  }
	  @Test(priority=1)
	  public void validatePageTitle() {
		  TCID=15;
		  String title=lop.getHomePageTitle();
		  Assert.assertEquals(title, "OrangeHRM");
	  }
	  @Test(priority=2)
	  public void verifyHomePage() {
		  TCID=16;
		 boolean text= lop.verifyHomePage();
		 Assert.assertTrue(text);
		  
	  }
	  
	  @Test(priority=3)
	  public void verifyDropDown() {
		  TCID=17;
		  lop.logout();
	  }
	  @AfterMethod
	  public void close(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.SUCCESS) {
				TestUtilis.ScrrenShort(TCID);
				driver.quit();
			}

		}
}
