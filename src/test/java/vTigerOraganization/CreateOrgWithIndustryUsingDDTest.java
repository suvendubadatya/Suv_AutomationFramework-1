package vTigerOraganization;
import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectRepository.CreateNewOrganizationPage;
import vTigerObjectRepository.HomePage;
import vTigerObjectRepository.LoginPage;

import vTigerObjectRepository.OrgnizationsPage;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtillity;
import vtiger.GenericUtility.WebDriverUtility;

public class CreateOrgWithIndustryUsingDDTest extends BaseClass{
		
		@Test(groups= "SmokeSuite")
		public void CreateOrgWithIndustryUsingDDTest() throws Throwable {
	
	//read the data from excel sheet
	String ORGNAME = eutil.getDataFromExcel("Organization", 4, 2)+ jutil.getRandomNumber();
	String INDUSTRY = eutil.getDataFromExcel("Organization", 4, 3);

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
	String OrgHead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHead.contains(ORGNAME))
	{
		System.out.println("pass");
		System.out.println(OrgHead);
	}
	else
	{
		System.out.println("fail");
	}
	//Step 9: Logout of Application
	
	
	}

}
