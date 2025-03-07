package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;

public class Listeners extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
	}
	
    public void onTestFailed(ITestResult result) {
    	try{
    	Screenshot.screenshot(driver, result.getName());
    	}
    	catch(Exception e) {
    		
    	}
	}
	
    public void onTestSkipped(ITestResult result) {
		
	}

}
