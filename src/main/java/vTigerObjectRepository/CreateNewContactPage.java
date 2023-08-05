package vTigerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
@FindBy(name= "lastname")
private WebElement LastNameEdt;

@FindBy(xpath= "//input[@title='Save [Alt+S]']")
private WebElement SaveBtn;

@FindBy(xpath= "//input[@name='account_name']/following-sibling::img[@title='Select']")
private WebElement OrgLookUpImg;

@FindBy(name= "search")
private WebElement OrgSearchEdt;

@FindBy(name= "search")
private WebElement OrgSearchBtn;

public CreateNewContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getLastNameEdt() {
	return LastNameEdt;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

public WebElement getOrgLookUpImg() {
	return OrgLookUpImg;
}

public WebElement getOrgSearchEdt() {
	return OrgSearchEdt;
}

public WebElement getOrgSearchBtn() {
	return OrgSearchBtn;
}

//business Library
public void CreateContact(String LASTNAME)
{
	LastNameEdt.sendKeys(LASTNAME);
	SaveBtn.click();
}
public void CreateContact(WebDriver driver, String LASTNAME, String ORGNAME)
{
	LastNameEdt.sendKeys(LASTNAME);
	OrgLookUpImg.click();
	switchToWindow(driver, "Accounts");
	OrgSearchEdt.sendKeys(ORGNAME);
	OrgSearchBtn.click();
	driver.findElement(By.xpath("//a[text()='\"+ ORGNAME +\"']")).click();
	switchToWindow(driver, "Contacts");
	SaveBtn.click();
}





}
