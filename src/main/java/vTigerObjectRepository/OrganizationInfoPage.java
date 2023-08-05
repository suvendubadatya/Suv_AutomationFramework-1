package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step 4 : Utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//business Library
	/**
	 * this method will capture the header text and return it to caller
	 * @return
	 */
	public String getHeadertext()
	{
		return OrgHeaderText.getText();
	}
	public boolean contains(String oRGNAME) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
