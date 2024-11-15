package day11;

import org.testng.annotations.Test;

public class AttributeDemo {
	
	// Priority
	/*
	 * @Test(priority = 1) void _demo1() { System.out.println("HELLO1"); }
	 * 
	 * @Test(priority = 2) void $demo2() { System.out.println("HELLO2");
	 * 
	 * }
	 * 
	 * @Test(priority = 3) void demo3() { System.out.println("HELLO3"); }
	 * 
	 * @Test(priority = -12) void demo4() { System.out.println("HELLO4"); }
	 */
	
	//Invocation Count

	/*
	@Test(invocationCount = 5)
	void Demo1() {
		System.out.println("Invocation Count Demo");

	}
	*/
	
	//Enabled 
	/*
	@Test(enabled = true)
	void Demo1()
	{
		System.out.println("Enabled Demo");

	}
	*/
	//Timeout
	/*
	@Test(timeOut=1000)
	void Demo1() throws InterruptedException
	{
		Thread.sleep(1200);
		System.out.println("Time Out Demo");
	}
	*/

}
