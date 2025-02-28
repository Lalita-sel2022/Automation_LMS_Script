package com.NDS.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NDS.Utility.BaseClass;

public class HomePage extends BaseClass
{
	
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Case_td")
	WebElement caseMenu;
	@FindBy(xpath="//ul[@id=\"Case\"]/li[5]/a")
	WebElement caseEvent;
	
	
	
	
	public void clickOnMenu()
	{
		caseMenu.click();
		caseEvent.click();
	}
	
	
	

}
