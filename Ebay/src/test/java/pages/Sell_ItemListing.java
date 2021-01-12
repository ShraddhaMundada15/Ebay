/* Author :Pooja Parjane
 * date: 13-jan-2021
 * Description : below code to fill details for sell
 *               preview and list an item for sell
 */               
 
package pages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import base.Ebay_Base;

 public class Sell_ItemListing extends Ebay_Base{
	
	static @FindBy(id="editpane_title") WebElement name;						 //pagefactory elements for entering listing details....
	static @FindBy(xpath="//span[@id='inpWrapper']") WebElement upload;
	//static @FindBy(id="Listing.Item.ItemSpecific[Brand]") WebElement brand;
	static @FindBy(id="Listing.Item.ItemSpecific[Model]") WebElement model;
	static @FindBy(id="Listing.Item.ItemSpecific[Storage Capacity]") WebElement storagecapacity;
	static @FindBy(id="Listing.Item.ItemSpecific[Color]") WebElement color;
	static @FindBy(xpath="//body[@style='font-family: Arial; font-size: 14pt;']") WebElement des;
	static @FindBy(xpath="//input[@id='binPrice']") WebElement startprice;
	static @FindBy(xpath="//input[@id='shipFee1']") WebElement servicecost;
	static @FindBy(xpath="//div//input[@id='pmPayPal']") WebElement paypal;
	static @FindBy(xpath="//div//input[@id='paypalEmail']") WebElement paypalid;
	static @FindBy(xpath="//input[@value='List item']") WebElement listitem;
	static @FindBy(xpath="//input[@value='Preview']") WebElement preview;
	
		public Sell_ItemListing()
		{
			PageFactory.initElements(driver,this);
		}
		public void Details() throws IOException									//code for details....
		{
			
			name.sendKeys("Redmi");	
			new Select(driver.findElement(By.id("itemCondition"))).selectByVisibleText("New");
		    try {
		    Thread.sleep(3000);}catch(Exception e) {}
		    driver.switchTo().frame("uploader_iframe"); 
		    upload.click();
			Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\uploadpic.exe");
			driver.switchTo().defaultContent();	
			try {
			Thread.sleep(3000);}catch(Exception e) {}
			model.sendKeys("Redmi Note 8");
			try {
			Thread.sleep(3000);}catch(Exception e) {}
			storagecapacity.sendKeys("64GB");
			try {
			Thread.sleep(3000);}catch(Exception e) {}
			color.sendKeys("Black");
			driver.switchTo().frame("v4-86txtEdit_st");
			des.sendKeys("Good item at best price.");	
			driver.switchTo().defaultContent();
			try {
			Thread.sleep(5000);}catch(Exception e) {}
			new Select(driver.findElement(By.name("format"))).selectByVisibleText("Fixed price");
			try {
			Thread.sleep(7000);}catch(Exception e) {}
			startprice.sendKeys("10");
			try {
			Thread.sleep(3000);}catch(Exception e) {}
			paypal.click();	
			try {
			Thread.sleep(3000);}catch(Exception e) {}
			paypalid.sendKeys("poojaparjane@gmail.com");	
		    try {
			Thread.sleep(3000);}catch(Exception e) {}
			driver.findElement(By.xpath("//select[@id='shipService1']")).sendKeys("USPS Parcel Select Ground(2 to 9 business days)");
			try {
			Thread.sleep(3000);}catch(Exception e) {}
			servicecost.sendKeys("10");
		    try {
			Thread.sleep(3000);}catch(Exception e) {}
		    new Select(driver.findElement(By.id("shipsWithinDays"))).selectByVisibleText("5 business days");
	
		}
		public void preview() {														//code for preview button...
			preview.click();
			ArrayList<String> lst = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(lst.get(1));
			driver.close(); 
			driver.switchTo().window(lst.get(0));
			
		}
		public void validatePreview() {												//code for validate preview...
			
						
		}
		
		public void ListAnItem() {													//code for listing item....
			listitem.click();
		}
		public void validatelistingProduct() throws Exception
		{										//code for validate listing item....	
			String title=driver.getTitle();
			if(title.contains("Create your listing"))
			{
				log=ext.createTest("listing2");
				log.log(Status.PASS, "Item is listed");
				takescreenshot("listing2.png");
			}
			else
			{
				log=ext.createTest("listing2");
				log.log(Status.FAIL, "Item is not listed");
				takescreenshot("listing2.png");
			}	
			driver.navigate().to("https://www.ebay.com/");
			Thread.sleep(3000);
		}
	}