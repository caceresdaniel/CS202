package LabFive;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Driver {
	private List<Student> students = new ArrayList<Student>(); 
	private List<FacultyMember> facultyMembers = new ArrayList<FacultyMember>();
	private List<Course> courses = new ArrayList<Course>();

	public static void main(String[] args) {
		Driver pleaseRun = new Driver();
		pleaseRun.monitor();
	}

	public void monitor() {

		String[] options = { "Quit", "Fill it up", "Add Information", "Delete Information", "List Information",
				"Add Course to Schedule", "Drop Course from Schedule"};

		int selection;

		do {
			selection = JOptionPane.showOptionDialog(null, "What would you like to do?", "Main Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

			switch (selection) {
			case 1:
				fillItUp();
				break;
			case 2:
				addInformationMenu();
				break;
			case 3:
				deleteInformationMenu();
				break;
			case 4:
				listInformationMenu();
				break;
			case 5:
				if (!(courses.isEmpty()))
					addCourseMenu();
				else if (courses.isEmpty())
					JOptionPane.showMessageDialog(null, "No Courses to Add!");
				break;
			case 6:
				dropCourseMenu();
				break;
			}

		} while (selection != 0);
	}

	public void addCourseMenu() {

		String[] options = { "Faculty Member", "Student" };

		int selection;

		selection = JOptionPane.showOptionDialog(null, "For who would you like to Add a Class for?", "Add or Drop Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

		switch (selection) {
		case 0:
			facultyMemberAddCourse();
			break;
		case 1:
			studentAddCourse();
			break;
		}

	}

	private void facultyMemberAddCourse() {

		listFacultyMemberInformation();

		int facultyMemberEmployeeID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your Employee ID #: "));

		int choice = JOptionPane.showOptionDialog(null, "Choose A Course to Add", "Menu", 0,
				JOptionPane.QUESTION_MESSAGE, null, courses.toArray(), "null");

		for (int i = 0; i < facultyMembers.size(); i++)
			if (facultyMemberEmployeeID == facultyMembers.get(i).getEmployeeID())
				facultyMembers.get(i).addCourse(courses.get(choice));

	}

	private void studentAddCourse() {

		listStudentInformation();

		int studentCINNum = Integer.parseInt(JOptionPane.showInputDialog("Enter your CIN #: "));

		int choice = JOptionPane.showOptionDialog(null, "Choose A Course to Add", "Menu", 0,
				JOptionPane.QUESTION_MESSAGE, null, courses.toArray(), "null");

		for (int i = 0; i < students.size(); i++)
			if (studentCINNum == students.get(i).getStudentCIN())
				students.get(i).addCourse(courses.get(choice));

	}

	public void dropCourseMenu() {

		String[] options = { "Faculty Member", "Student" };

		int selection;

		selection = JOptionPane.showOptionDialog(null, "For who would you like to Drop a Class for?",
				"Add or Drop Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

		switch (selection) {
		case 0:
			facultyMemberDropCourse();
			break;
		case 1:
			studentDropCourse();
			break;
		}

	}

	private void facultyMemberDropCourse() {
		listFacultyMemberInformation();

		int facultyMemberIDNum = Integer.parseInt(JOptionPane.showInputDialog("Enter your Employee ID #: "));

		String courseIdentifier = JOptionPane
				.showInputDialog("Enter the Course Identifier of the Course you wish to drop: ");

		int thisIndex = 0;

		for (int j = 0; j < courses.size(); j++)
			if (courseIdentifier.matches(courses.get(j).getCourseIdentifier()))
				thisIndex = j;

		for (int i = 0; i < facultyMembers.size(); i++) {
			if (facultyMemberIDNum == facultyMembers.get(i).getEmployeeID()) {
				facultyMembers.get(i).dropCourse(courses.get(thisIndex));
			}
		}

	}

	private void studentDropCourse() {
		listStudentInformation();

		int studentCINNum = Integer.parseInt(JOptionPane.showInputDialog("Enter your Student CIN #: "));

		String courseIdentifier = JOptionPane
				.showInputDialog("Enter the Course Identifier of the Course you wish to drop: ");

		int thisIndex = 0;

		for (int j = 0; j < courses.size(); j++)
			if (courseIdentifier.matches(courses.get(j).getCourseIdentifier()))
				thisIndex = j;

		for (int i = 0; i < students.size(); i++) {
			if (studentCINNum == students.get(i).getStudentCIN()) {
				students.get(i).dropCourse(courses.get(thisIndex));
			}
		}

	}

	public void addInformationMenu() {

		String[] options = { "Course", "Faculty Member", "Student" };

		int selection;

		selection = JOptionPane.showOptionDialog(null, "For who would you like to Add Information for?",
				"Add Information Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

		switch (selection) {
		case 0:
			addCourseInformation();
			break;
		case 1:
			addFacultyMemberInformation();
			break;
		case 2:
			addStudentInformation();
			break;
		}
	}

	private void addCourseInformation() {

		String courseIdentifierIn = JOptionPane.showInputDialog("Please Enter the Course Identifier: ");
		String courseTitleIn = JOptionPane.showInputDialog("Please Enter the Course Title: ");

		courses.add(new Course(courseIdentifierIn, courseTitleIn));
	}

	private void addFacultyMemberInformation() {
		String personsNameIn = JOptionPane.showInputDialog("Please enter the Faculty Members Name: ");

		String personsAddressIn = JOptionPane.showInputDialog(
				"Please enter Address information seperated by commas(e.g. Street #, Street Name, City, State or Province, Country: ");

		int employeeIDIn = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Employee ID #: "));

		String[] afterSplit = personsAddressIn.split(", ");

		facultyMembers.add(new FacultyMember(employeeIDIn, personsNameIn, new Address(Integer.parseInt(afterSplit[0]),
				afterSplit[1], afterSplit[2], afterSplit[3], afterSplit[4])));
	}

	private void addStudentInformation() {

		String personsNameIn = JOptionPane.showInputDialog("Please enter the Students Name: ");

		String personsAddressIn = JOptionPane.showInputDialog(
				"Please enter Address information seperated by commas(e.g. Street #, Street Name, City, State or Province, Country: ");

		int studentCINIn = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Student CIN #: "));

		String[] afterSplit = personsAddressIn.split(", ");

		students.add(new Student(studentCINIn, personsNameIn, new Address(Integer.parseInt(afterSplit[0]),
				afterSplit[1], afterSplit[2], afterSplit[3], afterSplit[4])));

	}

	public void deleteInformationMenu() {
		String[] options = { "Faculty Member", "Student" };

		int selection;

		selection = JOptionPane.showOptionDialog(null, "For who would you like to Delete Information for?",
				"Delete Information Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

		switch (selection) {
		case 0:
			if (!(facultyMembers.isEmpty()))
				deleteFacultyMemberInformation();
			else if (facultyMembers.isEmpty())
				JOptionPane.showMessageDialog(null, "No Faculty Member information to Delete!");
			break;
		case 1:
			if (!(students.isEmpty()))
				deleteStudentInformation();
			else if (students.isEmpty())
				JOptionPane.showMessageDialog(null, "No Student information to Delete!");
			break;
		}

	}

	private void deleteFacultyMemberInformation() {
		listFacultyMemberInformation();

		int userEmployeeIDChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter the Employee ID # corresponding to the information you would like to Delete: "));

		for (int i = 0; i < facultyMembers.size(); i++) {
			if (userEmployeeIDChoice == facultyMembers.get(i).getEmployeeID())
				facultyMembers.remove(i);
		}

		JOptionPane.showMessageDialog(null, "Employee ID # " + userEmployeeIDChoice + " Was Fired! ");

	}

	private void deleteStudentInformation() {
		listStudentInformation();

		int userStudentCINChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter the CIN # corresponding to the information you would like to Delete"));

		for (int i = 0; i < students.size(); i++)
			if (userStudentCINChoice == students.get(i).getStudentCIN())
				students.remove(i);

		JOptionPane.showMessageDialog(null,
				"Student with the  CIN # of " + userStudentCINChoice + " Dropped out of school!");

	}

	public void listInformationMenu() {
		String[] options = { "Courses", "Faculty Member", "Student" };

		int selection;

		selection = JOptionPane.showOptionDialog(null, "Which Information would you like to list?",
				"List Information Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

		switch (selection) {
		case 0:
			if (!(courses.isEmpty()))
				JOptionPane.showMessageDialog(null, courses.toArray());
			else if (courses.isEmpty())
				JOptionPane.showMessageDialog(null, "No courses to display!");
			break;
		case 1:
			if (!(facultyMembers.isEmpty()))
				JOptionPane.showMessageDialog(null, facultyMembers.toArray());
			else if (facultyMembers.isEmpty())
				JOptionPane.showMessageDialog(null, "No Faculty Member information to List!");
			break;
		case 2:
			if (!(students.isEmpty()))
				JOptionPane.showMessageDialog(null, students.toArray());
			else if (students.isEmpty()) 
				JOptionPane.showMessageDialog(null, "No Student information to List!");
			break;
		}

	}

	private void listFacultyMemberInformation() {
		String facultyMemberInformation = "";
		for (int i = 0; i < facultyMembers.size(); i++)
			facultyMemberInformation += facultyMembers.get(i);
		JOptionPane.showMessageDialog(null, facultyMemberInformation);

	}

	private void listStudentInformation() {
		String studentInformation = "";
		for (int i = 0; i < students.size(); i++)
			studentInformation += students.get(i);
		JOptionPane.showMessageDialog(null, studentInformation);

	}

	private void fillItUp() {
		students.add(new Student(305879456, "Daniel", new Address(15239, "Cantlay ST", "Van Nuys", "CA", "USA")));
		students.add(new Student(307895241, "Erik", new Address(16578, "Woodley Ave", "Grannada Hills", "CA", "USA")));
		facultyMembers
				.add(new FacultyMember(458, "Jimmy", new Address(13238, "Winnetka Ave", "Mission Hils", "CA", "USA")));
		facultyMembers.add(new FacultyMember(956, "Sarah", new Address(18754, "White Oak", "Reseda", "CA", "USA")));
		courses.add(new Course("CS-2012", "Object Oriented Programing"));
		courses.add(new Course("EE-3034", "Electrical Engineering"));
		courses.add(new Course("HIST-1050", "World History"));
	}

}
