package FristPak;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemo {
	WebDriver d;
	  
	@Test
	public void softassert(){
		
		d=new FirefoxDriver();
		
		SoftAssert asst=new SoftAssert(); 
		
		System.out.println("method 1");
		d.get("wwww");
		asst.assertEquals(5,8);
		System.out.println("method 2");
		Assert.assertTrue(true);
		System.out.println("method 3");
		asst.assertTrue(false);
		System.out.println("method 4");
		asst.assertAll();
	}

}
