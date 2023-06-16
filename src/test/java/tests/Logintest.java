package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.LoginPage;
import testBase.TestBase;

public class Logintest extends TestBase {
	
	static Logger log  = Logger.getLogger(Logintest.class.getName());

	//abstraction concept
	@Test
	public void Verify_Login_Page_Title() {
	
	LoginPage page= new LoginPage(driver);
	String actualResult=page.getTitle();
	//Expected result
	String expectedResult="Login";
	//Assertion or matching actual with expected
	Assert.assertEquals(actualResult, expectedResult);
	}
    
	@Test
	public void Verify_UserName_Field() 
	{
	LoginPage page= new LoginPage(driver);
	boolean actual=page.isElementPresent("username");
			
	Assert.assertEquals(actual, true,"Username field is not displayed");
    }
	
	@Test
	public void Verfiy_Invalid_credentials() 
	{
		String expected = "Invalid credentials";
		LoginPage page= new LoginPage(driver);
		page.doLogin("test", "test");
		
		boolean actual= page.is_invalid_cred_msg_displayed();
		Assert.assertEquals(actual, true);
		
		String msg=page.getInvalidCredMsg();
		Assert.assertEquals(msg, expected,"Error message is not matched");
	}
}
