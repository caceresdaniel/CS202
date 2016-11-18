package application;

public class StreetMap {
	Coordinate[][] coords = new Coordinate[20][20];

	public void setGrid() {
		for (int row = 0; row < 20; row++)
			for (int col = 0; col < 20; col++) {
				coords[row][col] = new Coordinate();
				if (row == 0 && col == 1) {
					coords[row][col] = new Coordinate(row, col, 'S');
				} else if (row == 19 && col == 18) {
					coords[row][col] = new Coordinate(row, col, 'E');
				} else if (row == 0 || col == 0 || col == 19 || row == 19) {
					coords[row][col] = new Coordinate(row, col, 'W');
				} else {
					int randNum = (int) (Math.random() * 5);
					if(randNum == 0){
					coords[row][col] = new Coordinate(row, col, 'W');
					}
					else {
						coords[row][col] = new Coordinate(row, col, ' ');
					}
				}
			}
	}
}


// keyevent.getcode() == KeyCode.DOWN