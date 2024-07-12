package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class LeavePage extends BaseClass{

	public LeavePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[@class = 'oxd-text oxd-text--span oxd-main-menu-item--name'])[3]") private WebElement leave;
    @FindBy(xpath = "(//*[@class = 'oxd-topbar-body-nav-tab-item'])[1]") private WebElement apply;
    @FindBy(xpath = "//*[@class = 'oxd-select-text-input']") private WebElement Select;
    @FindBy(xpath = "(//div[@class='oxd-select-option'])[2]") private WebElement Key;
    @FindBy(xpath = "(//*[@class = 'oxd-input oxd-input--active'])[2]") private WebElement FromDate;
    //@FindBy(xpath = "(//*[@class = 'oxd-input oxd-input--active'])[3]") private WebElement ToDate;
    @FindBy(xpath = "//*[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']") private WebElement comment;
    @FindBy(xpath = "//*[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']") private WebElement Apply;
 
    
    
    public void LeaveTest() throws InterruptedException {
		leave.click();
		apply.click();
		Select.click();
		Key.click();
		FromDate.sendKeys("2024-11-07");
		//ToDate.sendKeys("2024-13-07");
		comment.sendKeys("Please Approve My Leave!!");
		Apply.click();
}
}
