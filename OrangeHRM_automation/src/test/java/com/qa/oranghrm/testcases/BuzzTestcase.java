package com.qa.oranghrm.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.oragehrm.pages.BuzzPage;
import com.qa.oragehrm.pages.LoginPage;
import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;

public class BuzzTestcase extends BaseClass{
	int TCID;
	LoginPage lp;
	BuzzPage bz;
	
	public BuzzTestcase() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initilization();
		lp=new LoginPage();
		Login(Props.getProperty("username"), Props.getProperty("password"));
		bz=new BuzzPage();
	}
	
	@Test
	public void buzzi() throws InterruptedException {
		TCID= 10;
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
		Wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Buzz"))).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");
		bz.Buzzing();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/button[2]"))).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/button[3]"))).click();
		Thread.sleep(10000);
		
	}
	
	@AfterMethod
	public void close(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			TestUtilis.ScrrenShort(TCID);
			driver.quit();
		}
		
	}

}
