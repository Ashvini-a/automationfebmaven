package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class ForgotPasswordPage{
	
	WebDriver driver;
	ElementUtils elementUtils;
	//page element
	
	By username= By.name("username");
	By cancelButton= By.xpath("//button[contains(@class,'cancel')]");
	By resetPassButton= By.xpath("//button[contains(@class,'reset')]");
	By resetPasswordText=By.tagName("h6");
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);

	}
	
	//page action
	
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void clickButton(String button) {
		if(button.equals("cancel")) 
		{
			driver.findElement(cancelButton).click();
		}
		
		else if(button.equals("reset")) {
			driver.findElement(resetPassButton).click();
		}
	}
		public boolean isResetPasswordTextDisplayed() {
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			boolean flag= false;
			
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(resetPasswordText));
				driver.findElement(resetPasswordText);
				flag=true;
				}
			catch(NoSuchElementException e) {
				flag=false;
				}
			catch(Exception e) {
				flag=false;
			}
			return flag;
			}
		
		public String getPasswordText() {
			return driver.findElement(resetPasswordText).getText();
			
		}
}
