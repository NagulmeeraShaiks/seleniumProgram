package ListnersPak;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListnersPak.LtDemo2.class)

public class Ltdemo extends Browser
{
	//WebDriver d;
	
	@Test
	public void flipkard() throws Exception{
		d.get("https://www.flipkart.com/");
		Actions al=new Actions(d);
		d.findElement(By.className("LM6RPg")).sendKeys("iphone 6s");
	
		//d.findElement(By.className("LM6RPg")).sendKeys(Keys.ENTER);
		//d.findElement(By.linkText("Apple iPhone 6s (Rose Gold, 32 GB)")).click();
	  
	    Thread.sleep(500);
	    //for(int i=0;i<4;i++){
	   // ((RemoteWebDriver)d).executeScript("window.scrollBy(500,0)");
	  //  d.findElement(By.xpath("//li/button")).click();
	}
	@Test
	public void sample(){
		d.get("https://www.facebook.com/");
		System.out.println("falure method");
		Assert.assertTrue(false);
	}
	/*@BeforeMethod
	public void tearTown(){
		
		 d=new FirefoxDriver();
		// System.getProperty("webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
		 d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void setUp(){
	d.close();
	}*/
	

}
