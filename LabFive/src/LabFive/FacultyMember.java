package LabFive;

import java.util.ArrayList;
import java.util.List;

public class FacultyMember extends Person {
	private int employeeID;
	private List<Course> teachingSchedule;

	public FacultyMember() {
		
	}

	public FacultyMember(int employeeIDIn) {
		employeeID = employeeIDIn;
		teachingSchedule = new ArrayList<Course>();
	}

	public FacultyMember(int employeeIDIn, String personsNameIn, Address personsAddressIn) {
		super(personsNameIn, personsAddressIn);
		employeeID = employeeIDIn;
		teachingSchedule = new ArrayList<Course>();
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public List<Course> getCourses() {
		return teachingSchedule;
	}

	public void addCourse(Course course) {
		teachingSchedule.add(course);
	}

	public void dropCourse(Course course) {
		teachingSchedule.remove(course);
	}

	public String toString() {

		String stringVersionOfTeachingSchedule = "";

		if (teachingSchedule.isEmpty()) {
			stringVersionOfTeachingSchedule = "No Courses To Display";
		} else if (!(teachingSchedule.isEmpty())) {
			for (int i = 0; i < teachingSchedule.size(); i++)
				stringVersionOfTeachingSchedule += teachingSchedule.get(i);
		}

		return personsName + "'s Information" + "\n" + "  Employee ID #: " + String.valueOf(employeeID) + "\n"
				+ "  Employee Address: " + personsAddress + "\n" + "  Employee Teaching Schedule: \n"
				+ stringVersionOfTeachingSchedule + "\n";
	}

}
