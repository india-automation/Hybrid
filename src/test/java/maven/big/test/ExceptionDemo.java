package maven.big.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class ExceptionDemo {
  
	
  @Test(enabled=false)
  public void Test1() {
	  
	  System.out.println("Skipping test cases");
  }
  
  @Test(priority=2)
  public void test2(){
	  System.out.println("forceful Skipping test cases");
	  throw new SkipException("forceful Skip the test case");
	  
  }
  @Test(priority=1)
  public void test3() {
	  String mess="skip";
	  
	  if(mess.equals("skip")) {
		  
		  throw new SkipException("conditional Skip this test case as well.");
	  }else {
		  System.out.println("Conditional Execute the tets cases...!");
	  }
  }
}
