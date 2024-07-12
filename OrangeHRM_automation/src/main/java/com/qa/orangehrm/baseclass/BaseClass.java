package com.qa.orangehrm.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties Props;
	
	
	//Constructor
	public BaseClass() throws IOException {
		Props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\OrangeHRM_automation\\OrangeHRM_automation\\src\\main\\java\\com\\qa\\orangehrm\\config\\config.properties");
			Props.load(fis);
		}
		catch(FileNotFoundException f) {
			f.printStackTrace();
		}
	}
	
	public void initilization() {
		String browserName = Props.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equals("FireFox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Props.getProperty("url"));
	}
	
	public void Login(String un,String pass) {
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}
}
