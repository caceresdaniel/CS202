package application;

import javax.swing.JOptionPane;

public class SelectionScreen {
	private int turnsToMove;
	private int turnsToComeOut;
	private int howManyWins;
	
	public int getTurnsToMove() {
		return turnsToMove;
	}

	public void setTurnsToMove(int turnsToMove) {
		this.turnsToMove = turnsToMove;
	}

	public int getTurnsToComeOut() {
		return turnsToComeOut;
	}

	public void setTurnsToComeOut(int turnsToComeOut) {
		this.turnsToComeOut = turnsToComeOut;
	}

	public int getHowManyWins() {
		return howManyWins;
	}

	public void setHowManyWins(int howManyWins) {
		this.howManyWins = howManyWins;
	}

	public SelectionScreen(){
		
	}
	
	public void selectionMenu(){
		String[] options = { "Easy", "Hard", "Super Hard", "Custom"};
		
		int selection = JOptionPane.showOptionDialog(null, "Choose A Difficulty!", "Main Menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		
		switch(selection){
		case 0:
			setTurnsToMove(1);
			setTurnsToComeOut(3);
			setHowManyWins(6);
			break;
		case 1:
			setTurnsToMove(2);
			setTurnsToComeOut(6);
			setHowManyWins(10);
			break;
		case 2:
			setTurnsToMove(2);
			setTurnsToComeOut(3);
			setHowManyWins(15);
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Not Yet Implemented");
		}
		
	}

}
