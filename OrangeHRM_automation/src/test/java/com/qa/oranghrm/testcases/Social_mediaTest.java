package com.qa.oranghrm.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.baseclass.BaseClass;
import com.qa.oranghrm.utils.TestUtilis;


public class Social_mediaTest extends BaseClass{
	int TCID;
	public Social_mediaTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initilization();
    }

    @Test
    public void validateSocialMediaLinks() {
    	TCID = 11;
       WebElement facebookLink = driver.findElement(By.xpath("(//a[@target=\"_blank\"])[2]"));
        Assert.assertTrue(facebookLink.isDisplayed(), "Facebook link is not displayed");
        facebookLink.click();
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com/OrangeHRM"), "Facebook URL is incorrect");
                driver.close();
                driver.switchTo().window(currentWindow);
            }
        }

        WebElement twitterLink = driver.findElement(By.xpath("(//a[@target=\"_blank\"])[3]"));
        Assert.assertTrue(twitterLink.isDisplayed(), "Twitter link is not displayed");
        twitterLink.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                Assert.assertTrue(driver.getCurrentUrl().contains("twitter.com/orangehrm"), "Twitter URL is incorrect");
                driver.close();
                driver.switchTo().window(currentWindow);
            }
        }

        WebElement linkedInLink = driver.findElement(By.xpath("(//a[@target=\"_blank\"])[1]"));
        Assert.assertTrue(linkedInLink.isDisplayed(), "LinkedIn link is not displayed");
        linkedInLink.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                Assert.assertTrue(driver.getCurrentUrl().contains("linkedin.com/company/orangehrm"), "LinkedIn URL is incorrect");
                driver.close();
                driver.switchTo().window(currentWindow);
            }
        }

        WebElement youTubeLink = driver.findElement(By.xpath("(//a[@target=\"_blank\"])[4]"));
        Assert.assertTrue(youTubeLink.isDisplayed(), "YouTube link is not displayed");
        youTubeLink.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"), "YouTube URL is incorrect");
                driver.close();
                driver.switchTo().window(currentWindow);
            }
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
