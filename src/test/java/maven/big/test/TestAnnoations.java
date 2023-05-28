package maven.big.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAnnoations {
  @Test
  public void f() {
	  System.out.println("inside test case");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside before method");
  }

  @AfterMethod
  public void afterMethod() {
   System.out.println("Inside after method");
  }

  @BeforeClass
  public void beforeClass() {
  System.out.println("inside before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside after class");
	  
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside before test");
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside after test");
	  
  }

  @BeforeSuite
  public void beforeSuite() {
      System.out.println("inside before suite");
	  
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside after suite");
	  
  }
}
