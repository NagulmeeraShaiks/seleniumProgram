package Pak2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Whatsup {
	WebDriver driver;
		
		@BeforeMethod()
		public void setUp()
		{

	/*System.setProperty("webdriver.chrome.driver", 
	"//home//xpms//Desktop//workspace//Framwork//RAINBOWFRAMEWORK/lib//chromedriver");
			
	driver=new ChromeDriver();
			*/
			driver=new FirefoxDriver();
	driver.manage().window().maximize();
			
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		}
		

	@Test
		
	public void test() throws Exception
		{
			
	driver.get("https://www.whatsapp.com");
			
	driver.findElement(By.xpath("//*[@id='top']/div[1]/header/div/nav/ul/li[1]/a")).click();
			
	Thread.sleep(10000);
			
			
	WebDriverWait wait=new WebDriverWait(driver,100);
			
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='side']/header/div[2]/div/span/div[2]/button")));		
			Thread.sleep(30000);
			
			//sending msg to contact
			/*driver.findElement(By.xpath("//*[@id='side']/div[2]/div/label/input")).sendKeys("UMASS");
		
	Thread.sleep(30000);
			
	driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/span/span")).click();
			driver.findElement(By.xpath("//*[@id='main']/footer/div[1]/div[2]/div/div[2]")).click();
			
	driver.findElement(By.xpath("//*[@id='main']/footer/div[1]/div[2]/div/div[2]")).sendKeys("Hi I am sending sms");
			driver.findElement(By.xpath("//*[@id='main']/footer/div[1]/button")).click();*/
	 //To find the no of contacts
			List<WebElement> contacts=driver.findElements(By.xpath("//*[starts-with(@id,'pane-side')]"));
			System.out.println("Contats size is:"+contacts.size());
			
	String cont[]=new String[contacts.size()];
			
	int i=0;
			
	for(WebElement w:contacts)
			
	{
	//System.out.println(w.getText());
				
	cont[i]=w.getText();
				
	i++;
		 
			}
		
			Actions action=new Actions(driver);
	//display all the data from that div tag
			System.out.println("***************All Contacts are***************");
			
	//String contactsdataa=null;
			
	FileWriter file=new FileWriter("//home//xpms//Desktop//workspace//Framwork//WhatsApp//OutputFile//NamesList.doc");
	 		PrintWriter pw=new PrintWriter(file);
		   
			
	for(int j=1;j<19;j++)
	{


	String contactsdataa=driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div["+j+"]/div/div/div[2]/div[1]/div[1]/span")).getText();
				
	System.out.println(contactsdataa);
		
			         
		 		
	pw.print("\t"+contactsdataa+"\n");
		 	 }
	 		
	pw.close();

			
	System.out.println("**************completed********************");    
			
	//Creating file and writing data into txt file
			
	FileWriter file1=new FileWriter("//home//xpms//Desktop//workspace//Framwork//WhatsApp//OutputFile//ChatHistory.doc");
	 	PrintWriter pw1=new PrintWriter(file1);
	//find all contacts
			
	for(int k=1;k<28;k++)
			{
				
	String contactsdata1=driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div["+k+"]/div/div/div[2]/div[1]/div[1]/span")).getText();
				
				
	if(k==27)
				
	{

	k=1;
				}

	System.out.println("****************************************************");
				System.out.println("contacts details :"+contactsdata1);

	System.out.println("****************************************************");
						    pw1.print("\n******************Contact Details*****************\n\t \t"+contactsdata1+"\n***********************************************");
				
	Thread.sleep(1000);	

	WebElement all=driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div["+k+"]/div/div/div[2]/div[1]/div[1]/span"));//action.moveToElement(all).perform();
			
	action.click(all).build().perform();
				
	//scrolling 
				
	for(int n=0;n<2;n++)
				{
					
	((RemoteWebDriver) driver).executeScript("arguments[0].scrollIntoView();",all);
			       
	 Thread.sleep(1000);
				
	}
					           
				
	Thread.sleep(5000);

				
	String text=driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div")).getText();
				
	System.out.println("The data is :"+text);
				
	Thread.sleep(2000);
				
		        
	pw1.print("\n*********** The Chat History Start *****************\n"+text+"\n---------------------- The Chat History Complete --------------------\n");
	 
			
	}
			
	pw1.close();

	//logout
			
	Thread.sleep(3000);
			
	driver.findElement(By.xpath("//*[@id='side']/header/div[2]/div/span/div[2]/button")).click();
			
	driver.findElement(By.xpath("//*[@id='side']/header/div[2]/div/span/div[2]/span/div/ul/li[6]/div")).click();
		
	}
		
	@AfterMethod()
		
	public void tearDown()
		
	{
			
	driver.close();

	}

	}



