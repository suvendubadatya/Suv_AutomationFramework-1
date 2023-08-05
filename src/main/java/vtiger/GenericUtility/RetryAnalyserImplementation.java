package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this method provides implementation for ITestAnalyser interface
 * @author suvendu
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=1;
	int retryCount =3;
	
	public boolean retry(ITestResult result) {
		while(count<=retryCount)
		{
			count++;//2 3 4
			return true; //retry retry retry
		}
		return false; // if donot retry
	}
	
	
}
