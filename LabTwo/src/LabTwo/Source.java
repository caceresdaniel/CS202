package LabTwo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Source {

	public static void main(String[] args) {
		int choice = 0;
		int amountOfTimesCorrect = 0;
		do {
			Scanner input = new Scanner(System.in);

			List<String> listOfNames = listMaker();

			System.out.print("What would you like to do: " + "\n1.Easy Problem." + "\n2.Hard Problem." + "\n3.Quit.\n");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				int numberOfTimesCorrect = easyProblem(listOfNames);
				System.out.println("You were correct " + numberOfTimesCorrect + " time(s).");
				break;
			case 2:
				int correctAnswersForHardProblem = hardProblem(listOfNames);
				System.out.println("You were correct " + correctAnswersForHardProblem + " time(s).");
				break;

			}

		} while (choice != 3);
	}

	public static int easyProblem(List<String> listOfNames) {
		int day = 0;
		int inCharge = 0;
		int amountOfTimesCorrect = 0;
		boolean answer = true;
		do {

			Scanner input = new Scanner(System.in);
			inCharge = day % listOfNames.size();
			listOfNames.get(inCharge);

			String output = "Day " + day + ": " + listOfNames.get(inCharge) + " must do the dishes.";

			System.out.println("Copy and enter the whole string that has been printed.");
			System.out.println(output);

			String userInput = input.nextLine();

			if (output.equals(userInput))
				amountOfTimesCorrect++;
			else
				answer = false;

			day++;
		} while (answer);
		return amountOfTimesCorrect;
	}

	public static int hardProblem(List<String> listOfNames) {

		int day = 0;
		int inCharge = 0;
		int amountOfTimesCorrect = 0;
		boolean answer = true;
		do {

			Scanner input = new Scanner(System.in);
			inCharge = day % listOfNames.size();
			listOfNames.get(inCharge);

			System.out.println("input: ");

			String userInput = input.nextLine();

			if (listOfNames.get(inCharge).equals(userInput))
				amountOfTimesCorrect++;
			else
				answer = false;

			day++;
		} while (answer);

		return amountOfTimesCorrect;
	}

	public static List<String> listMaker() {
		Scanner input = new Scanner(System.in);

		String nameInput = input.toString();

		List<String> listOfNames = new ArrayList<String>();

		System.out.print("Enter the number of children: ");
		int numOfChildren = input.nextInt();
		input.nextLine();

		for (int i = 0; i < numOfChildren; i++) {
			System.out.print("Enter a name: \n");
			listOfNames.add(input.nextLine());
		}

		return listOfNames;
	}
}
