package day12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderDemo {

	public String intMethod() {
		return "Heello";
	}

	// ASCII - American Standard Code for Information and Interchange
	@DataProvider(name = "testDataP", parallel = true)
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "Lorem Ipsum", 839, 929 }, { "Lorem Ipsum 1", 840, 23 }, { "Lorem Ipsum 2", 841, 399 }

		};
	}

	@Test(dataProvider = "testDataP")
	void DPMethod(String l, int m, int n) {
		System.out.println("Input 1 - " + l + "Input 2 - " + m + "Input 3 - " + n);
	}

	@Test(expectedExceptions = ArithmeticException.class)
	void MethodException() {
		int a = 1 / 0;
	}

	public int count = 0;

	@Test(successPercentage = 40, invocationCount = 6)
	void Demo1() {
		count++;

		if (count % 2 == 0) {
			System.out.println("Test Passed on Attempt - " + count);
		} else {
			System.out.println("Test Has Failed on Attempt - " + count);
			throw new RuntimeException("Simulated Response");
		}
	}
}
