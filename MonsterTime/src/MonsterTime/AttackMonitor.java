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
				break;
			case 2:
				if (!(monsterAttacks.isEmpty()))
					// method for this case
					break;
			case 3:
				if (!(monsterAttacks.isEmpty()))
					// method for this case
					break;
			}

		} while (selection != 0);
	}

}
