package day12;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterDemo {

	@Parameters({ "variable1" })
	@BeforeMethod
	public void beforeMethodParams(@Optional("BeforeMethod") String variable) {
		System.out.println("I am using parameter from xml - " + variable);

	}

	@Parameters({ "browser", "url" })
	@Test
	public void testMethod(@Optional("Mozilla") String browser, @Optional("mozilla.org") String url) {
		System.out.println("Browser - " + browser + " URL - " + url);

	}

	@Parameters({ "variable" })
	@AfterMethod
	public void afterMethodParams(@Optional("AfterMethod") String variable) {
		System.out.println("I am using parameter from xml - " + variable);

	}
	
	// 3 Environment
	// 3 Browser
	// Apache Poi
	
}
