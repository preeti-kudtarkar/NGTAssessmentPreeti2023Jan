package com.Tests;


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
	HomePage homePage;
	LoginPage loginPage;
	
  @BeforeMethod
  public void launchApp() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/login/password");
		loginPage= new LoginPage(driver);
		homePage=new HomePage(driver);
	}
  
  @AfterMethod
  public void tearDown() {
	  
	  driver.quit();
  }
  
  
  @Test
  public void verifyLoggedInUsername() throws Exception {
	
	  
	  loginPage.login();
	  homePage.verifyUserName();
	  Assert.assertTrue(homePage.userName.isDisplayed());
	  
	  
	  
  }
  
  
  @Test
  public void addToCart() throws Exception {
	  
	     //login
	     loginPage.login();
	     
	     //Get status of the cart
		 boolean status=homePage.verifyEmptyBag();
		 
		 //navigate back to Home Page
		 driver.navigate().back();
		 
		 //If Cart status is Empty add item to cart
		 if(status==true) {
		 Thread.sleep(3000);
		 
		 homePage.addToCart();
		 
		 Assert.assertTrue(homePage.items.isDisplayed());
		 }
		 
		 // If Cart not Empty print the message
		 else
		 {
			 System.out.println("There are items in the cart");
		 }
	 
	 
	  
  }
}
