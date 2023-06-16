package utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import listeners.TestNGListener;

public class ElementUtils {
	static Logger log  = Logger.getLogger(ElementUtils.class.getName());
	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getText(By locator)
	{
		log.info("Inside get Text Method By Locator ");
		log.info("Locator : " +locator);
		
		String text="";
		
		try
		{
			text=driver.findElement(locator).getText();
			log.info("Element found and Text : " +text);
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found");
			log.error(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e1)
		{
			log.error(e1.getMessage());
			e1.printStackTrace();
		}
		return text;
	}
	public String getText(WebElement element )
	{
		log.info("Inside get Text Method with element ");
		return element.getText();
	}
	
	public boolean isElementDisplayed(By locator, int time)
	{
		log.info("Inside isElementDisplayed");
		log.info("Locator : " +locator);
		log.info("Time :" +time);
		
		boolean flag=false;
		try 
		{
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).isDisplayed();
		log.info("Element is found within time");
		flag= true;
		}
		
		catch(TimeoutException e) 
		{
			log.error("Element is not found within time");
			log.error(e.getMessage());
			e.printStackTrace();
			flag= false;
		}
		catch (NoSuchElementException  e1) 
		{
			log.error("Element not found");
			log.error(e1.getMessage());
			e1.printStackTrace();
			flag=false;		
		}
		catch(Exception e) 
		{
			log.error(e.getMessage());
			e.printStackTrace();
			flag= false;
		}
		return flag;
	}
	
	public List<String> getMenuList(By locator){
	
	List<String> textList = new ArrayList<String>();
	List<WebElement> list = driver.findElements(locator);
	
	for(WebElement e: list) 
	{
		textList.add(e.getText());
	}
	return textList;
	}
	
	//wait
	public boolean waitForPresenceofElement(By locator, int time)
	{
		log.info("Inside waitForPresenceofElement");
		log.info("Locator : " +locator);
		log.info("Time :" +time);
		
		WebDriverWait wait= new WebDriverWait(driver, time);
		
		try
		{
			log.info("Element is not present on the page");
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		}
		catch(TimeoutException e)
		{
			log.error(e.getMessage());
			log.info("Element is not displayed on the page");
			return false;
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
}
