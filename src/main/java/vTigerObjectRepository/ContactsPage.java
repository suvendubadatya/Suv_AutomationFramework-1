package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(linkText= "Contacts")
	private WebElement ContactTxt;
	
	@FindBy(xpath= "//img[@title='Create Contact...']")
	private WebElement ClickOnContactLookUpImage;

	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactTxt() {
		return ContactTxt;
	}

	public WebElement getClickOnContactLookUpImage() {
		return ClickOnContactLookUpImage;
	}

	//business library
	public void ClickOnContactLookUpImage()
	{
		ContactTxt.click();
		ClickOnContactLookUpImage.click();
		
	}
}
