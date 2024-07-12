package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class BuzzPage extends BaseClass{

	public BuzzPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="oxd-buzz-post-input")
    private WebElement mind;
    
    @FindBy(css="[type=submit]")
    private WebElement post;
    
    
    @FindBy(id="Group")
    private WebElement like;
    
    public void Buzzing() {
    	mind.sendKeys("hello");
    	post.click();
    	like.click();
    }
    
   
    
    

    public void closeDown() {
        driver.close();
    }
}


