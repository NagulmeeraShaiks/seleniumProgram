package FristPak;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsDemo {
	WebDriver d;
	
	@Test(enabled=false)
	public void test() throws Exception{
		d.get("http://jqueryui.com/droppable/");
		//Assert.assertEquals("Google",d.getTitle());
		//d.switchTo().frame(0);
		Actions al=new Actions(d);
		//al.clickAndHold(d.findElement(By.id("draggable"))).moveToElement(d.findElement(By.id("droppable"))).release().build().perform();
		//al.moveToElement(d.findElement(By.id("draggable"))).sendKeys(Keys.F5);
		Thread.sleep(3000);
		//al.dragAndDrop(d.findElement(By.id("draggable")),d.findElement(By.id("droppable"))).perform();
		//d.switchTo().defaultContent();
		// to slider 
		((RemoteWebDriver)d).executeScript("window.scrollBy(0,300)");
		 // to getup to browser we use 
		((RemoteWebDriver)d).executeScript("window.scrollBy(0,-100)");
		
		//d.switchTo().frame(0);
		//d.findElement(By.xpath("//a[contains(@href,'http://jqueryui.com/slider/')]")).click();
		//al.dragAndDropBy(d.findElement(By.className("ui-slider-handle ui-corner-all ui-state-default")),300,0).perform();
	   
	   
	}
	
	@Test
	public void kyedriven() throws Exception{
		d.get("http://jqueryui.com/autocomplete/");
		d.switchTo().frame(0);
		// doblbe click
		//WebElement doubleclick=d.findElement(By.id("abc"));
		//Actions al=new Actions(d);
		//al.contextClick(doubleclick);
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> sggi=d.findElements(By.xpath("//*[@class='ui-menu-item']"));
		System.out.println("No of saggisions is :"+sggi.size());
		
		int i = 0;
		for(WebElement s:sggi){
			System.out.println(s.getText());
			
		}
		if(sggi.size()>=3){
			for(int i1=0;i<3;i++){
				d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			}
			d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			
		}    //2nd way its not working
	/*	String value=sggi.get(i).getText();
		if(value.equals("abc")){
			d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
		}
		Thread.sleep(3000);
		System.out.println("java option clicked ");
		}*/
		
	}
	
	@BeforeMethod
	public void setdown(){
	d=new FirefoxDriver();
		//System.setProperty("Webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
	//	d=new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void teardown(ITestResult results) throws Exception{
		if(ITestResult.FAILURE==results.getStatus()){
			ScrShot.screenshot(d,results.getName());
		}
		d.close();
	}

}
