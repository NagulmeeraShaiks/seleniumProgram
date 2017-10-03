 package ListnersPak;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class Browser {
WebDriver d;
     @Parameters("browser")
    // @Parameters("Url")
    @BeforeMethod
    public void brwosers(String browser){
    	if(browser.equals("FF")){
    		d=new FirefoxDriver();
    	}
    	if(browser.equals("chrome")){
    		
    		d=new ChromeDriver();
    		System.getProperty("webdriver.chrome.driver","D:\\Software Download\\chromedriver.exe");
   		 d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	}
    	if (browser.equals("IE")){
    		d=new InternetExplorerDriver();
    	}
		//return browser;
    	
    }
     @AfterMethod
     public void set(){
    	 d.close();
     }

}
