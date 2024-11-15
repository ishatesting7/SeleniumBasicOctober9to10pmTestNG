package day12;

public class StudentDemo {

	String name;
	int age;
	String gender;

	public StudentDemo(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;

	}

	public boolean validateAge() {
		if (this.age > 2) {
			System.out.println("You are eligible for Registration - ");
			return true;
		} else
			return false;
	}

}
