package FristPak;

import static org.testng.Assert.assertEquals;

import java.util.List;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderDemo {
	WebDriver d;
	@Test(enabled=false)
	public void slider() throws Exception{
		d.get("http://www.seleniumhq.org/");
		WebElement element=d.findElement(By.linkText("follow us"));
		WebDriverWait wait=new WebDriverWait(d, 30);
		//Coordinates slider=((Locatable)element).getCoordinates();
		//slider.inViewPort();
		element.click();
		Thread.sleep(3000);
		d.switchTo().frame(0);
		boolean dis=d.findElement(By.xpath("//*[@class='text-input email-input js-signin-email']")).isDisplayed();
	  System.out.println("expected elemets : "+dis);	
	   d.findElement(By.xpath("//*[@class='text-input email-input js-signin-email']")).sendKeys("shaiik");
	   Thread.sleep(3000);
	}
	@Test
	public void Test()
	{
		d.get("http://www.seleniumhq.org/");
		List<WebElement> links=d.findElements(By.xpath("//*[@id='header']/ul/li"));
		Actions al=new Actions(d);
		int s=links.size();
		for(WebElement ss:links ){
			System.out.println(ss.getText());
			((RemoteWebDriver)d).executeScript("window.scrollBy(0,400)");
			}
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
	public void teardown(){
		d.close();
	}

}
