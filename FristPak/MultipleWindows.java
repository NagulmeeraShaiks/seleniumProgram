package FristPak;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.swing.text.TabSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {
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
		//System.out.println("Number of windows ::"+str.size());
		TreeSet<String> ts=new TreeSet<String>(str);
		System.out.println("windows handle :::"+ts.size());
		String[] handle=new String[ts.size()];
		int i = 0;
		for(String ss:ts){
			System.out.println(ss);
			handle[i]=ss;
			System.out.println(" Hndles :::"+handle[i]);
			i++;}
		
		
		Thread.sleep(5000);
		String sr=d.switchTo().window(handle[1]).getTitle();
		d.switchTo().window(handle[1]).close();
		Thread.sleep(5000);
		System.out.println("Title of windows :"+sr);
		//String sr1=d.switchTo().window(handle[3]).getTitle();
		//System.out.println("Title of windows :"+sr1);
		String sr2=d.switchTo().window(handle[3]).getTitle();
		System.out.println("Title of windows :"+sr2);
		
		
		Thread.sleep(5000);
		
		d.switchTo().window(handle[2]);
		
		d.findElement(By.id("rmkkeyword")).sendKeys("Naglmeerashaik");
		Thread.sleep(3000);
		//d.findElement(By.linkText("Toggle search")).click();
		Thread.sleep(3000);
		

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
