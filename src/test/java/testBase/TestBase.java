package testBase;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropConfig;
import utils.ScreenshotUtil;

public class TestBase {
	
	protected  WebDriver driver;
	protected static Properties prop;
	
	static Logger log  = Logger.getLogger(TestBase.class.getName());
	@BeforeTest
	public void beforeTest()
	{
		log.info("Inside before test method");
		prop = PropConfig.init_prop("SIT");
		log.info("Properties file is initialized");
		System.out.println("Initializing properties file");
	}
//	@Parameters(value = {"browser"})
	
	@BeforeMethod
//	public void beforemethod(String browser) {
	public void beforemethod() {

		System.out.println("opening browser");
//		System.setProperty("webdriver.chrome.driver", "C:\\Automation-Selenium\\Setup -selenium\\chrome113\\chromedriver.exe");
		
		//open browser
		String browser = prop.getProperty("browser").toString();
		
		if(browser.equals("chrome")) 
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
		
		else if(browser.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else if(browser.equals("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		
		//launch login page url
		System.out.println("Opening URL");
		String url = prop.get("url").toString();
		
		driver.get(url);
		WebDriverWait wait= new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(@class,'orangehrm-login-title')]")));
	
	}
	@AfterMethod
	public void aftermethod(ITestResult result) {
		
    String testcaseName = result.getMethod().getMethodName();
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			
			String fileName = testcaseName + ".png";
			ScreenshotUtil.takeScreenshot(driver, fileName);
		}
		driver.quit();
	}
}
