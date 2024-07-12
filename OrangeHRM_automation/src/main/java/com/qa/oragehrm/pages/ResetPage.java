package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class ResetPage extends BaseClass {

	public ResetPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement Forgetyourpassword;
	@FindBy(xpath = "//*[@class = 'oxd-input oxd-input--active']")
	private WebElement username;
	@FindBy(xpath = "//*[@class = 'oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']")
	private WebElement resetpassword;

	public void Forgetyourpassword() {
		Forgetyourpassword.click();
	}

	public void Username(String un) {
		username.sendKeys(un);
		resetpassword.click();
	}
}
