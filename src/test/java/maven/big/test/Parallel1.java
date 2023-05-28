package maven.big.test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.driver.driverFactory;

@Listeners(com.listener.ListenerDemo.class)
public class Parallel1 extends driverFactory{

	
	public Parallel1() throws IOException {
		super();
	}
	@BeforeTest
	public void launchBrowser() {
	
		initdriver();
	}
	@Test
	public void test11()
	{
		System.out.println("inside test 11");
	}
	@Test
	public void test12()
	{
		System.out.println("inside test 12");
	}
	@Test
	public void test13()
	{
		System.out.println("inside test 13");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	@Test(retryAnalyzer=com.listener.RetryAnalyzer.class)
	public void test14()
	{
		int a=20;
		System.out.println(a/0);
	}
	@Test(enabled=false)
	public void test15()
	{
		System.out.println("inside test 15");
	}
}

