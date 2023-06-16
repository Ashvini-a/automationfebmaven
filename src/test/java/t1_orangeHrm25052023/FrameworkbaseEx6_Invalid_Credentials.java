package t1_orangeHrm25052023;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameworkbaseEx6_Invalid_Credentials {
	
	static WebDriver driver;
	
	@BeforeClass
	public void beforeclass() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Automation-Selenium\\Setup -selenium\\chrome113\\chromedriver.exe");
    	driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	    WebDriverWait wait= new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	}
	
	@Test
	public void Verify_UserName() {
	    boolean expectedUname= true;
	    boolean actualUname=driver.findElement(By.name("username")).isDisplayed();
	    Assert.assertEquals(actualUname, expectedUname);// Test case is Passed
	}
	
	@Test
	public void Verify_Password() {
		boolean expectedPass=true;
		boolean actualPass;
		try {
			WebDriverWait wait= new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
			actualPass=driver.findElement(By.name("password")).isDisplayed();
		    }
		
		catch(NoSuchElementException e) {
		actualPass=false;
	    }
		catch(TimeoutException e1) {	
		actualPass=false;
		}
		
		Assert.assertEquals(actualPass, expectedPass, "Password field is not displayed"); //Test case is Pssed	
    }
	
	@AfterClass
	public void afterclass() {
		driver.quit();//close the browser
	}
}
