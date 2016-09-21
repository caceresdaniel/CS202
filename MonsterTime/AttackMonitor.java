package MonsterTime;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

public class AttackMonitor {

	private List<MonsterAttack> monsterAttacks = new ArrayList<MonsterAttack>();

	public void monitor() {

		String[] options = { "Quit", "Input a New Monster Attack", "Show List of Attacks", "Delete an Attack",
				"Write to File", "Copy from File" };

		int selection;

		do {

			selection = JOptionPane.showOptionDialog(null, "What would you like to do?", "Main Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

			switch (selection) {

			case 1:
				addMonsterAttack();
				break;
			case 2:
				if (!(monsterAttacks.isEmpty()))
					showMonsterAttacks();
				else if (monsterAttacks.isEmpty())
					JOptionPane.showMessageDialog(null, "There are no Monster Attacks.");
				break;
			case 3:
				if (!(monsterAttacks.isEmpty()))
					deleteMonsterAttack();
				else if (monsterAttacks.isEmpty())
					JOptionPane.showMessageDialog(null, "There is nothing to delete.");
				break;

			case 4:
				if (!(monsterAttacks.isEmpty()))
					try {
						fileWriter();
					} catch (IOException e) {
						System.err.println(e);
						System.exit(1);
					}
				else if (monsterAttacks.isEmpty())
					JOptionPane.showMessageDialog(null, "There is nothing to copy.");
				break;
			case 5:
				try {
					clearAllDataAndCopy();
				} catch (IOException e) {
					System.err.println(e);
					System.exit(1);
				}
				break;

		} while (selection != 0);
	}

	private void addMonsterAttack() {

		int attackIdIn = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Attack ID #: "));

		String monsterNameIn = JOptionPane.showInputDialog("Please Enter the Monster Name: ");

		String fullDateIn = JOptionPane.showInputDialog("Please Enter the Date the attack occured on (MM/DD/YYYY): ");

		int attackVictimsIn = Integer.parseInt(JOptionPane.showInputDialog("How many fatalities were there? "));

		String attackLocationIn = JOptionPane.showInputDialog("Where did this happen? ");

		monsterAttacks.add(new MonsterAttack(fullDateIn, attackIdIn, attackVictimsIn, monsterNameIn, attackLocationIn));

	}

	private void showMonsterAttacks() {

		String wholeList = "";

		for (int i = 0; i < monsterAttacks.size(); i++)
			wholeList += monsterAttacks.get(i);

		JOptionPane.showMessageDialog(null, wholeList);

	}

	private void deleteMonsterAttack() {

		showMonsterAttacks();

		int choice = Integer.parseInt(
				JOptionPane.showInputDialog("Enter the ID # of the Monster attack you would like to delete: "));

		for (int i = 0; i < monsterAttacks.size(); i++) {
			if (choice == monsterAttacks.get(i).getAttackId())
				monsterAttacks.remove(i);

		}
	}

	private void fileWriter() throws IOException {

		String fileLocation = JOptionPane.showInputDialog(null, "Enter a file path to copy to: ");

		File outFile = new File(fileLocation);
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

		for (int i = 0; i < monsterAttacks.size(); i++) {
			writer.write(String.valueOf(monsterAttacks.get(i).getAttackId()));
			writer.write(" , ");
			writer.write(monsterAttacks.get(i).getMonsterName());
			writer.write(" , ");
			writer.write(monsterAttacks.get(i).getAttackLocation());
			writer.write(" , ");
			writer.write(monsterAttacks.get(i).getFullDate());
			writer.write(" , ");
			writer.write(String.valueOf(monsterAttacks.get(i).getAttackVictims()));
			writer.newLine();
		}
		writer.close();
	}

	private void clearAllDataAndCopy() throws IOException {

		if (!(monsterAttacks.isEmpty())) {
			for (int i = 0; i < monsterAttacks.size(); i++)
				monsterAttacks.remove(i);
		}
		String fileLocation = JOptionPane.showInputDialog(null, "Enter a file path to copy from: ");

		File inFile = new File(fileLocation);
		Scanner freader = new Scanner(inFile);

	}
}
