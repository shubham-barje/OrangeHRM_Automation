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

public class CreateVacency extends BaseClass {

	public CreateVacency() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement username;
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement password;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement login_btn;

	@FindBy(linkText = "Recruitment")
	WebElement recuruitment;

	@FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab\"]")
	WebElement vacencies;
	@FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addbtn;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input")
	WebElement vacency_name;
//	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]") WebElement job_title;
	@FindBy(xpath = "//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]")
	WebElement textarea;
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	WebElement hiringManager;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[2]/div/div/div/div[2]/input")
	WebElement no_of_positions;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement save_btn;

	@FindBy(xpath = "(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]")
	WebElement job_title;
	@FindBy(xpath = "//button[@Type=\"submit\"]")
	WebElement Search_btn;

	public void login(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		login_btn.click();
	}

	public void recuruitment() throws InterruptedException {
		recuruitment.click();
		vacencies.click();
		addbtn.click();
		addVacency();
		Thread.sleep(2000);
		no_of_postions();
		save_btn.click();
		Thread.sleep(2000);
		Thread.sleep(6000);
	}

	public void addVacency() throws InterruptedException {

		vacency_name.sendKeys("Automation Tester QA Engineer");

		driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]")).click();
		WebElement dropdown = driver.findElement(By.xpath("//*[contains(text(),'QA Engineer')]"));
		dropdown.click();

		textarea.sendKeys("Vacency for Automation Tester");
//		WebElement palceholder = textarea;
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		//now we pass the parameters
//		js.executeScript("argument[0].value='Vacency for Automation Tester'", palceholder);

		hiringManager.sendKeys("Sania  Shaheen");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.sendKeys(hiringManager, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

//		Thread.sleep(2000);
//		no_of_postions();
//
//		save_btn.click();
//		Thread.sleep(2000);

	}

	public void searchVacnacies() throws InterruptedException {
		recuruitment.click();
		vacencies.click();
		job_title.click();
		driver.findElement(By.xpath("//*[contains(text(),'QA Engineer')]")).click();
		Search_btn.click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);

	}

	public void no_of_postions_null() {
		no_of_positions.sendKeys(" ");
	}
	public void no_of_postions() {
		no_of_positions.sendKeys("2");
	}
	public void no_of_postions_negative() {
		no_of_positions.sendKeys("-2");
	}
	public void missInfo() throws InterruptedException {
		recuruitment.click();
		vacencies.click();
		addbtn.click();
		addVacency();
		Thread.sleep(2000);
		no_of_postions_null();
		save_btn.click();
		Thread.sleep(2000);
	}
	
	public void invalid_info() throws InterruptedException {
		recuruitment.click();
		vacencies.click();
		addbtn.click();
		addVacency();
		Thread.sleep(2000);
		no_of_postions_negative();
		save_btn.click();
		Thread.sleep(2000);
	}

}
