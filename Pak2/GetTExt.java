package Pak2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetTExt {
	WebDriver d;
	@Test
	public void set() throws Exception{
		d.get("https://www.w3schools.com/cssref/css3_pr_text-decoration-color.asp");
		String text=d.findElement(By.xpath("//*[@id='main']/div[3]/div/span")).getText();
		System.out.println("getting text is :"+text);
		
		 // Writeing data to textfile
		FileWriter fil=new FileWriter("D:\\FileWriter\\ textfile.txt");
		PrintWriter p=new PrintWriter(fil);
		p.write(text);
		p.close();
		}
	
	
	
	
	
	
	
	
		@Test
		public void sreading() throws IOException{
		// Reading data from text fil
		FileReader fr=new FileReader("D:\\FileWriter\\ textfile.txt");
		//PrintReder pr=new PrintReder(fr);
		BufferedReader bf=new BufferedReader(fr);
		/*boolean str=
		if(str=bf.readLine()!=null){
			System.out.println(str);
		}*/
		BufferedReader s=bf;
		System.out.println("reading data is :"+s);
//		bf.read();
//		bf.close();
	
		
		}
	@Test(enabled=false)
	public void tes(){
		d.get("https://www.google.co.in/?gws_rd=ssl");
		WebElement str=d.findElement(By.xpath("//*[@id='hplogo']/a/img"));
		System.out.println("getAttributes :"+str.getAttribute("title"));
		System.out.println("getAttributes :"+str.getAttribute("img"));
		System.out.println("getAttributes :"+str.getAttribute("width"));
		System.out.println("getAttributes :"+str.getAttribute("height"));
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
