package MonsterTime;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AttackMonitor {

	private List<MonsterAttack> monsterAttacks = new ArrayList<MonsterAttack>();

	public void monitor() {

		String[] options = { "Quit", "Input a New Monster Attack", "Show List of Attacks", "Delete an Attack" };

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
			}

		} while (selection != 0);
	}

	private void addMonsterAttack() {

		int attackIdIn = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Attack ID #: "));

		String monsterNameIn = JOptionPane.showInputDialog("Please Enter the Monster Name: ");

		String fullDateIn = JOptionPane.showInputDialog("Please Enter the Date the attack occured on (dd/mm/yyyy): ");

		int attackVictimsIn = Integer.parseInt(JOptionPane.showInputDialog("How many fatalities were there? "));

		String attackLocationIn = JOptionPane.showInputDialog("Where did this happen? ");

		monsterAttacks.add(new MonsterAttack(fullDateIn, attackIdIn, attackVictimsIn, monsterNameIn, attackLocationIn));

	}

	private void showMonsterAttacks() {

		for (int i = 0; i < monsterAttacks.size(); i++)
			JOptionPane.showMessageDialog(null, monsterAttacks.get(i));

	}

	private void deleteMonsterAttack() {

		showMonsterAttacks();

		List<MonsterAttack> choice = new ArrayList<MonsterAttack>();

		choice = JOptionPane.showInputDialog("Enter the ID # of the Monster attack you would like to delete: ");
		for (int i = 0; i < monsterAttacks.size();) {
			if (choice == monsterAttacks.get(i))
				monsterAttacks.remove(i);
		}
	}
}
