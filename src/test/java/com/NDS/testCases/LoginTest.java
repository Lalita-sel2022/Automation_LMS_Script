package com.NDS.testCases;

import org.testng.annotations.Test;

import com.NDS.Utility.BaseClass;
import com.NDS.pageObject.CaseEventListPage;
import com.NDS.pageObject.HomePage;
import com.NDS.pageObject.LoginPage;


public class LoginTest extends BaseClass
{
//	public WebDriver driver;
	@Test
	public void setup() throws InterruptedException
	{
		
        driver.get(prop.getProperty("url"));
        LoginPage lp= new LoginPage(driver);
        lp.login();
        Thread.sleep(2000);
        HomePage hp= new HomePage(driver);
        hp.clickOnMenu();
        
        CaseEventListPage c= new CaseEventListPage(driver);
       int count = 0;
	   c.selectEntityDropdown(count);
        
//        System.out.println("count  _:"+count);
//        c.selectEvent(count);

        
        
        
     
       
        
	}

}
