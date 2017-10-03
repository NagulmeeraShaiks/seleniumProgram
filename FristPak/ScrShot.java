package FristPak;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScrShot {
	

	public static void screenshot(WebDriver driver,String username) throws Exception{
		try {
			DateFormat format=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt=new Date(); 
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("./screenshots"+""+username+""+format.format(dt)+"jqury.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("screenshot is not taken ::"+ e.getMessage());
		}
	}}