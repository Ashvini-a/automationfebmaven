package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener 
{
	static Logger log  = Logger.getLogger(TestNGListener.class.getName());

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("-------------------------------------------------------------------------");
		log.info("Execution started for Testcase : " +result.getMethod().getMethodName());
		log.info("-------------------------------------------------------------------------");
		System.out.println("onTestStart :" +result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getMethod().getMethodName() + " : PASS");
		System.out.println("onTestSuccess :" +result.getMethod().getMethodName());
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getMethod().getMethodName() + " : FAIL");
		System.out.println("onTestFailure :" +result.getMethod().getMethodName());
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped :" +result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage :" +result.getMethod().getMethodName());
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedWithTimeout :" +result.getMethod().getMethodName());
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("-------------------------------------------------------------------------");
		log.info("Execution started ");
		log.info("-------------------------------------------------------------------------");
		System.out.println("onStart :"+context.getStartDate());
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("-------------------------------------------------------------------------");
		log.info("Execution finished ");
		log.info("-------------------------------------------------------------------------");
		System.out.println("onFinish :" +context.getEndDate());
	}
	
}
