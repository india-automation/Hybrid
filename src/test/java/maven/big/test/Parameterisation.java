package maven.big.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.driver.driverFactory;

public class Parameterisation extends driverFactory {
  
	
	public Parameterisation() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod()
	public void browsersetup() {
		initdriver();
	}
  @Parameters({"username","password"})	
  @Test
  public void tetsFirstClass(String user, String pass) {

	  System.out.println(user);
	  System.out.println(pass);
  }
  @Test(enabled=false)
  public void testSecondCase()
  {
	  System.out.println("skipping this test");
  }
  @AfterMethod()
  public void tearDown()
  {
	 if(prop!=null)
	 {
		 driver.close();
	 }
  }
}
