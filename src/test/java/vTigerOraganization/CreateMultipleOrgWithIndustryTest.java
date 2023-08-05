
package vTigerOraganization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectRepository.CreateNewOrganizationPage;
import vTigerObjectRepository.HomePage;
import vTigerObjectRepository.LoginPage;
import vTigerObjectRepository.OrganizationInfoPage;
import vTigerObjectRepository.OrgnizationsPage;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtillity;
import vtiger.GenericUtility.WebDriverUtility;

@Test
public class CreateMultipleOrgWithIndustryTest extends BaseClass {
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgTest(String ORG, String INDUSTRY) throws Throwable
	{
	
		//read the data from excel sheet
		String ORGNAME = ORG + jutil.getRandomNumber();

		//Step 2. launch the broswer - run act based runtime data- Runtime : polymorphism
		
		//Step 5. Click on organization link
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Step 6. create organization lookup img
		OrgnizationsPage op= new OrgnizationsPage(driver);
		op.ClickOnCreateOrgLookUpImg();
		
		//Step 7. Create Oraganization
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);
		
		//Step 8. validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeadertext();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("pass");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("fail");
		}
		//Step 9: Logout of Application
		
		
		}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eutil.readMultipleData("MultipleOrg");
	}
}
