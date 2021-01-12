/* Author :Ankita Madnaik
 * date: 13-jan-2021
 * Description : below code to open url
 *               daily deal page open
 *               daily deal page validation
 *               search product which is available
 *               validate product which is available
 *               search product which is not  available
 *               validate product which is not available
 */

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
	
	static @FindBy(xpath="//*[@id='gh-ug']") WebElement hi; //hi (user) button
	static @FindBy(xpath="/html/body/header/div[1]/ul[1]/li[1]/div/ul/li[5]/a") WebElement out; //signout button
	
	public Dailydealpage()
	{
	   PageFactory.initElements(driver, this);	
	}
	
//	public void openurl()
//	{
//		driver.get(prop.getProperty("url"));
//	}
	
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
		driver.navigate().to("https://www.ebay.com/");
		Thread.sleep(3000);
		Thread.sleep(2000);
		hi.click(); //click hi(user)
		Thread.sleep(2000);
		out.click(); //click signout
		Thread.sleep(2000);
		driver.navigate().to("https://www.ebay.com/");
		Thread.sleep(2000);
	}
	
	
	
	
}
