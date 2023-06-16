package t1_orangeHrm25052023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameworkbaseEx4_OrangeHrm {
		WebDriver driver;
	@BeforeClass
	
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation-Selenium\\Setup -selenium\\chrome113\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
			
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[contains(@class,'orangehrm-forgot-password-title')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'orangehrm-forgot-password-button--reset')]")));
	}
					
		@Test
		public void Verify_Forgot_Password_Header() throws InterruptedException  {
		
		String expectedResult="Reset Password";
		
		WebElement title= driver.findElement(By.xpath("//h6[contains(@class,'orangehrm-forgot-password-title')]"));
		String actualResult=title.getText();
		
		Assert.assertEquals(actualResult, expectedResult);
		}
		
		@Test
		
		public void Verify_Para_Present() {
			
			String expectedResult="Please enter your username to identify your account to reset your password";
			
			WebElement para=driver.findElement(By.xpath("//form/p[contains(@class,'oxd-text--p')]"));
			
			String actualResult=para.getText();
			
			Assert.assertEquals(actualResult, expectedResult);
		}
		
		@Test
		
		public void Verify_Username_Input_Field() {
			
			boolean expected=true;
			
			boolean actual=driver.findElement(By.name("username")).isDisplayed();
			
			Assert.assertEquals(actual, expected);
		}
		
		@Test
		
		public void Verify_Reset_Button() {
			boolean expected=true;
			
			WebElement resetButton=driver.findElement(By.xpath("//button[contains(@class,'orangehrm-forgot-password-button--reset')]"));
			
			boolean actual=resetButton.isEnabled();
			
			Assert.assertTrue(actual);
			resetButton.click();
		}
		
		@AfterClass
		public void afterclass() {
			
			driver.quit();
		}
}
