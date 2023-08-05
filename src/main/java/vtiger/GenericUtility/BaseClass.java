package vtiger.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectRepository.HomePage;
import vTigerObjectRepository.LoginPage;
/**
 * this class consist of all the basic configuration annotation for all the common action
 * 
 * @author suvendu
 *
 */
public class BaseClass {
	
	//
	public JavaUtility jutil = new JavaUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public PropertyFileUtillity putil = new PropertyFileUtillity();
	public WebDriverUtility wutil = new WebDriverUtility();
	
	public WebDriver driver= null;
	
	//Only used for listener to take screenshot
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"SmokeSuite", "RegressionSuite"})
	public void bsConfig()
	{
		
		System.out.println("=====   DB connection start ======");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun= true)
	public void bcConfig(String Browser) throws Throwable
	{
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String URL = putil.getDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("edgebrowser"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
			System.out.println(BROWSER+"  ===  Browser launched  ===  ");	
		}
		else
		{
			System.out.println("  ===  invalid Browser name  ===  ");
		}
		wutil.maximizeWindow(driver);	
		wutil.waitForElementToLoad(driver);
		
		//only used for listener to take screenshot
		sdriver=driver;
		
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun= true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("  ===  Login Successfull  ===  ");
	}
	
	@AfterMethod(alwaysRun= true)
	public void amConfig() throws Throwable
	{
		HomePage hp= new HomePage(driver);
		hp.logOutApp(driver);
		
		System.out.println("  ===  Login failed  ===  ");
	}
	
	@AfterClass(alwaysRun= true)
	public void acConfig()
	{
	driver.close();
	System.out.println(" ===  Browser closed  === ");
	}

	@AfterSuite(alwaysRun= true)
	public void asConfig()
	{
		System.out.println("=====   DB connection closed ======");
	}
}
