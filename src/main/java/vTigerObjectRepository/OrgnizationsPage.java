package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationsPage {
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	

	//initialization
	public OrgnizationsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	//Business library
	public void ClickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}

	
	
	
	
	
	
	
	
}
