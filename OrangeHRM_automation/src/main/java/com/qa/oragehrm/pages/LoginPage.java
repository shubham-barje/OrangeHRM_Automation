package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() throws IOException {
//		It is used to refer to the immediate superclass (parent class) of the current class.
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name=\"username\"]") private WebElement username;
	@FindBy(xpath="//input[@name=\"password\"]") private WebElement password;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement login_btn;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p") WebElement invalid_credentials;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span") WebElement err_msg;
	
	public void loginOrangeHrm(String un,String pass ) throws InterruptedException {
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(2000);
		login_btn.click();
		Thread.sleep(2000);
	}
	
	public String verifyTitle() {
		String Title = driver.getTitle();
		return Title;
	}
	
	public String getErrorText() {
		return err_msg.getText();
		
	}
	
	public String getErrorTestCredentialUn() {
		return invalid_credentials.getText();
		
	}
}
