package day11;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class AttributeDemo3 {

	@Test(groups = "Smoke")
	void Demo1() {
		System.out.println(" I am in group 1");
	}

	@Test(groups = "Regression")
	void Demo2() {
		System.out.println(" I am in group 2");
	}

	@Test(groups = "Sanity")
	void Demo3() {
		System.out.println(" I am in group 3");
	}

	@Test(groups = "Smoke")
	void Demo4() {
		System.out.println(" I am in group 4");
	}

	@Test(groups = "Regression")
	void Demo5() {
		System.out.println(" I am in group 5");
	}

	@Test(groups = "Sanity")
	void Demo6() {
		System.out.println(" I am in group 6");
	}
}
