package vtiger.GenericUtility;


import java.io.File;


import java.io.IOException;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consists of all the usable methods related to webdriver actions
 * @author suvendu
 * @param <JavascriptExecutor>
 *
 */
public class WebDriverUtility {

	/**
 * maximize the window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * this method is keeps some waits before execution
	 * @param driver
	 */
	
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * this method will wait with web driver is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait w = new WebDriverWait(driver, 0);
		w.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * this method will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will handle drop down by visibleText
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element )
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this method handle the drop and drag action
	 * @param driver
	 * @param SrcElement
	 * @param targetElement
	 */
	
	public void DragAndDrop(WebDriver driver, WebElement SrcElement, WebElement targetElement )
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(SrcElement, targetElement);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickAndhold(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param xoffset
	 * @param yoffset
	 */
	public void mouseAcrosswebPage(WebDriver driver, int xoffset, int yoffset)
	{
		Actions act= new Actions(driver);
		act.moveByOffset(xoffset, yoffset).click().perform();
	}
	/**
	 * this method will scoll the webpages 
	 * @param driver
	 */
	public  void scollAction(WebDriver driver)
	{
		JavascriptExecutor jsetr =(JavascriptExecutor)driver;
		jsetr.executeScript("window.scollBy(o,500)");
	}
	/**
	 * this method will scoll the webpage using locations
	 * @param driver
	 * @param element
	 */
	public void scollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jsetr =(JavascriptExecutor)driver;
		int y= element.getLocation().getY();
		jsetr.executeScript("window.scrollBy(o, "+y+");", "");
		
		// jsetr.executeScript("argument[0].scrollIntoView();",element);
				
	}
	/**
	 * this methods will accept the alert popups
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will dismiss the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();	
	}
	/**
	 * this method will enter tesxt in prompt popups
	 * @param driver
	 * @param text
	 */
	public void sendTextToAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);	
	}
	/**
	 * this method will capture alert messages and return caller
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();	
	}
	/**
	 * this method will handel the frameby name and id value
	 * @param driver
	 * @param nameOrID
	 */
	public void handelFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * this method will handel frame based on web element
	 * @param driver
	 * @param element
	 */
	public void handelframe(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method will help to switch control back to imediate parents
	 * @param driver
	 */
	public void switchToparentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * this method will switch parent to child or child to parent based on partital window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void getWindowHandel(WebDriver driver, String partialWinTitle)
	{	
		// step 1- capture all the window ids	
		Set<String> ah = driver.getWindowHandles();
		
		//step 2: iterate through individual ids
		for (String winID: ah)
		{
			//step 3: switch to each id and capture the title
			String currentTitle= driver.switchTo().window(winID).getTitle();
			
			// step 4: capture the title with required reference
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * this methods wil take screen shot and return the absolute path of it
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("\\ScreenShot\\"+screenshotName+".png");
		Files.copy(src, dst); // this class has from commons ID tool
		
		return dst.getAbsolutePath(); //attach the screenshot to extent reports
	}
	public void switchToWindow(WebDriver driver, String string) {
	
		
	}

	}
	
	
	
	
	
	
	
	
	

