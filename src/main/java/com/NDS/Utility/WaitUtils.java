package com.NDS.Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	public WaitUtils(WebDriver driver, int timeInSecond)
	{
		this.driver=driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
	}
	
	  // Wait until element is clickable
        public WebElement waitForElementToBeClickable(By locator) 
        {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
