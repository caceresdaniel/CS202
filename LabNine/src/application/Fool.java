package application;

public class Fool {
	private int turns = 0;
	private int row;
	private int col;
	private boolean mcCreeGameOver = false;
	private boolean winstonGameOver = false;

	public boolean getWinstonGameOver() {
		return winstonGameOver;
	}

	public void setWinstonGameOver(boolean winstonGameOver) {
		this.winstonGameOver = winstonGameOver;
	}

	public Fool() {
	}

	public boolean getMcCreeGameOver() {
		return mcCreeGameOver;
	}

	public int getRow() {
		return row;
	}

	public int getTurns() {
		return turns;
	}

	public int getCol() {
		return col;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setMcCreeGameOver(boolean mcCreeGameOver) {
		this.mcCreeGameOver = mcCreeGameOver;
	}
}