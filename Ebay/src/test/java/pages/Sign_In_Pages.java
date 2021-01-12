package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.Ebay_Base;

public class Sign_In_Pages extends Ebay_Base 
{
	  static @FindBy(linkText="Sign in") WebElement signin;
//	  static @FindBy(xpath="//a[@id='signin-link']") WebElement signin1;
	  static @FindBy(name="userid") WebElement email;
	  static @FindBy(name="signin-continue-btn") WebElement logincontinue1;
	  static @FindBy(name="pass") WebElement pwd;
	  static @FindBy(name="sgnBt") WebElement logincontinue2;
	  static @FindBy(xpath="//b[contains(.,'Shraddha')]") WebElement checklogin;
	  static @FindBy(id="signin-error-msg") WebElement loginerrormsg;
	  static @FindBy(linkText="Sign out") WebElement signout;
	   
	  public void openurl() throws Exception
	  {
		  driver.manage().deleteAllCookies();
		  PageFactory.initElements(driver,this);
//		  driver.get(prop.getProperty("url")); //www.ebay website
//		  Thread.sleep(5000);  
	  }
	  
	  public void login()
	  {
		  signin.click();

		  try {Thread.sleep(25000);}catch(Exception e) {}
		  email.sendKeys("smundada1999@gmail.com");
		  logincontinue1.click();
		  try {Thread.sleep(5000);}catch(Exception e) {}
		  pwd.sendKeys("abc@123");
		  logincontinue2.click();	  
		  try {Thread.sleep(30000);}catch(Exception e) {}
		  
		  String str=driver.getTitle();
		  if(str.contains("Sign in or Register | eBay")) 
		  {
				System.out.println("User is on sign in page");
				log = ext.createTest("Sign In page Display");
				log.log(Status.PASS, "User was on Signed in page.");
				takescreenshot("SignIn_Page.png");
			}
			else {
				log = ext.createTest("Sign in page is not displayed");
				log.log(Status.FAIL, "User was not on Signed In page.");
				takescreenshot("SignIn_Page.png");
			}
		  //driver.execute_script("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element)  
	  }
	  public void checkloginsuccess()
	  {
		  try
		  {
			  if(checklogin.isDisplayed())
			  {
				System.out.println("login success");	
//				signout();
			  }
		  }
		  catch(Exception e)
		  {
			  if(loginerrormsg.getText().contains("Oops, that's not a match"))
			  {
				  System.out.println("For invalid Login error message is as expected");
//				  Thread.sleep(2000);
				  driver.navigate().to("https://www.ebay.com/");
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
		  try {Thread.sleep(25000);}catch(Exception e) {}
		  email.sendKeys(uid);
		  logincontinue1.click();
		  pwd.sendKeys(pass);
		  logincontinue2.click();	 
		  checkloginsuccess();  
	  }
  }
