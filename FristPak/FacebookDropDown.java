package FristPak;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pak2.LoggerFiles;

public class FacebookDropDown extends LoggerFiles{
	private static final Logger logger=Logger.getLogger(FacebookDropDown.class.getName());
	WebDriver d;
	@Test(enabled=false)
	public void test() throws Exception{
		d.get("https://www.facebook.com/");
		logger.info("open the browser");
		Select dpd=new Select(d.findElement(By.id("month")));
		List<WebElement> list=dpd.getOptions();
		logger.info("open drop down");
		System.out.println(list.size());
		for(WebElement s:list){
		System.out.println("list of drop down::"+s.getText());
		}
		for(int i=0;i<list.size();i++){
			String str=list.get(i).getText();
			if(str.contains("Feb"))
				//if(list.size()>=6)
			{
				list.get(i).click();
				String st=list.get(i).getText();
				
				System.out.println("options is ::"+st);
		      		
				break;
			}
		}
		String txt=d.findElement(By.xpath("//*[@id='month']/option[1]")).getAttribute("value");
		System.out.println("given value is "+txt);
		d.findElement(By.xpath("//*[@id='u_0_x']")).click();
		Thread.sleep(2000);}
	@Test
	public void Jaqury() throws Exception{
		d.get("http://jqueryui.com/autocomplete/");
		d.switchTo().frame(0);
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> list=d.findElements(By.className("ui-menu-item"));
		System.out.println("nummbet of saggigstion are :"+list.size());
		for(WebElement st:list){
			
			int i = 0;
			//String str=list.get(i).getText();
			System.out.println("sdjlfjsdl ::"+st.getText());
			//if(str.contains("Asp"))
			}
			if(list.size()>=3)
			{
				for(int i1=0;i1<3;i1++){
					d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
				}
				d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
				String txt=d.findElement(By.id("tags")).getText();
				System.out.println("selected value :" +txt);
				
				Thread.sleep(2000);
				
				/*int i1 = 0;
				list.get(i1).click();
				String s=list.get(i1).getText();
				System.out.println("selected text was :"+s);*/
			}
		}
	
	
	
	
	
	
	
	
	
		@BeforeMethod
		public void tearTown(){
			
			 d=new FirefoxDriver();
			// System.getProperty("webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
			 d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		@AfterMethod
		public void setUp(){
		d.close();	
		
	}

}
