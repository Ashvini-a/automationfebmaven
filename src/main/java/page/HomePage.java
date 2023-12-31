package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	By username= By.className("oxd-userdropdown-name");
	By header= By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]");
	By menuLinks=By.xpath("//ul[contains(@class,'oxd-main-menu')]//span[contains(@class,'oxd-main-menu-item--name')]");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
	}
	
	public String getHeader()
	{
		if(elementUtils.waitForPresenceofElement(header, 5))
		{
			return elementUtils.getText(header); 
		}
		else
		{
			return "";
		}
	}
	
	public String getUsername()
	{
		return elementUtils.getText(username);
		
	}
	
	public List<String> getMenuList()
	{
		return elementUtils.getMenuList(menuLinks);
	}
}

