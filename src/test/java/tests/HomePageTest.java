package tests;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.TestNGListener;
import page.HomePage;
import page.LoginPage;
import testBase.TestBase;
import utils.Constants;
import utils.ExcelReader;

public class HomePageTest extends TestBase {
	static Logger log  = Logger.getLogger(HomePageTest.class.getName());
	@Test
	
	public void verify_Username() throws InterruptedException
	{
		LoginPage page = new LoginPage(driver);
		
		//To read the credentials from Excel file
//		ExcelReader cred = new ExcelReader("credentials.xlsx");
//		Map<String, String> credmap = cred.getDataInMap(1);
//		HomePage hp = page.doLogin(credmap.get("Username"),credmap.get("Password"));
		//To read the credentials from properties file
		
		HomePage hp = page.doLogin(prop.get("username1").toString(), prop.get("password").toString());
		String actualHeader= hp.getHeader();
		log.info("Home page header Assertion");
		log.info("Actual header : " +actualHeader);
		log.info("Expected header : " +Constants.HOME_PAGE_HEADER);
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_HEADER);
		
		String username=hp.getUsername();
		Thread.sleep(3000);
		log.info("Home page username Assertion");
		log.info("Actual header : " +actualHeader);
		log.info("Expected header : " +Constants.USERNAME);
		Assert.assertEquals(username, Constants.USERNAME);
	}
	
	@Test
	public void Verify_Links()
	{	
		LoginPage page = new LoginPage(driver);
		HomePage hp = page.doLogin("Admin","admin123");
		String actualHeader= hp.getHeader();
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_HEADER);
		
		List<String> actualList=hp.getMenuList();
		
		SoftAssert softAssert= new SoftAssert();
		for(int i=0; i<actualList.size(); i++) 
		{				
			String actual = actualList.get(i);
			String expected = Constants.HOME_PAGE_MENULIST.get(i);
			System.out.println("Expected :" + i + " " +expected);
			System.out.println("Actual :" + i + " " +actual);

			softAssert.assertEquals(actual, expected);
		}
		
		softAssert.assertAll();
	}
}
