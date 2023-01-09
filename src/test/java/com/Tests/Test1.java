package com.Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

public class Test1 {
	
	WebDriver driver;
	
  @BeforeMethod
  public void LaunchApp() {
		
		driver=new ChromeDriver();
		driver.get("https://www.myntra.com/login/password");
	}
  
  @AfterMethod
  public void tearDown() {
	  
	  driver.quit();
  }
  
  
  @Test
  public void verifyLoggedInUsername() throws Exception {
	
	  LoginPage loginPage= new LoginPage(driver);
	  HomePage homePage=new HomePage(driver);
	  loginPage.login();
	  homePage.verifyUserName();
	  Assert.assertTrue(homePage.userName.isDisplayed());
	  
	  
	  
  }
  
  /*
  @Test
  public void addToCart() throws Exception {
	  
	 HomePage homePage=new HomePage(driver);
	 LoginPage loginPage= new LoginPage(driver);
	 loginPage.login();
	
		 
		 Thread.sleep(3000);
		 
		 homePage.addToCart();
		 
		 Assert.assertTrue(homePage.items.isDisplayed());
	 
	 
	  
  }*/
}
