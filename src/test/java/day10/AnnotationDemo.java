package day10;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationDemo {

	@BeforeSuite
	void beforeSuiteDemo() {
		System.out.println("I am in Before Suite Demo");
	}

	@AfterSuite
	void afterSuiteDemo() {
		System.out.println("I am in After Suite Demo");

	}

	@BeforeMethod
	void beforeMethodDemo() {
		System.out.println("I am in Before method Demo");

	}

	@AfterMethod
	void afterMethodDemo() {
		System.out.println("I am in After method Demo");

	}

	@BeforeTest
	void beforeTestMethod() {
		System.out.println("I am in Before test Demo");

	}

	@AfterTest
	void afterTestMethod() {
		System.out.println("I am in After test Demo");

	}

	@BeforeClass
	void beforeClassDemo() {
		System.out.println("I am in Before Class Demo");
	}

	@AfterClass
	void afterClassDemo() {
		System.out.println("I am in After Class Demo");
	}

	@Test
	void DemoTest() {
		System.out.println("I am in actual Test");

	}
}

// Before Suite --> Before Test --> Before Class --> Before method --> TEST

