package com.NDS.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NDS.Utility.BaseClass;

public class LoginPage extends BaseClass
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement usernameField;
	
	@FindBy(id="password")
	public WebElement passField;
	
	@FindBy(id="captcha")
	public WebElement captchaField;
	
	@FindBy(name="sign_in")
	public WebElement loginButton;
	
	@FindBy(id="newCaptcha")
	public WebElement captchafield;
	
	@FindBy(id="captcha")
	public WebElement captchaDestinationField;
	
	@FindBy(id="verify_otp")
    public WebElement verifyOTPButton;
	
	@FindBy(id="validate_otp")
	public WebElement otpField;
	
	
	public void login() throws InterruptedException
	{
		System.out.println(prop.getProperty("username"));
		usernameField.sendKeys(prop.getProperty("username"));
		passField.sendKeys(prop.getProperty("Pass"));
		
		
		Actions action= new Actions(driver);
		action.doubleClick(captchafield).perform();
		 // Copy (Ctrl + C)
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		 // Click on the destination field
		captchaDestinationField.click();

		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		String copiedText = captchaDestinationField.getAttribute("value");
        System.out.println("Copied Text: " + copiedText);
        loginButton.click();
        
        

	}
	
	public void verifyOTP()
	{
		otpField.sendKeys("5678");
        verifyOTPButton.click();
	}
}
