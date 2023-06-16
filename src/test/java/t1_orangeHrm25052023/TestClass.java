package t1_orangeHrm25052023;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

	@Test
	
	public void test1() {
		System.out.println("Test case is started");
		Assert.assertTrue(true);
		System.out.println("Test case point 1 ");
		Assert.assertTrue(false);
		System.out.println("Test case point 2 ");
		Assert.assertTrue(true);
		System.out.println("Test case point 3 ");
	}
}
