package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		
		emailField.sendKeys(pObj.getProperty("email"));
		passwordField.sendKeys(pObj.getProperty("password"));
		loginButton.click();
		Thread.sleep(34000);
		loginButton.click();
		Thread.sleep(5000);
		
		
	}

}
