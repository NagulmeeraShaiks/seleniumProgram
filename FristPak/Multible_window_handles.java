package FristPak;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Multible_window_handles {
	WebDriver d;

	@Test
	public void test() throws Exception{
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		//List<WebElement>links=d.findElements(By.tagName("span"));
        // System.out.println("Number of links "+links.size());	
		d.findElement(By.linkText("Cab / Bus")).click();
		Thread.sleep(6000);
		
		d.findElement(By.linkText("Mahila E-Haat")).click();
		Thread.sleep(6000);
		
		d.findElement(By.linkText("E-Wheelchair")).click();
		Thread.sleep(6000);
		d.findElement(By.linkText("Flight Tickets")).click();
		Thread.sleep(8000);
	
		d.findElement(By.linkText("E-Catering")).click();
		Thread.sleep(8000);
		
		Set<String> str=d.getWindowHandles();
		// string convrt into arryalist 
		ArrayList<String> window=new ArrayList<String>(str);
		d.switchTo().window(window.get(0));
		String f=d.switchTo().window(window.get(0)).getTitle();
		System.out.println("frist window title name :"+f);
		
		
		d.switchTo().window(window.get(2));
		d.switchTo().window(window.get(0));
		d.findElement(By.id("usernameId")).sendKeys("nagulmeera");
		d.findElement(By.className("loginPassword")).sendKeys("nagulmeera");
		d.switchTo().window(window.get(3));
		d.switchTo().window(window.get(2));
		d.findElement(By.id("rmkkeyword")).sendKeys("Nagulmeera");
		Thread.sleep(8000);
		d.findElement(By.id("search_product")).click();
		d.switchTo().window(window.get(0));
		d.findElement(By.linkText("National Voter's Services Portal")).click();
		d.switchTo().window(window.get(6));
		
		
		
		
	}
		@BeforeMethod
		public void tearTown(){
			
			 d=new FirefoxDriver();
			// System.getProperty("webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
			 d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		@AfterMethod
		public void setUp(){
		//d.close();	
		}
}
