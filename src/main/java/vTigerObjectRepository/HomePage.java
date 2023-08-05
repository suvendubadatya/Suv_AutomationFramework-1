package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstatorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 4 : Utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getAdminstatorImg() {
		return AdminstatorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Library
	
	public void clickOnOrgLink()
	{
		OrganizationsLnk.click();
	}
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}
	
	public void logOutApp(WebDriver driver) throws Throwable  
	{		
		mouseHoverAction(driver, AdminstatorImg );
		Thread.sleep(2000);
		SignOutLnk.click();
	}

	
	
	
	
}
