package maven.big.test;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {

	
	@Test
	public void soft()
	{
		
        SoftAssert ass= new SoftAssert();
		int a=204,b=20;
		ass.assertEquals(a, b);
		System.out.println("Soft Assertion fail..");
		ass.assertAll();
		
	}

	@Test
	public void hard()
	{
		
        Assertion asse= new Assertion();
		int a=204,b=20;
		asse.assertEquals(a, b);
		System.out.println("Assertion fail..");
	}
}
