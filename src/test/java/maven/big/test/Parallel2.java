package maven.big.test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.driver.driverFactory;



public class Parallel2 extends driverFactory{

	
	public Parallel2() throws IOException {
		super();
	}
	@BeforeTest
	public void launchBrowser() {
		
		initdriver();
		
	}
	@Test(retryAnalyzer=com.listener.RetryAnalyzer.class)
	public void test91()
	{
		System.out.println("inside test 91");
	}
	@Test
	public void test92()
	{
		System.out.println("inside test 92");
	}
	@Test
	public void test93()
	{
		System.out.println("inside test 93");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
