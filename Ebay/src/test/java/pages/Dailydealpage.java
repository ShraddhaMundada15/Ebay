package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Ebay_Base;

public class Dailydealpage extends Ebay_Base
{
	static @FindBy(linkText="Daily Deals") WebElement DailyDealoption;
	static @FindBy(name="_nkw") WebElement Searchproduct;
	static @FindBy(xpath=("//input[@value='Search']")) WebElement Searchbutton;
	static @FindBy(xpath=("//div[@class='page-notice__content']/p")) WebElement message;
	
	public Dailydealpage()
	{
	   PageFactory.initElements(driver, this);	
	}
	
	public void openurl()
	{
		driver.get(prop.getProperty("url"));
	}
	
	public void dailydeal_Pageoption()
	{
		DailyDealoption.click();
	}

	public void dailydealpage_Validation() throws Exception
	{
		Thread.sleep(5000);
		String title=driver.getTitle();
		if(title.contains("Daily Deals"))
		{
			log=ext.createTest("Daily Deals");
			log.log(Status.PASS, "Daily Deal page is display");
			takescreenshot("DailyDealpage.png");
		}
		else
		{
			log=ext.createTest("Daily Deals");
			log.log(Status.FAIL, "Daily Deal page is not display");
			takescreenshot("DailyDealpage.png");
		}
	}
	
	public void search_ProuductAvailable ()
	{
		Searchproduct.sendKeys("Camera");
		Searchbutton.click();		
	}
	
	public void productAvailable_Validation() throws Exception
	{
		Thread.sleep(5000);
		String title=driver.getTitle();
		if(title.contains("Camera"))
		{
			log=ext.createTest("Camera");
			log.log(Status.PASS, "Deal and discount for product is display");
			takescreenshot("Dealproduct.png");
		}
		else
		{
			log=ext.createTest("Camera");
			log.log(Status.FAIL, "Deal and discount for product is not display");
			takescreenshot("Dealproduct.png");
		}
	}
	
	public void search_ProuductNotAvailable ()
	{
		DailyDealoption.click();
		Searchproduct.sendKeys("Eno");
		Searchbutton.click();		
	}
	
	public void productNotAvailable_Validation() throws Exception
	{
		Thread.sleep(5000);
		String str=message.getText();
		if(str.contains("We don't have any deals for"))
		{
			log=ext.createTest("We don't have any deals for");
			log.log(Status.PASS, "Deal and discount for given product is not display for product which is not available");
			takescreenshot("Dealproductnotavailable.png");
		}
		else
		{
			log=ext.createTest("We don't have any deals for");
			log.log(Status.FAIL, "Deal and discount for given product is display for product which is not available");
			takescreenshot("Dealproductnotavailable.png");
		}
	}
	
	
	
	
}
