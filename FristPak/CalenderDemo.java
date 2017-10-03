package FristPak;

 import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderDemo {
	WebDriver d;
	@Test
	public void candemo() throws Exception{
		d.get("https://www.redbus.in");
		d.findElement(By.id("src")).sendKeys("hyderabad");
		d.findElement(By.id("dest")).sendKeys("vijayawada");
		d.findElement(By.id("onward_cal")).click();
		Thread.sleep(2000);
		List<WebElement> months=d.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
	   int monthcount=months.size();
	   
	   for(int i=0;i<monthcount;i++){
		   
		   String text=months.get(i).getText();
		   if(text.equals("24")){
			   months.get(i).click(); 
		   }
	   }
	}
	@BeforeMethod
	public void setup(){
		d=new FirefoxDriver();
	}
	@AfterMethod
	public void teardown(){
		d.close();
		
	}

}
