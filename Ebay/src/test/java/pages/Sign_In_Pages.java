package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.Status;

import base.Ebay_Base;
//import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class Sign_In_Pages extends Ebay_Base 
{
	  static @FindBy(linkText="Sign in") WebElement signin;
	  static @FindBy(name="userid") WebElement email;
	  static @FindBy(name="signin-continue-btn") WebElement logincontinue1;
	  static @FindBy(name="pass") WebElement pwd;
	  static @FindBy(name="sgnBt") WebElement logincontinue2;
	  static @FindBy(xpath="//b[contains(.,'Simran')]") WebElement checklogin;
	  static @FindBy(id="signin-error-msg") WebElement loginerrormsg;
	  static @FindBy(linkText="Sign out") WebElement signout;
	  
//	  public void initialize()
//		{
//			//driver=new FirefoxDriver();
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
//			driver.manage().deleteAllCookies();
//		}
	  
	  public void openurl()
	  {
		  //initialize();
		  driver.manage().deleteAllCookies();
		  PageFactory.initElements(driver,this);
		  //driver.get("http://www.ebay.com");
		  driver.get(prop.getProperty("url"));
		  
	  }
	  
	public void login()
	  {
		  signin.click();
		  String str=driver.getTitle();
		  if(str.contains("Sign in or Register|eBay")) {
				
				System.out.println("User is on  sign in .");
				log = ext.createTest("Sign In page Display");
				log.log(Status.PASS, "User was on Signed in page.");
				takescreenshot("SignIn_Page.png");
			}
			else {
				System.out.println("User is not on Sign in Page.");
				log = ext.createTest("Sign in page is not displayed");
				log.log(Status.FAIL, "User was  not on Signed In page.");
				takescreenshot("SignIn_Page.png");
			}
		  try {Thread.sleep(20000);}catch(Exception e) {}
		  email.sendKeys("simranchhaparwal3@gmail.com");
		  logincontinue1.click();
		  try {Thread.sleep(5000);}catch(Exception e) {}
		  
		  pwd.sendKeys("simran@1998");
		  logincontinue2.click();	  
		  try {Thread.sleep(30000);}catch(Exception e) {}
		 
		  //driver.execute_script("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element)
		  
	  }
	  public void checkloginsuccess()
	  {
		  try
		  {
			  if(checklogin.isDisplayed())
			  {
				System.out.println("login success");	
				signout();
			  }
		  }
		  catch(Exception e)
		  {
			  if(loginerrormsg.getText().contains("Oops, that's not a match"))
			  {
				  System.out.println("For invalid Login error message is as expected");
			  }
			  else
			  {
				  System.out.println("for invalid login error message not as expected");
			  }
		  }
	  }
	  public void signout()
	  {
		  checklogin.click();
		  try {Thread.sleep(5000);}catch(Exception e) {}
		  signout.click(); 
	  }
	  public void validateLogin(String uid,String pass)
	  {	 
		  signin.click();
		  email.sendKeys(uid);
		  logincontinue1.click();
		  pwd.sendKeys(pass);
		  logincontinue2.click();	 
		  checkloginsuccess();
		   String str1=driver.getTitle();
			
			if(str1.contains("Electronics, Cars, Fashion, Collectibles & More | eBay")) {
				System.out.println("User is on dashboard after sign in .");
				log = ext.createTest("DashBoard Display");
				log.log(Status.PASS, "User was successfully signed in");
				takescreenshot("Dashboard.png");
			}
			else {
				System.out.println("User is not on Dashboard in Page.");
				log = ext.createTest("DashBoard Display");
				log.log(Status.FAIL, "User was  not succesfully signed in.");
				takescreenshot("Dashboard.png");
			}
		  
	  }
	  
	}
