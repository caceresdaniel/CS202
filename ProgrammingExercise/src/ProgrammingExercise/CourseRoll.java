package ProgrammingExercise;

import java.util.ArrayList;
import java.util.List;

public class CourseRoll {
	
	private List<Student> students = new ArrayList<Student>();
	int nextCIN = 1;
	Simulator sim = new Simulator();
	
	public static void main(String[] args){
		
		CourseRoll run = new CourseRoll();
		run.offerClass();
		
	}
	
	public void offerClass(){
		
			double[] randDoubles = new double[20];
		
			for(int i = 0; i < randDoubles.length; i++){
				randDoubles = sim.getGaussianData(2.56785, 3.34565, 20, 2, 4);
				
			}
		
			for(int i = 0; i < 10; i++){
				students.add(new Student(nextCIN, randDoubles[i]));
				nextCIN++;
			}
			
			String studentsString = "";
			for(int i = 0; i < students.size(); i++){
				studentsString += students.get(i);
			}
			System.out.println(studentsString);
				
	}
	
	

}
