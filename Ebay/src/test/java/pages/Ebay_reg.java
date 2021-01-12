/* Author: Shweta Tongire
 * Date: 13-Jan-2021
 * Description: below code to
 * 				open the url
 * 				register with invalid input
 * 				register with valid input
 * 				validate register with different input data (valid & invalid)
 * */
package pages;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.Status;

import base.Ebay_Base;

public class Ebay_reg  extends Ebay_Base
{ 
	 static @FindBy(xpath="//a[text()='register']") WebElement reg1; //pagefactory elements for register
	 static @FindBy(xpath="//input[@name='firstname']") WebElement fn; //firstname
	 static @FindBy(xpath="//input[@name='lastname']") WebElement ln;  //lastname
	 static @FindBy(xpath="//input[@name='Email']") WebElement em;		//email
	 static @FindBy(xpath="//input[@name='password']") WebElement ps;  //password
	 static @FindBy(xpath="//button[@name='EMAIL_REG_FORM_SUBMIT']") WebElement ca; //create account button
	 
	 static @FindBy(xpath="//*[@id='firstname_err']") WebElement fn1; //invalid error for firstname 
	 static @FindBy(xpath="//*[@id='lastname_err']") WebElement ln1; //invalid error for lastname  
	 static @FindBy(xpath="//*[@id='Email_err']") WebElement em1;	 //invalid error for email
	 static @FindBy(xpath="//*[@id='password_err']") WebElement ps1; //invalid error for password
	 
	 static @FindBy(xpath="//*[@id='gh-ug']") WebElement hi; //hi (user) button
	 static @FindBy(xpath="/html/body/header/div[1]/ul[1]/li[1]/div/ul/li[5]/a") WebElement out; //signout button
	 
//	 static @FindBy(linkText="Sign out") WebElement signout;
	 
	 public Ebay_reg()
	 {
		 PageFactory.initElements(driver,this); //bind the elements to this driverobject
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	 
	 }
	 public void openbrowser() throws Exception
	 {
		 driver.get(prop.getProperty("url")); //www.ebay website
		 Thread.sleep(20000);
	 }
	
	 public void openurl() throws Exception
	 {
		 reg1.click(); //click on register
		 Thread.sleep(5000);
	 }
		
		
		  public void checkcreate_acc_disabled() //create account disable/enable
		   {
			String outerhtml=ca.getAttribute("outerHTML");
			if(outerhtml.contains("disabled"))
			{
				System.out.println("For invalid inputs createaccount is Disabled");
			}
			else
			{
				System.out.println("even for invalid inputs createaccount is Enabled");
			}
		 }

		 public void registered_invalid() throws Exception  //for invalid registration
		  {
			 try
				{
				FileInputStream fin=new FileInputStream("C:\\Ebay_Docs\\registration.xlsx");//get the file
				XSSFWorkbook wb=new XSSFWorkbook(fin);	//workbook in the file
				XSSFSheet ws=wb.getSheet("invalid_reg");//getsheet in the workbook
				
				Row row;
				for(int r=1;r<=ws.getLastRowNum();r++)//for all the rows in  the sheet
				{	
					fn.clear();
					ln.clear();
					em.clear();
					ps.clear();
					
					row=ws.getRow(r);
					fn.sendKeys(row.getCell(0).getStringCellValue());
					ln.sendKeys(row.getCell(1).getStringCellValue());
					em.sendKeys(row.getCell(2).getStringCellValue());
					ps.sendKeys(row.getCell(3).getStringCellValue());
					Thread.sleep(2000);
					checkcreate_acc_disabled();
							
				}
				fin.close();
				}
				catch(Exception e) {}
			Thread.sleep(2000);
			ca.click(); //create account 
									
			log=ext.createTest("verify invalid entry");
			log.log(Status.PASS, "Error should be display");
			takescreenshot("invalid.png");
			
			fn.clear();
			ln.clear();
			em.clear();
			ps.clear();
		}
			
		public void registered_credentials(String firstname, String lastname, String email, String password) throws Exception //for valid registration
		{
			try{Thread.sleep(2000);} catch(Exception e) {}
			new Actions(driver).click().build().perform();
			
			Thread.sleep(2000);
			fn.sendKeys(firstname); //enter firstname
			ln.sendKeys(lastname); //enter lastname
			em.sendKeys(email);   //enter email
			ps.sendKeys(password); //enter password
			Thread.sleep(1000);
			
			String  str = driver.getTitle(); //get register page title
			if(str.contains("Register"))
			{
				log=ext.createTest("verify register page");
				log.log(Status.PASS, "register page displyed");
				takescreenshot("valid.png");
			}
			else 
			{
				log=ext.createTest("verify register page");
				log.log(Status.FAIL, "register page is not displayed");
				takescreenshot("valid.png");
			}
			ca.click(); //create account 
			Thread.sleep(2000);
		}
		
		public void verify_Title() throws Exception //for verify title 
		{
			Thread.sleep(2000);
			System.out.println("Accepted");
			String  str = driver.getTitle();
			if(str.contains("Electronics, Cars, Fashion, Collectibles & More | eBay"))
			{
				log=ext.createTest("verify homepage");
				log.log(Status.PASS, "homepage displyed");
				takescreenshot("homepage.png");
			}
			else 
			{
				log=ext.createTest("verify homepage");
				log.log(Status.FAIL, "homepage is not displayed");
				takescreenshot("homepage.png");
			}
			
			Thread.sleep(2000);
			hi.click(); //click hi(user)
			Thread.sleep(2000);
			out.click(); //click signout
			Thread.sleep(2000);
			driver.navigate().to("https://www.ebay.com/");
			Thread.sleep(2000);
		}
	
}

