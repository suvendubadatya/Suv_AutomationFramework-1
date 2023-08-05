package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provide implementation the ITestlistener interface of test ng 
 * Example for abtraction
 * @author suvendu
 *
 */
public class ListenerImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("------- execution started------"+methodName);
		
		test= report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		//System.out.println("-----pass----"+methodName);
		
		test.log(Status.PASS, "-----pass----"+methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName= result.getMethod().getMethodName();
		System.out.println("-----fail----"+methodName);
		
		test.log(Status.FAIL, "-----fail----"+methodName);
		
		
		//System.out.println(result.getThrowable());
		
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();
		
		String screenshotName= methodName+ju.getSystemDateFormat();
	
	//Take screenshot for failed tests scripts- to attach Bug rising 
	try {
		String path= wu.takesScreenShot(BaseClass.sdriver, screenshotName);
		test.addScreenCaptureFromPath(path);
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName= result.getMethod().getMethodName();
		System.out.println("-----skip----"+methodName);
		
		test.log(Status.SKIP, "-----skip----"+methodName);
	
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// Start of <suite>- @Beforesuite
		System.out.println("suite execution started ");
		
		//configure the extent report
		ExtentSparkReporter htmlreport= new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateFormat()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setReportName("Build 3 Vtiger Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		
		//Report Generation
		 report =  new ExtentReports();
		 report.attachReporter(htmlreport);
		report.setSystemInfo("Base BRowser", "Chrome");
		report.setSystemInfo("Base Platform ", "Testing- Env");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter", "Suvendu");
		
		
	}

	public void onFinish(ITestContext context) {
		// Start of <suite>- @Aftersuite
		
		System.out.println(" suite execution ended");
		
		//Report Generation
		 report.flush();
		
		
		
	}
	
	
	
	
	
	
	
	
}
