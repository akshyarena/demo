package Position2.ArenaSuite.testcomponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import position2.arenasuite.resources.ExtentReporter;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentReports extentreport =ExtentReporter.getReportObject();
	ExtentTest test;
	
	@Override
    public void onTestStart(ITestResult result) {
		
		test= extentreport.createTest(result.getMethod().getMethodName());
		
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS, "TEST PASSED");
    	
       
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test.log(Status.FAIL, "Test Failed");
    	test.fail(result.getThrowable());
    	String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
    	
    	
       
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	test.log(Status.SKIP, "Tst Skipped");
    	
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       
    }

    @Override
    public void onStart(ITestContext context) {
    	
        
    }

    @Override
    public void onFinish(ITestContext context) {
    	extentreport.flush();
        
    }
	
	
	

}
