package vtiger.Pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPratice {

	
	@Test(retryAnalyzer= vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("hi");
	}
}
