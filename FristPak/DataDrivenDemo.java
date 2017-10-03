     package FristPak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataDrivenDemo {
	WebDriver d;
	@Test
	public void data() throws IOException{
		d.get("https://www.google.co.in");
		
		FileInputStream fil=new FileInputStream("D:\\Excel Sheet\\Book1.xlsx");
		XSSFWorkbook wk=new XSSFWorkbook(fil);
		XSSFSheet st=wk.getSheetAt(0);
		XSSFRow colum=st.getRow(0);
		for(int i=0;i<colum.getLastCellNum()+1;i++){
			
			for(int j=1;j<st.getLastRowNum()+1;j++){
				
			d.findElement(By.id("lst-ib")).sendKeys(st.getRow(i).getCell(j).getStringCellValue());
			d.findElement(By.id("lst-ib")).clear();
			
			}}
			int rowcount=st.getLastRowNum()+1;
			System.out.println("Number of row in sheet::"+rowcount);
			//XSSFRow colum=st.getRow(0);
			int columcout=colum.getLastCellNum()+1;
			System.out.println("Number of colums in sheet::"+columcout);
			
		
		
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
	public void teardown() throws Exception{
		d.close();
	}

}
