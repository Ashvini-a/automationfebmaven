package t1_orangeHrm25052023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameworkbaseEx2_OrangeHrm {

	@Test
	
	public void test() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation-Selenium\\Setup -selenium\\chrome113\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		boolean expectedResult=true;
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-branding']/img")));
		
		WebElement webLogo= driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/img"));
		
		boolean actualResult= webLogo.isDisplayed();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
