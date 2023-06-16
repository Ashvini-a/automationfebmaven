package t1_orangeHrm25052023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameworkbaseEx5_orghrm {

	@Test
	public void Enter_Username_Field() {
				
	System.setProperty("webdriver.chrome.driver", "C:\\Automation-Selenium\\Setup -selenium\\chrome113\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	WebDriverWait wait= new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	
	boolean actualUserName;
	
	try {
	actualUserName= driver.findElement(By.name("username")).isDisplayed();
	}
	
	catch(NoSuchElementException e) {
		actualUserName=false;
	}
	
	catch(Exception e1) {
		actualUserName=false;

	}
	boolean expected=true;
	
	Assert.assertEquals(actualUserName, expected);
	}
}
