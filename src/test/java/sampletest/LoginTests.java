package sampletest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests {
	
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation-Selenium\\Setup -selenium\\chrome113\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tool2.tdittesting.in/login.php");
	}
	
	@Test
	public void Verify_Login_Page_Title()
	{
		String expectedText="User Login";
		WebElement title= driver.findElement(By.tagName("h2"));
		String actualText=title.getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test
	public void Verify_Login_Page_Header()
	{
		String expectedText="TDIT Solutions";
		WebElement title= driver.findElement(By.tagName("h1"));
		String actualText=title.getText();
		Assert.assertEquals(actualText, expectedText);
	}
	@Test
	public void Verify_UserName_field()
	{
		boolean actualUserName= driver.findElement(By.name("username")).isDisplayed();
		boolean expectedUserName=true;
		Assert.assertEquals(actualUserName, expectedUserName);
	}
	
	@Test
	public void Verify_Password_field()
	{
		boolean actualPass;
		
		try {
			
		actualPass= driver.findElement(By.name("password")).isDisplayed();
		}
		
		catch(NoSuchElementException e) 
		{
			actualPass=false;
		}
		catch(Exception e1)
		{
			actualPass=false;
		}
		boolean expectedPass=true;
		Assert.assertEquals(actualPass, expectedPass, "Password field is not displayed");
	}
		@Test
		public void Verify_Error_on_Incorrect_Credentials()
		{
			String expected="No such User exists. Invalid Credentials";
			
			driver.findElement(By.name("username")).sendKeys("test");
			driver.findElement(By.name("password")).sendKeys("Test");
			driver.findElement(By.className("login_button")).click();
			
			WebDriverWait wait= new WebDriverWait(driver,5);

			Alert alert= driver.switchTo().alert();
			String actual="";
			
			try {
			wait.until(ExpectedConditions.alertIsPresent());
			actual= alert.getText();
			alert.accept();		
			}
			catch(NoSuchElementException e) {
				Assert.assertTrue(false, "Message is not displayed");
			}
				
			catch(Exception e1)
			{
				Assert.assertTrue(false, "text is not present");
			}
			Assert.assertEquals(actual, expected, "error message is not displayed");
		}
		@AfterMethod
		public void afterMethod()
		{
			driver.quit();

		}
}
