package GenaralPak;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoiT {
	WebDriver d;
	
	@Test //(enabled=false)
	public void fileUupload() throws Exception{
		d.get("https://login.naukri.com/nLogin/Login.php");
		
		d.findElement(By.id("emailTxt")).sendKeys("nagur429@gmail.com");
		d.findElement(By.id("pwd1")).sendKeys("md@12345");
		//WebElement element=d.findElement(By.id("sbtLog"));
		WebDriverWait wait=new WebDriverWait(d,30);
        WebElement Time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='Login']")));
        Time.click();
        Thread.sleep(2000);
        ((RemoteWebDriver)d).executeScript("window.scrollBy(0,400)");
        
		d.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[1]/button")).click();
		
		Thread.sleep(2000);
		WebElement element=d.findElement(By.id("uploadLink"));
		Coordinates co=((Locatable)element).getCoordinates();
		co.inViewPort();
		element.click();
		
		Thread.sleep(2000);
		d.findElement(By.id("attachCV")).click();
		
		Runtime.getRuntime().exec("D:\\Auto it\\naukri.exe");
		Thread.sleep(2000);
		d.findElement(By.className("w85bt fl")).click();
		d.navigate().refresh();
		
	}
	@Test(enabled=false)
	public void Download() throws Exception{
		d.get("http://www.seleniumhq.org/download/");
		d.findElement(By.xpath(".//*[@id='mainContent']/p[3]/a")).click();
		Runtime.getRuntime().exec("D:\\Auto it\\SeleniumDownload.exe");
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
