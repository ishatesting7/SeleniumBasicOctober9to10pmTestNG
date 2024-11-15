package day11;

import org.testng.annotations.Test;

public class AttributeDemo2 {

	//Description
	
	@Test(description = "This is related to INF-123", priority = 3)
	void demo1() {
		System.out.println("2 Description - 1");
	}

	@Test(description = "This is related to INF-123", priority = 1)
	void demo2() {
		System.out.println("2 Description - 2");

	}
	//DependsOnMethods
	@Test(dependsOnMethods = {"demo1", "demo2"})
	void demo3()
	{
		System.out.println("3 Description - 3");
	}

	
	
}
