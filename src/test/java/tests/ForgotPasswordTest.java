package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.ForgotPasswordPage;
import page.LoginPage;
import testBase.TestBase;
import utils.Constants;

public class ForgotPasswordTest extends TestBase {

	@Test
	
	public void Verify_Reset_Passwrord()
	{
		LoginPage loginpage= new LoginPage(driver);
		ForgotPasswordPage forgotpage= loginpage.clickForgotPasswordLink();
		Assert.assertEquals(forgotpage.isResetPasswordTextDisplayed(), true);
		String title= forgotpage.getPasswordText();
		Assert.assertEquals(title, Constants.RESET_PASSWORD_PAGE_HEADER);
		
		forgotpage.enterUsername("test");
		forgotpage.clickButton("reset");
		Assert.assertEquals(forgotpage.isResetPasswordTextDisplayed(), true);
		title= forgotpage.getPasswordText();
		Assert.assertEquals(title, Constants.RESET_PASSWORD_TEXT);
		
		//Open browser
		//open URL
		//click on forgot password link
		//enter username
		//click on the reset password button
		//reset password successfully created message should be displayed
	}
}
