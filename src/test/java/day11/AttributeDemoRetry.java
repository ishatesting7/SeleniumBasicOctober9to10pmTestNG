package day11;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class AttributeDemoRetry {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testMethod() {
		System.out.println("Running Test Method 1");
		assert false;
	}
}
