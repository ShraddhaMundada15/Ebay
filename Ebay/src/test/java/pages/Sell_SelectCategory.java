/* Author :Pooja Parjane
 * date: 13-jan-2021
 * Description : below code to open url
 *               category page to open
 *               category page validation
 *               category and subcategory selection
 *               listing page 
 */
package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import base.Ebay_Base;

public class Sell_SelectCategory extends Ebay_Base
{	
		static @FindBy(linkText="Sign in") WebElement signin;					//pagefactory elements for clicking on sell and selecting categories......
		static @FindBy(id="userid") WebElement userid;
		static @FindBy(id="signin-continue-btn") WebElement continuebutton;
		static @FindBy(id="pass") WebElement password;
		static @FindBy(id="sgnBt") WebElement signinbutton;
		static @FindBy(xpath="//a[text()=' Sell']") WebElement sell;      
		static @FindBy(xpath="//button[@block='browse-categories']") WebElement browsecategory;         
		static @FindBy(xpath="//div[@id='container_1']//ul//li[7][@id='caty_option_15032']") WebElement cellphones;
		static @FindBy(xpath="//div[@id='container_2']//ul//li[text()='Cell Phones & Smartphones']") WebElement mobiles;
		
		public Sell_SelectCategory()
		{
			PageFactory.initElements(driver,this);
		}
		/*
		public void openurl()																	//code to openurl....
		{
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));								
			driver.manage().deleteAllCookies();
		}*/

		public void sellProduct() {																//code to click on sell button...
			try {
		    Thread.sleep(30000);}catch(Exception e) {}
			sell.click();
		}
		public void selectCategory()															//code to browse category.....
		{
			try {
		    Thread.sleep(3000);}catch(Exception e) {}
			driver.switchTo().frame("findprod_iframe");
			browsecategory.click();
		}
		public void cellphones() {																//code to select cellphones&accessories category....
			try {
		    Thread.sleep(3000);}catch(Exception e) {}
			cellphones.click();
		}
		public void mobiles() {																	//code to select mobiles as subcategory....
			try {
		    Thread.sleep(3000);}catch(Exception e) {}
			mobiles.click();
		}
		public void validateBrowseCategory() {													//code to validate category page...
			String title=driver.getTitle();
			if(title.contains("Create your listing"))
			{
				log=ext.createTest("category");
				log.log(Status.PASS, "categorie page is displayed");
				takescreenshot("category.png");
			}
			else
			{
				log=ext.createTest("category");
				log.log(Status.FAIL, "categorie page is not displayed");
				takescreenshot("category.png");
			}
		}
		public void validatelisting() {															//code to validate listing page...
			
			String title=driver.getTitle();
			if(title.contains(title))
			{
				log=ext.createTest("listing");
				log.log(Status.PASS, "listing page is displayed");
				takescreenshot("listing1.png");
			}
			else
			{
				log=ext.createTest("listing");
				log.log(Status.FAIL, "listing page is not displayed");
				takescreenshot("listing1.png");
			}
		}			
	}