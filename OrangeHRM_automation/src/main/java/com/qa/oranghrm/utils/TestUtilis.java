package com.qa.oranghrm.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.orangehrm.baseclass.BaseClass;

public class TestUtilis extends BaseClass {
	public TestUtilis() throws IOException {
		super();
		
	}

	public static void ScrrenShort(int TCID) throws IOException{
		File dest1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src1 = new File("D:\\OrangeHRM_automation\\OrangeHRM_automation\\ScreenShort\\screenshort"+TCID+".png");
		FileHandler.copy(dest1, src1);
	}
}
