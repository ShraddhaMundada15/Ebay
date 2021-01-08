package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Ebay_Base;

public class Buy_ShippingDetails extends Ebay_Base
{
	static @FindBy(xpath="//a[@id='binBtn_btn']") WebElement Buyitnow;
	static @FindBy(xpath="//span//input[@title='Add a credit or debit card']") WebElement CreditDebitCard;
//	static @FindBy(xpath="//span[@text()='Add a credit or debit card']") WebElement CreditDebitCard;
	static @FindBy(xpath="//div//input[@id='cardNumber']") WebElement CardNumber;
	static @FindBy(xpath="//div//input[@id='cardExpiryDate']") WebElement CardExpiryDate;
	static @FindBy(xpath="//div//input[@id='securityCode']") WebElement CardSecurityNo;
	static @FindBy(xpath="//div//input[@id='cardHolderFirstName']") WebElement CardFirstName;
	static @FindBy(xpath="//div//input[@id='cardHolderLastName']") WebElement CarsLastName;
	
	public Buy_ShippingDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void buypage_title()
	{
		String title = driver.getTitle();
		if(title.contains("NEW Callaway Xr Speed Driver 9° Regular Right-Handed Graphite #18961 Golf Club"))
		{
			System.out.println("User is ebay buy it now page");
		}
	}
	
	public void click_buyitnow() throws Exception
	{
		Buyitnow.click();
		Thread.sleep(3000);
	}
	
	public void shippingPage_title()
	{
		String title = driver.getTitle();
		if(title.contains("Checkout | eBay"))
		{
			System.out.println("User is ebay buy it now page");
		}
	}
	
	public void click_cardpayment() throws Exception
	{
		CreditDebitCard.click();
		Thread.sleep(5000);
	}
	
	public void paymentdetails() throws Exception
	{
		CardNumber.sendKeys("1234 5678 9012 3456");
		Thread.sleep(2000);
		CardExpiryDate.sendKeys("10/23");
		Thread.sleep(2000);
		CardSecurityNo.sendKeys("036");
		Thread.sleep(5000);
//		CardFirstName.click();
//		Thread.sleep(2000);
//		CarsLastName.click();
		System.out.println("User able to enter details");
	}

}
