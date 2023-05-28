package maven.big.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.driver.driverFactory;

public class NewTest3 extends driverFactory {
	
	
	public NewTest3() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public void setupbrowser()
	{
		initdriver();
	}
	
  @Test(groups={"smoke"})
  public void f1() {
	  System.out.println("inside smoke test cases");
  }
  @Test(groups= {"smoke"})
  public void f2() {
	  System.out.println("inside smoke test cases");
	    
  }
  @Test(groups= {"sanity"})
  public void f3() {
	  System.out.println("inside sanity test cases");
	  
  }
  @Test(groups= {"smoke"})
  public void f4() {
	  System.out.println("inside smoke test cases");
	  
  }
  @Test(groups= {"sanity"})
  public void f5() {
	  System.out.println("inside sanity test cases");
	  
  }
  @Test(groups="sanity")
  public void f6() {
	  System.out.println("inside sanity test cases");
	  
  }
  @Test
  public void devidebyzero()
  {
	int a=10/0;
	System.out.println(a);
  }
  @Test(expectedExceptions= {ArithmeticException.class})
  public void devidebyzerohandle() {
	  
	  int c=10/0;
	  System.out.println(c);
  }
  
}

