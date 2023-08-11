package vtiger.contactTest;

import org.openqa.selenium.By;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vTigerObjectRepository.ContactInfoPage;
import vTigerObjectRepository.ContactsPage;
import vTigerObjectRepository.CreateNewContactPage;
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
@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateContactWithOrganisationTest extends BaseClass{
	
	
	@Test 
	
	public void  CreateContactWithOrganisationTest() throws Throwable{

	//read the data from excel sheet
	String ORGNAME = eutil.getDataFromExcel("Contacts", 4, 3)+ jutil.getRandomNumber();
	String LASTNAME = eutil.getDataFromExcel("Contacts", 4, 2);

	//Step 5. Click on organization link
	HomePage hp= new HomePage(driver);
	hp.clickOnOrgLink();
	Reporter.log("OrgLink Clicked");
	
	//Step 6. create organization lookup img
	OrgnizationsPage op= new OrgnizationsPage(driver);
	op.ClickOnCreateOrgLookUpImg();
	
	//Step 7 create organization 
	CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
	cnop.CreateOrganization(ORGNAME);
	
	//Step 8 validation
	OrganizationInfoPage oip= new OrganizationInfoPage(driver);
	String OrgHead = oip.getHeadertext();
	Assert.assertTrue(OrgHead.contains(ORGNAME));
	System.out.println(OrgHead);
	
	//create contact using organisation
	
	//step 9 click on contact link update 
	hp.clickOnContactsLink();
		
	//Step 10 navigate to create contact to look up image  
	ContactsPage cp= new ContactsPage(driver);
	cp.ClickOnContactLookUpImage();
		
	//Step 11 create a contact with mandatory information 
	CreateNewContactPage cnopp= new CreateNewContactPage(driver);
	cnopp.CreateContact(driver, LASTNAME, ORGNAME);
	
	//Step 12 
	ContactInfoPage cip= new ContactInfoPage(driver);
	String conHead = cip.getContactHeader();
	Assert.assertTrue(conHead.contains(LASTNAME));
	System.out.println(conHead);
	}
	
	
	@Test
	public void demotest()
	{
		Assert.fail();
		System.out.println("demo");
	}
}
