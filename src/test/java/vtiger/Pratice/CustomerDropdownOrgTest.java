package vtiger.Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtillity;
import vtiger.GenericUtility.WebDriverUtility;

public class CustomerDropdownOrgTest {
	@Test
	public void CustomerDropdownOrgTest() throws Throwable{
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtillity putil = new PropertyFileUtillity();
		WebDriverUtility wutil = new WebDriverUtility();
			
		WebDriver driver= null;
		
	//read the data from property file- common data
	String BROWSER = putil.getDataFromPropertyFile("browser");
	String URL = putil.getDataFromPropertyFile("url");
	String USERNAME = putil.getDataFromPropertyFile("username");
	String PASSWORD = putil.getDataFromPropertyFile("password");
	
	//read the data from excel sheet
	String ORGNAME = eutil.getDataFromExcel("Organization", 4, 2)+ jutil.getRandomNumber();
	String CUSTOMER = eutil.getDataFromExcel("Organization", 5, 3);

	//launch the broswer - run act based runtime data- Runtime : polymorphism
	if(BROWSER.equalsIgnoreCase("edgebrowser"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		System.out.println(BROWSER+"---Browser launched");
	}
	else
	{
		System.out.println("invalid Browser name");
	}
	wutil.maximizeWindow(driver);
	wutil.waitForElementToLoad(driver);
	
	driver.get(URL);
	
	//credential
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	
	//create org
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	// Step 6: create Organization
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
	WebElement type = driver.findElement(By.name("accounttype"));
	wutil.handleDropDown(type, CUSTOMER);
			
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	//validation
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
			
	WebElement so = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 wutil.mouseHoverAction(driver, so);
	driver.findElement(By.linkText("Sign Out")).click();
			
	System.out.println("logout succesfully");
			
			
			
			
			
			
			
			
			
			
			
	}

}
