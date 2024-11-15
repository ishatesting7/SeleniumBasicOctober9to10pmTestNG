package day12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentDemoDataProvider {

	@DataProvider(name = "DPname")
	public static StudentDemo[] myDataProvider() {
		return new StudentDemo[] { new StudentDemo("abc", 43, "male"), new StudentDemo("neha", 44, "female") };
	}

	@Test(dataProvider = "DPname")
	public void methodWithAttribute(StudentDemo a) {
		if (a.validateAge()) {
			System.out.println("Student Details If- " + a.age + " " + a.name + " " + a.gender);
		} else {
			System.out.println("Student Details Else - " + a.age + " " + a.name + " " + a.gender);

		}
	}

}
