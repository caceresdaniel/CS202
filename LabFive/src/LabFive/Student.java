package LabFive;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	private int studentCIN;
	private List<Course> courseList;

	public Student() {

	}

	public Student(int studentCINIn) {
		studentCIN = studentCINIn;
		courseList = new ArrayList<Course>();

	}

	public Student(int studentCINIn, String personsNameIn, Address personsAddressIn) {
		super(personsNameIn, personsAddressIn);
		studentCIN = studentCINIn;
		courseList = new ArrayList<Course>();

	}

	public int getStudentCIN() {
		return studentCIN;
	}

	public void setStudentCIN(int studentCIN) {
		this.studentCIN = studentCIN;
	}

	public List<Course> getCourses() {
		return courseList;
	}

	public void addCourse(Course course) {
		courseList.add(course);
	}

	public void dropCourse(Course course) {
		courseList.remove(course);
	}

	public String toString() {

		String stringVersionOfCourseList = "";

		if (courseList.isEmpty()) {
			stringVersionOfCourseList = "No Courses to Display.";
		} else if (!(courseList.isEmpty())) {
			for (int i = 0; i < courseList.size(); i++)
				stringVersionOfCourseList += courseList.get(i);
		}

		return personsName + "'s information" + "\n" + "  CIN #: " + studentCIN + "\n" + "  Students Address: "
				+ personsAddress + "\n" + "  Courses: \n" + stringVersionOfCourseList + "\n";
	}

}
