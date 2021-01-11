package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Buy_Base;

public class HelpAndContact extends Buy_Base
{
	static @FindBy(xpath="//a[text()=' Help & Contact']") WebElement w;
	static @FindBy(xpath="//span[text()='Buying as a guest ']") WebElement g;
	static @FindBy(xpath="//span[text()='Get help with an item that hasn't arrived']") WebElement n;
	static @FindBy(xpath="//span[text()='Get help with a hacked account']") WebElement h;	
	
	public HelpAndContact() 
	{
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void openurl()
	{
		driver.get(prop.getProperty("url"));
	}
	
	public void openHelp() 
	{
		
		w.click();
	}
	
	public void validateHelp() throws Exception
	{
		Thread.sleep(3000);
		String title1=driver.getTitle();
		if(title1.contains("Customer Service"))
		{
			log=ext.createTest("Help_Search");
			log.log(Status.PASS, "Help title is correct");
			takescreenshot("Help.png");
			
		}
		else
		{
			log=ext.createTest("Help_search");
			log.log(Status.FAIL, "Help title is not correct");
			takescreenshot("Help.png");
		}
			
	}
	
	public void clickBuyaG()  // Buy as Guest
	{
		g.click();
	}
	
	public void validateBaG() throws Exception
	{
		Thread.sleep(3000);
		String title2=driver.getTitle();
		if(title2.contains("Buying as a guest"))
		{
			log=ext.createTest("BuyAsGuest_Search");
			log.log(Status.PASS, "Buy as Guest title is correct");
			takescreenshot("BaG.png");
			
		}
		else
		{
			log=ext.createTest("BuyAsGuest_Search");
			log.log(Status.FAIL, "Buy as Guest title is not correct");
			takescreenshot("BaG.png");
		}
	}
	
	public void itemNotArrived() 
	{
		driver.navigate().back();
		List <WebElement> elements = driver.findElements(By.xpath("//span[text()='Popular article']"));
		elements.get(2).click();
	//	n.click();
	}
	
	public void validateItemNotArrived() throws Exception
	{
		Thread.sleep(3000);
		String title3=driver.getTitle();
		if(title3.contains("Get help with an item that hasn't arrived"))
		{
			log=ext.createTest("ItemNotArrived_Search");
			log.log(Status.PASS, "Item not arrived title is correct");
			takescreenshot("InA.png");
			
		}
		else
		{
			log=ext.createTest("ItemNotArrived_Search");
			log.log(Status.FAIL, "Item not arrived title is not correct");
			takescreenshot("InA.png");
		}
	}
	
	public void hackedAccountHelp() 
	{
		driver.navigate().back();
		h.click();		
	}
	
	public void validateHackedAcoountHelp() throws Exception
	{
		Thread.sleep(3000);
		String title4=driver.getTitle();
		if(title4.contains("hacked account"))
		{
			log=ext.createTest("HackedAccountHelp_Search");
			log.log(Status.PASS, "Hacked account help title is correct");
			takescreenshot("HaH.png");
			
		}
		else
		{
			log=ext.createTest("HackedAccountHelp_Search");
			log.log(Status.FAIL, "Hacked account help title is not correct");
			takescreenshot("HaH.png");
		}
	}
}