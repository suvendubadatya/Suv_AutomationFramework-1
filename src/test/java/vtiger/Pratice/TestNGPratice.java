package vtiger.Pratice;

import org.testng.annotations.Test;

public class TestNGPratice {

	@Test
	public void CreateCustomer()
	{
		//Assert.fail();//failed script with out any reason
		System.out.println("created Customer");
	}
	
	@Test(dependsOnMethods= "CreateCustomer")
	public void ModifyCustomer()
	
	{
		System.out.println("modify Customer");
	}
	
	@Test(dependsOnMethods= {"CreateCustomer", "ModifyCustomer"})
	public void DeleteCustomer()
	{
		System.out.println("delete Customer");
	}
	
}
