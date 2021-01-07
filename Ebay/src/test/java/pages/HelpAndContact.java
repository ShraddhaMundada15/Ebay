package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelpAndContact 
{
	static WebDriver driver;
	
	@Test
	public void openurl()
	{
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com");
	}
	@Test
	public void openHelp()
	{
		driver.findElement(By.xpath("//a[text()=' Help & Contact']")).click();
	}
	@Test
	public void validateHelp()
	{
		String str = driver.getTitle();
		if(str.contains("eBay"))
			System.out.println("Help section Validated");
		else
			System.out.println("Not validated");
	}
}