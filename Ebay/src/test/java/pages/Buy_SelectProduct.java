package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Ebay_Base;

public class Buy_SelectProduct extends Ebay_Base
{
	static @FindBy(xpath="//a[text()='Buy']") WebElement BuyOption;
	static @FindBy(xpath="//a[@href='#sporting-goods']") WebElement SportingGoods;
	static @FindBy(xpath="//a[text()='Golf Clubs & Equipment']") WebElement GolfClubEuip;
	static @FindBy(xpath="//div//p[text()='Golf Clubs']") WebElement GolfClubs;
	static @FindBy(xpath="//div//p[text()='Callaway']") WebElement CallawayBrand;
	static @FindBy(xpath="//div//a//h3[starts-with(text(),'NEW Callaway Xr Speed Driver 9° Regular Right-Handed Graphite #18961 Golf Club')]") WebElement CallaywayProduct;
	
	public Buy_SelectProduct()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openurl() throws Exception
	{
//		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
	}
	
	public void click_buy() throws Exception
	{    
//		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		BuyOption.click();
		Thread.sleep(3000);
	}
	
	public void sporting_goods() throws Exception
	{
		System.out.println("before Click sporting goods");
		SportingGoods.click();
		Thread.sleep(1000);
		
		System.out.println("after Click sporting goods");
		GolfClubEuip.click();
		Thread.sleep(3000);
	}
	
	public void select_brand() throws Exception
	{
		GolfClubs.click();
		Thread.sleep(3000);
		CallawayBrand.click();
		Thread.sleep(3000);
	}
	
	public void select_product() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);
		CallaywayProduct.click();
	}
}
