package vTigerOraganization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtillity;
import vtiger.GenericUtility.WebDriverUtility;

public class ContactWithOpp {

	public static void main(String[] args) throws Throwable {
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtillity putil = new PropertyFileUtillity();
		WebDriverUtility wutil = new WebDriverUtility();
			
		WebDriver driver= null;
		
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String URL = putil.getDataFromPropertyFile("url");
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
	
		String ORGNAME = eutil.getDataFromExcel("Opportunity ", 1, 2);
		String CONTACTS = eutil.getDataFromExcel("Opportunity ", 1, 3);

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
		
		driver.findElement(By.linkText("Opportunities")).click();
		
		//create org
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		
		// Step 6: create Organization
				driver.findElement(By.name("potentialname")).sendKeys(ORGNAME);
				
				WebElement type = driver.findElement(By.name("related_to_type"));
			//	wutil.handelDropdrop(type, CONTACTS);
				
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
	
		wutil.getWindowHandel(driver, "Contacts");
		
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		
		driver.findElement(By.name("search")).click();
		
	//	driver.findElement(By.xpath(""))
		
		
	
	
	
	
	
	
	
	
	
	
	}

}
