package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//div[@class='desktop-userIconsContainer']")
	private WebElement profileIcon;
	
	@FindBy(xpath="//a[@data-track='edit_profile']")
	private WebElement myData;
	
	@FindBy(xpath="//div[text()='Preeti '] ")
	public WebElement userName;
	
	@FindBy(xpath="//span[text()='Bag']")
	private WebElement bagIcon;
	
	@FindBy(xpath="//div[text()='Hey, it feels so light!']")
	private WebElement emptyCartMessage;
	
	@FindBy(xpath="//input[@class='desktop-searchBar']")
	private WebElement searchBar;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	private WebElement product;
	
	@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")
	private WebElement searchIcon;
	
	@FindBy(xpath="(//a[.='MOVE TO BAG'])[1]")
	private WebElement addToBagButton;
	
	@FindBy(xpath="//div[text()='DressBerry']")
	public WebElement items;
	
	public void verifyUserName() {
		
		profileIcon.click();
		myData.click();
		
	}
	
	public void verifyEmptyBag() throws Exception {
		
		bagIcon.click();
		Thread.sleep(3000);
		
		//return (emptyCartMessage.isDisplayed());
		
	}
	
	public void addToCart() throws Exception {
		
		searchBar.sendKeys("Redmi");
		searchIcon.click();
		Thread.sleep(3000);
		product.click();
		Thread.sleep(3000);
		ArrayList<String> wind=new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(wind.get(1));
		
		//addToBagButton.click();
		//bagIcon.click();
	    driver.findElement(By.xpath("//body/div[@id='mountRoot']/div/div/main[@class='pdp-pdp-container']/div[@class='pdp-details common-clearfix']/div[@class='pdp-description-container']/div/div[2]/div[1]/div[1]")).click();
	    Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Bag']")).click();
		Thread.sleep(3000);
		
		
		
		
		
	}

}
