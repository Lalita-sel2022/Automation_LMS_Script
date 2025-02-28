package com.NDS.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath= System.getProperty("user.dir");
	
	@BeforeTest
	public void loadConfig() throws IOException
	{
		prop= new Properties();
		FileInputStream propRead= new FileInputStream(projectPath+"/Configuration/Config.Properties");
		prop.load(propRead);
		String browser = prop.getProperty("chromebrowser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		if(driver!=null)
		{
			driver.close();
		}
	}
	
	}


