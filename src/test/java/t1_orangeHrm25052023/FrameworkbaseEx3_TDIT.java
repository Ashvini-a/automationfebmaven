package t1_orangeHrm25052023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameworkbaseEx3_TDIT {
	
	@Test
	
	public void Verify_Login_Page_Header() {
	
	String expectedResult="User Login";
	
	System.setProperty("webdriver.chrome.driver", "C:\\Automation-Selenium\\Setup -selenium\\chrome113\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
		
	driver.get("https://tool2.tdittesting.in/login.php");
	
	WebDriverWait wait= new WebDriverWait(driver,10);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
	    
	WebElement header= driver.findElement(By.tagName("h2"));
	
	String actualResult= header.getText();
		
	Assert.assertEquals(actualResult, expectedResult);
	
	}
}
