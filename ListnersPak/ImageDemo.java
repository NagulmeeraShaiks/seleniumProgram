package ListnersPak;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImageDemo extends Browser 
{
	//WebDriver d;
	@Test
	public void Image(){
		d.get("https://www.google.co.in/");
		Assert.assertTrue(false);
		String color=d.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).getCssValue("color").toString();
		String st=d.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).getCssValue("font-size").toString();
		String s=d.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).getCssValue("background-color").toString();
		System.out.println("color :::"+color);
		String hex = Color.fromString(color).asHex();
		System.out.println("aaaaaaaaaaaaaaa  ::"+hex);
		System.out.println("backgrowd ::"+st);
		System.out.println("Font_size ::"+s);
		Assert.assertTrue(false);
	}
	
	/*@BeforeMethod
	public void tearTown(){
		
		 d=new FirefoxDriver();
		// System.getProperty("webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
		 d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void setUp(){
	d.close();
	}*/

}
