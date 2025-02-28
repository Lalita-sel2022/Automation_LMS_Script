package com.NDS.pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NDS.Utility.BaseClass;

public class CaseEventListPage extends BaseClass
{
	
	public CaseEventListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\"filter-option-inner-inner\"]")
	WebElement entityDropdown;
	
	@FindBy(xpath="//div[@id=\"bs-select-1\"]/ul/li")
	public List<WebElement> enityElements;
	
	@FindBy(xpath="(//div[@class=\"filter-option-inner\"])[2]")
	WebElement caseDropdown;
	
	@FindBy(xpath="(//div[@class=\"inner show\"])[2]/ul/li")
	public List<WebElement> caseElement;
	
	@FindBy(xpath="//button[@id=\"show_events\"]")
	WebElement showButton;
	
	@FindBy(xpath="//ul[@id=\"filter_ul\"]/li/label/a")
	public List<WebElement>  openEventList;
	
	@FindBy(xpath="//ul[@id=\"filter_ul\"]/li/label/a/span")
	public List<WebElement> eventListCount;
	
	
	
	
	public void selectEntityDropdown(int entityCount) throws InterruptedException
	{
		int nextCase=0;
		int currectEntityCount=1;
		int count = 0;
		
		if(entityCount>=2)
		{
			currectEntityCount=entityCount;
		}
		entityDropdown.click();
		 // Select an entity and click on each case for that entity
		for (int i = 1; i <=enityElements.size(); i++) 
		{
			
			if(i>=currectEntityCount)
			{
		     WebElement entity = enityElements.get(i); // Get the entity at index i
		    
		    System.out.println("\nOpening Entity: " + entity.getText());
		    entity.click();
             count= selectCase(nextCase);
             System.out.println("Count  In pageObject:"+count);
             // Click on cases for the current entity
//            if(caseElement.size()>0)
//            {
//            	selectCase(nextCase);
//            	Thread.sleep(2000);
            	showButton.click();
//            	
//            }
            	
		}

            
        }
		selectEvent(count);
		
		
	
	}
	
	public int selectCase(int nextCaseCount) throws InterruptedException
	{
		int caseCount=1;
		if(nextCaseCount!=0)
		{
			caseCount=nextCaseCount;
		}
		
		Thread.sleep(2000);
		caseDropdown.click(); // Open the case dropdown
        System.out.println("Opened Case Dropdown");

        for (int i = 1; i < caseElement.size(); i++) 
        {
        	if(i>=caseCount)
        	{
            WebElement caseItem = caseElement.get(i); // Get the case item at index i
            
            // Ensure element is clickable
//            waitForElementToBeClickable(caseItem);
            
            caseItem.click(); // Click on each case
            // Optional: Add delay between each click to see the action
            Thread.sleep(2000);
            System.out.println("Selected Case: " + caseItem.getText());

           
        }else
        {
        	int entityCount =2;
        	selectEntityDropdown(entityCount);
        }
        	
        }
		return caseCount;
		
	}
	
	public void selectEvent(int caseCount) throws InterruptedException

	{

	    for(int j = 1; j < openEventList.size(); j++)

	    {

	        WebElement eventEle = openEventList.get(j);

//	        WebElement eventCount = eventListCount.get(j);

	        // Thread.sleep(2000);

	        // System.out.println("Events Count :" + eventCount.getText());

	        // System.out.println("Events Count :" + eventCount.getText());

//	        String eventCountNoString = eventCount.getText();
//
//	        // Convert the event count to an integer
//
//	        int eventCountNo = Integer.parseInt(eventCountNoString);
//	 
//	        if (eventCountNo > 0) { // Assuming you want to click if the count is greater than 0

	            eventEle.click();

	            Thread.sleep(5000);

	        }
	    driver.navigate().back();

	    }

//	    int nextCount = caseCount + 1;
//
//	    selectCase(nextCount);

	}

	 

//	private WebDriverWait wait;
//
//    public CaseEventListPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    @FindBy(xpath = "//div[@class=\"filter-option-inner-inner\"]")
//    WebElement entityDropdown;
//
//    @FindBy(xpath = "//div[@id=\"bs-select-1\"]/ul/li")
//    public List<WebElement> enityElements;
//
//    @FindBy(xpath = "(//div[@class=\"filter-option-inner\"])[2]")
//    WebElement caseDropdown;
//
//    @FindBy(xpath = "(//div[@class=\"inner show\"])[2]/ul/li")
//    public List<WebElement> caseElement;
//
//    @FindBy(xpath = "//button[@id=\"show_events\"]")
//    WebElement showButton;
//
//    @FindBy(xpath = "//ul[@id=\"filter_ul\"]/li")
//    public List<WebElement> eventList;
//
//    // Method to select entity and iterate through cases and events
//    public void processEntities() throws InterruptedException {
//        entityDropdown.click();
//
//        for (int i = 0; i < enityElements.size(); i++) {
//            WebElement entity = enityElements.get(i);
//            System.out.println("\nOpening Entity: " + entity.getText());
//            waitForElementToBeClickable(entity).click();
//
//            if (caseElement.size() > 0) {
//                selectCaseAndEvents();
//            } else {
//                System.out.println("No cases available for this entity.");
//            }
//        }
//    }
//
//    // Method to select each case and process events
//    public void selectCaseAndEvents() throws InterruptedException {
//        caseDropdown.click();
//        System.out.println("Opened Case Dropdown");
//
//        for (int i = 0; i < caseElement.size(); i++) {
//            WebElement caseItem = caseElement.get(i);
//            waitForElementToBeClickable(caseItem).click();
//            System.out.println("Selected Case: " + caseItem.getText());
//
//            showButton.click();
//            waitForEventsAndProcess();
//        }
//    }
//
//    
//    // Method to process events for a case
//    public void waitForEventsAndProcess() throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOfAllElements(eventList));
//
//        for (int j = 0; j < eventList.size(); j++) {
//            WebElement eventEle = eventList.get(j);
//            waitForElementToBeClickable(eventEle).click();
//            System.out.println("Processing Event: " + eventEle.getText());
//
//            // TODO: Add logic to update event data here
//
//            Thread.sleep(2000); // Wait after updating each event
//        }
//    }
//    
//
//    // Utility method for explicit waits
//    public WebElement waitForElementToBeClickable(WebElement element) {
//        return wait.until(ExpectedConditions.elementToBeClickable(element));
//    }


	



