package com.pages;


import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@id='mobileNumberPass']")
	private WebElement emailField;
	
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='LOGIN']")
	private WebElement loginButton;
	
	public void login() throws Exception {
		
		String rootFolder = System.getProperty("user.dir");
		Properties pObj=new Properties();
		pObj.load(new FileInputStream(rootFolder+ "//src//test//resources//app.properties"));
		
		//Enter Email from properties file
		emailField.sendKeys(pObj.getProperty("email"));
		
		//Enter Password from properties file
		passwordField.sendKeys(pObj.getProperty("password"));
		
		//Click on Login button
	     loginButton.click();
		
		// Wait for some time for the page to Load
		Thread.sleep(34000);
		
		//Click on Login button again
		loginButton.click();
		Thread.sleep(5000);
		
		
	}

}
