
package FristPak;

import org.testng.annotations.Test;

public class TestNgmethod {
	
	@Test(timeOut=80)
	public void a(){
		System.out.println("A" );
	}
	@Test(alwaysRun=true)
	public void f(){
		System.out.println("F");
	}
	@Test()
	public void c(){
		System.out.println("c");
	}
	@Test()
	public void b(){
		System.out.println("B");
		
	}
	@Test()
	public void d(){
		System.out.println("D");
	}

}
