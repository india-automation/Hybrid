package maven.big.test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.driver.driverFactory;

import junit.framework.Assert;

public class NewTest6  extends driverFactory{
	
	
  NewTest6() throws IOException {
	super();
	}
  
  @BeforeTest
  public void setUp()
  {
	  initdriver();
  }
  @Test(invocationCount=10,threadPoolSize=10)
  public void login() {
    
	 driver.findElement(By.name("userName")).sendKeys(prop.getProperty("username"));
	 driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	 driver.findElement(By.name("submit")).click();
	 String title=driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Login: Mercury Tours", title);
  }
  
  @Test(dependsOnMethods="login")
  public void test2()
  {
	  System.out.println("Depends on next test case");
  }
  @Test
   public void testSkipException() {
	  
	  String a="Skip/Ignore Test";
	  if(a.equals("Skip/Ignore Test"))
	  {
	  throw new SkipException("skipping this one test case");
	  }else
	  {
		  System.out.println("else part");
	  }
  }
  @Test
  public void userDefineException() throws userDefineException
  {
	  throw new userDefineException("not allowed");
  }
  @AfterTest
  public void tearDown() throws InterruptedException
  {
	  Thread.sleep(5000);
	  driver.close();
  }
}
