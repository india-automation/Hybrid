package maven.big.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class testngReport {

	@Test
	public void passTest() {
		
		Assert.assertTrue(true);
	}
	@Test
	public void failedTest() {
		Assert.assertTrue(false);
	}
	@Test
	public void skipTest() {
		
		throw new SkipException("test is under construction...");
	}
}
