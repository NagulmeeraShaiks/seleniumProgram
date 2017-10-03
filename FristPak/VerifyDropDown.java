 package FristPak;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyDropDown {
	WebDriver d;
	@Test(enabled=false)
	public void dropdown() throws InterruptedException{
		d.get("https://www.facebook.com/");
		String Actmonth[]={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
		System.out.println(" Actul months length : "+Arrays.toString(Actmonth));
		
		
		Select Expmonth=new Select(d.findElement(By.id("month"))); 
		//Expmonth.selectByIndex(6);
		Expmonth.selectByVisibleText("Feb");
		Thread.sleep(5000);
		
		boolean verifydropdown=Expmonth.isMultiple();
		System.out.println("dropdown :"+verifydropdown);
		List<WebElement> allmonths=Expmonth.getOptions();
		
		System.out.println("get all momths in dropdown size :"+allmonths.size());
		/*for(WebElement dropdown:allmonths){
			System.out.println("get all momths in dropdown :"+dropdown.getText());}
			
		for(int i=0;i<allmonths.size();i++){
			Assert.assertEquals(Actmonth[i],allmonths.get(i).getText());*/
			for(int i=0;i<allmonths.size();i++){
				String ss=allmonths.get(i).getText();
				if(ss.equals("Feb")){
					allmonths.get(i).click();
				}
			}
	
		}
		@Test(enabled=false)
		public void tagname(){
			d.get("http://www.seleniumhq.org/");
			String str=d.findElement(By.tagName("input")).getAttribute("title");
			System.out.println("All tagname :"+str);
		}
		@Test
		public void table(){
			d.get("https://www.w3schools.com/html/html_tables.asp");
			List<WebElement> ss=d.findElements(By.xpath("//*[@id='customers']/tbody/tr[5]/td"));
			for(WebElement sss:ss){
			String str=sss.getText();
			System.out.println(str);
			
		}}
		
	
	@BeforeMethod
	public void setdown(){
	d=new FirefoxDriver();
		//System.setProperty("Webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
	//	d=new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void teardown(){
		d.close();
	}

}
