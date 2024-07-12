package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class SearchPage extends BaseClass{

	public SearchPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")
	private WebElement search;
	
	public void searching() {
		search.click();
		search.sendKeys("pim");
	}

}
