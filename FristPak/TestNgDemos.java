package FristPak;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemos {
	@BeforeSuite
	public void aa(){
		System.out.println("@Beforesuit" );
	}
	@AfterSuite
	public void aaa(){
		System.out.println("@Aftersuite" );
	}
	@BeforeGroups
	public void bb(){
		System.out.println("@Beforegrop" );
	}
	@AfterGroups
	public void cc(){
		System.out.println("@aftergrop" );
	}
	   
	@Test
	public void a(){
		System.out.println("@test" );
	}
	@BeforeTest
	public void b(){
		System.out.println("@BeforeTest" );
	}
	@AfterTest
	public void c(){
		System.out.println("@AfterTest" );
	}
	
	@BeforeClass
	public void d(){
		System.out.println("@Beforeclass" );
	}
	@AfterClass
	public void e(){
		System.out.println("@Afterclass" );
	}
	@BeforeMethod
	public void f(){
		System.out.println("@Beforemethod" );
	}
	@AfterMethod
	public void g(){
		System.out.println("@aftermethod" );
	}
	@Test
	public void h(){
		System.out.println("@test" );
	}
	   
	   
	   
	   
	   
	   
	   
}
