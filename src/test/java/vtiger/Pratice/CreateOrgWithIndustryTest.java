package vtiger.Pratice;

import java.util.Random;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateOrgWithIndustryTest {
	@Test
	public void CreateOrgWithIndustryTest(){
		
		//driver start
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//random class
		Random r= new Random();
		int random = r.nextInt(1000);
		
		//URl
		driver.get("http://localhost:8888/");
		
		//credential
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//create org
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//use random for multiple org created
		String orgName = "L&T"+random;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		//select industry
		WebElement Idp = driver.findElement(By.name("industry"));
		Select s= new Select(Idp);
		s.selectByValue("Chemicals");
			
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation
		String OrgHead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHead.contains(orgName))
		{
			System.out.println("pass");
			System.out.println(OrgHead);
		}
		else
		{
			System.out.println("fail");
		}
		
		//Step 9: Logout of Application
		WebElement so = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(so).perform();
		

		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("logout succesfully");
		
		
		
		

	}
	@Test
	public void demotest()
	{
		Assert.fail();
		System.out.println("demo");
	}
}
