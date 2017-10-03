package Pak2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class GmailDropdown {
	WebDriver d;
	//Logger logger=Logger.getLogger("GmailDropdown");
	@Test
	public void test(){
		d.get("https://accounts.google.com/SignUp?continue");
	   /* WebElement s=d.findElement(By.id("BirthMonth"));
	    Select ss=new Select(s);
	    List<WebElement> get=ss.getOptions();
	    System.out.println("all options"+get.size());
	    ss.selectByIndex(5);*/
	d.findElement(By.xpath("//*[@id='BirthMonth']/div")).click();
	//logger.info("Excute birth option");
	
		List<WebElement> s=d.findElements(By.className("goog-menuitem"));
		System.out.println(s.size());
		int count=s.size();
		for(WebElement sss:s){
			//System.out.println(sss.getText());
		}
		for(int i=0;i<count;i++)
		{
			WebElement html=s.get(i);
			String s1=html.getAttribute("innerHTML");
			System.out.println("innerHTML is ::"+s1);
			if(s1.contentEquals("June")){
				html.click();
				System.out.println("loop enter into value");
				break;
			}
			System.out.println("innethtml value"+s1);
			/*String ss=s.get(i).getText();
			//System.out.println(ss);
			if(ss.contains("June")){
				s.get(i).click();
				System.out.println("assdfghjjjjjjjjjjjj");
				break;
			}*/}
			String str=d.findElement(By.className("goog-menuitem")).getAttribute("title");
			//System.out.println(s.get(i).getText());
			System.out.println(str);
			d.findElement(By.id("BirthDay")).sendKeys("13");
			
		}
	@Test(enabled=false)
	public void google(){
		d.get("www.goolg.com");
		//d.findElement(By.)
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
