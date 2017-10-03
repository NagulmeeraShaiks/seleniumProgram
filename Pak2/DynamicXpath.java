package Pak2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicXpath {
	WebDriver driver;
	@Test()
	 public void Search_Test(){ 
	   driver.get("https://www.google.co.in");
	   driver.findElement(By.xpath("//input[@id='gbqfq']")).clear();
	   driver.findElement(By.xpath("//input[@id='gbqfq']")).sendKeys("sfgfsg");
	   int i=1;
	   int j=i+1;
	   try{
	    //for loop will run till the NoSuchElementException exception.
	    for(i=1; i<j;i++)
	      { 
	     //Value of variable i Is used for creating xpath of drop list's different elements.
	     String suggestion = driver.findElement(By.xpath("//*[@id='gsr']/table/tbody/tr[1]/td[2]/table/tbody/tr["+i+"]/td/div/table/tbody/tr/td[1]/span")).getText();
	     System.out.println(suggestion);
	     j++;     
	      } 
	    }catch(Exception e){//Catch block will catch and handle the exception.
	     System.out.println("***Please search for another word***"); 
	     System.out.println();
	    }  
	  }
	@BeforeMethod
	public void tearTown(){
		
		 driver=new FirefoxDriver();
		// System.getProperty("webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void setUp(){
	driver.close();	
}}
