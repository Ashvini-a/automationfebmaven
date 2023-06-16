package page;

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
import org.testng.annotations.BeforeMethod;

import utils.ElementUtils;

public class LoginPage {
	static Logger log  = Logger.getLogger(LoginPage.class.getName());
	WebDriver driver;
	ElementUtils elementUtils;
	//Page element
	private By name= By.name("username");
	private By pass= By.name("password");
	private By LoginButton= By.tagName("button");
	private By invalidMsgSection= By.xpath(("//div[contains(@class,'oxd-alert--error')]"));
	private By invalidMsgElement= By.xpath(("//div[contains(@class,'oxd-alert--error')]//p"));
	private By loginPageTitle= By.xpath("//h5[contains(@class,'orangehrm-login-title')]");
	private By forgotPasswordLink= By.xpath("//p[contains(@class,'orangehrm-login-forgot-header')]");

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
	}

	//page actions
	public HomePage doLogin(String user, String password) 
	{
		log.info("Inside doLogin method");
		log.info("Entering username");
		driver.findElement(name).sendKeys(user);
		log.info("Entering password");
		driver.findElement(pass).sendKeys(password);
		log.info("clicking on login button");
		driver.findElement(LoginButton).click();
		return new HomePage(driver);
	}
	public boolean is_invalid_cred_msg_displayed()
	{
		log.info("Inside is_invalid_cred_msg_displayed Method");
		return elementUtils.isElementDisplayed(invalidMsgElement, 5);
	}
		public String getInvalidCredMsg()
		{
			log.info("Inside getInvalidCredMsg Method");
			return elementUtils.getText(invalidMsgElement);
		}
		
		public String getTitle() 
		{
			return elementUtils.getText(loginPageTitle);
		}
		
		public boolean isElementPresent(String element) {
		log.info("Inside isElementPresent Method");
		log.info("Element : " +element);
		boolean actual=false;
		By webelement =null;
		
		if(element.equals("username")) {
			webelement=name;
		}
		
		else if(element.equals("password")) {
			webelement=pass;
		}
		
		else if(element.equals("LoginButton")) {
			webelement=LoginButton;
		}
		
		return elementUtils.isElementDisplayed(webelement, 7);
		}
		
		public ForgotPasswordPage clickForgotPasswordLink() 
		{
			log.info("Inside clickForgotPasswordLink Method");
			driver.findElement(forgotPasswordLink).click();
			return new ForgotPasswordPage(driver);		
		}
}
