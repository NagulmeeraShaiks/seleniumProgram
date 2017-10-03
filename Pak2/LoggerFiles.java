package Pak2;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoggerFiles {
	//WebDriver d;
	
		private static final Logger logger=Logger.getLogger(LoggerFiles.class.getName());
		@BeforeTest
		
	public void m(){
	 
	
	
		//d.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=w7LHWY3lA4nRqAGbloj4Cw");
		String logs=System.getProperty("user.dir")+"/src/Pak2/log4j.properties";
		PropertyConfigurator.configure(logs);
		//logger.info("oopen the browser ");
		
	}
	/*@BeforeTest
	public void bt(){
		System.out.println("Before Test method");
      logger.info("this is before Test ");
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
}*/
}