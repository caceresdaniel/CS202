package application;

public class Bull {
	private int row;
	private int col;

	public Bull() {

	}

	public Bull(int rowIn, int colIn) {
		row = rowIn;
		col = colIn;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void foolChase(StreetMap sm, Fool foo, int bullRow, int bullCol) {

		if (bullRow == foo.getRow()) {
			for (int x = bullCol; x < foo.getCol(); x++)
				if (sm.coords[x][foo.getRow()].getValue() == 'W') {
					break;
				} else if (sm.coords[bullCol + 1][bullRow].getValue() != 'W') {
					sm.coords[bullCol + 1][bullRow].setValue('B');
					sm.coords[bullCol][bullRow].setValue(' ');
					setCol(bullCol + 1);
				}

		} else if (bullCol == foo.getCol()) {
			for (int x = bullRow; x < foo.getRow(); x++)
				if (sm.coords[foo.getCol()][x].getValue() == 'W') {
					break;
				} else if (sm.coords[bullCol][bullRow + 1].getValue() != 'W') {
					sm.coords[bullCol][bullRow + 1].setValue('B');
					sm.coords[bullCol][bullRow].setValue(' ');
					setRow(bullRow + 1);
				}
		} else {
			if ((int) (Math.random() * 2) == 0 && sm.coords[bullCol][bullRow + 1].getValue() != 'W') {
				sm.coords[bullCol][bullRow + 1].setValue('B');
				sm.coords[bullCol][bullRow].setValue(' ');
				setRow(bullRow + 1);
			} else if ((int) (Math.random() * 2) == 1 && sm.coords[bullCol + 1][bullRow].getValue() != 'W') {
				sm.coords[bullCol + 1][bullRow].setValue('B');
				sm.coords[bullCol][bullRow].setValue(' ');
				setCol(bullCol + 1);
			} else if ((int) (Math.random() * 2) == 1 && sm.coords[bullCol + 1][bullRow].getValue() == 'W') {
				if (sm.coords[bullCol - 1][bullRow].getValue() != 'W' && sm.coords[bullCol][bullRow - 1].getValue() != 'S') {
					sm.coords[bullCol - 1][bullRow].setValue('B');
					sm.coords[bullCol][bullRow].setValue(' ');
					setCol(bullCol - 1);
				}
			} else if ((int) (Math.random() * 2) == 0 && sm.coords[bullCol][bullRow + 1].getValue() == 'W') {
				if (sm.coords[bullCol][bullRow - 1].getValue() != 'W' && sm.coords[bullCol][bullRow - 1].getValue() != 'S') {
					sm.coords[bullCol][bullRow - 1].setValue('B');
					sm.coords[bullCol][bullRow].setValue(' ');
					setRow(bullRow - 1);
				}
			}

		}

	}

	public String toString() {
		return String.valueOf(row) + " " + String.valueOf(col);
	}
}