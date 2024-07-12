package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class LogoutPage extends BaseClass {
	LoginPage lp;

	public LogoutPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon")
	WebElement dropDown;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutOption;
	@FindBy(css = ".oxd-topbar-header-breadcrumb")
	WebElement Dashboard;

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyHomePage() {
		return Dashboard.isDisplayed();
	}

	public void logout() {
		dropDown.click();
		logoutOption.click();
	}

}
