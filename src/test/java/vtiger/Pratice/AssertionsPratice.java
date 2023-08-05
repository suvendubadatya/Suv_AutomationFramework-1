package vtiger.Pratice;

import org.stringtemplate.v4.compiler.STParser.mapExpr_return;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPratice {
	@Test
	public void sampleTest()
	{
		int a=1;
		int b=2;
		
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(b, a);
		
		System.out.println("step 3");
		System.out.println("step 4");
		
		System.out.println("Execution and validation complete");
	
	}
	
	@Test
	public void sampleTest1()
	{
		SoftAssert sa = new SoftAssert();
		
		int a=1;
		int b=2;
		
		System.out.println("Step 1");
		
		sa.assertEquals(false, true);	//fail
		
		System.out.println("Step 2");
		
		//Assert.assertEquals(b, a);   //fail
		
		System.out.println("Step 3");

		
		
		System.out.println("Step 4");
		
		sa.assertTrue(false); 	//fail
		
		System.out.println("Execution and validation complete");
		
		sa.assertAll();
		
	}
	
	
	
	
	
}
