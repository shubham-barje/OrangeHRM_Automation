package com.qa.oragehrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.baseclass.BaseClass;

public class AdminPannel extends BaseClass{
	public AdminPannel() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[1]" )WebElement Admin;
	
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]") WebElement add_btn;
	@FindBy(xpath="(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]") WebElement user_role;
	@FindBy(xpath="(//input[@placeholder=\"Type for hints...\"])[1]") WebElement emp_name;
	@FindBy(xpath="(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]") WebElement status;
	@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[2]") WebElement username_emp;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input") WebElement password_emp;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input") WebElement confirm_password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")WebElement Save_btn;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input") WebElement userRecord;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]") WebElement Search_btn;
	
	public void adduser() throws InterruptedException {
		Admin.click();
		add_btn.click();
		
		user_role.click();
		driver.findElement(By.xpath("//*[contains(text(),'Admin')]")).click();
		
		emp_name.sendKeys("Viki123 Barje");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.sendKeys(emp_name,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		status.click();
		driver.findElement(By.xpath("//*[contains(text(),'Enabled')]")).click();
		
		username_emp.sendKeys("Viki1234barje");
		password_emp.sendKeys("barje@2613");
		confirm_password.sendKeys("barje@2613");
		
		Save_btn.click();
		Thread.sleep(6000);
		
		
	}
	
	public void usersearch() throws InterruptedException {
		Admin.click();
		userRecord.sendKeys("Viki1234barje");
		Search_btn.click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,400)");
		Thread.sleep(6000);
		
	}
}
