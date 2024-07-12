package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class AddEmp extends BaseClass{
	public AddEmp() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]") WebElement pim;
	@FindBy(xpath="//li[@class=\"oxd-topbar-body-nav-tab\"]") WebElement add_emp;
	@FindBy(xpath="//input[@name=\"firstName\"]") WebElement firstName;
	@FindBy(xpath="//input[@name=\"middleName\"]") WebElement middleName;
	@FindBy(xpath="//input[@name=\"lastName\"]") WebElement lastName;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")WebElement Emp_id;
	
	@FindBy(xpath="//span[@class=\"oxd-switch-input oxd-switch-input--active --label-right\"]")WebElement toggle_btn;
	@FindBy(xpath="(//input[@autocomplete=\"off\"])[1]") WebElement userName;
	@FindBy(xpath="(//input[@autocomplete=\"off\"])[2]") WebElement passWord;
	@FindBy(xpath="(//input[@autocomplete=\"off\"])[3]") WebElement confirm_pass;
	@FindBy(xpath="//button[@type=\"submit\"]") WebElement save_btn;
	
	@FindBy(xpath="//li[@class=\"oxd-topbar-body-nav-tab --visited\"]") WebElement emp_list_btn;
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]") WebElement emp_name;
	@FindBy(xpath="//button[@type=\"submit\"]") WebElement search_btn_emp_list;
	
	public void Emp_details() throws InterruptedException {
		pim.click();
		add_emp.click();
		firstName.sendKeys("Viki123");
		lastName.sendKeys("Barje");
		Emp_id.sendKeys("101");
		
		Thread.sleep(3000);
		toggle_btn.click();
		userName.sendKeys("Viki123");
		passWord.sendKeys("barje@2613");
		confirm_pass.sendKeys("barje@2613");
		save_btn.click();
		Thread.sleep(3000);
		
	}
	
	public void Emp_list() throws InterruptedException {
		pim.click();
		emp_list_btn.click();
		emp_name.sendKeys("Viki123 Barje");
		search_btn_emp_list.click();
		
		JavascriptExecutor jse = (JavascriptExecutor)  driver;
//		(0,400) ==> 0 for x-axis and 400 for y-axis
		jse.executeScript("window.scroll(0,400)");
		Thread.sleep(6000);
	}
	
	
}
