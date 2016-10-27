package LabFive;

public class Course {

	private String courseIdentifier;
	private String courseTitle;

	public Course() {
	}

	public Course(String courseIdentifierIn, String courseTitleIn) {
		courseIdentifier = courseIdentifierIn;
		courseTitle = courseTitleIn;

	}

	public String getCourseIdentifier() {
		return courseIdentifier;

	}

	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String toString() {
		return courseIdentifier + " " + courseTitle + "\n";
	}

}
