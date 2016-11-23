package application;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MazeGUIPane extends Application {
	Boolean gameOver = false;
	GridPane gp = new GridPane();
	StreetMap sm = new StreetMap();
	Coordinate c = new Coordinate();
	Label fool = new Label();
	Bull bull = new Bull();
	Fool fu = new Fool();
	VBox vb = new VBox();
	int turnCount = 0;
	int row, col;
	int foolRow = 1;
	int foolCol = 1;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Lab 9");

			vb.getStyleClass().add("vbox");

			Label title = new Label("Map of Pamplona");
			title.getStyleClass().add("title");

			Scene sc = new Scene(vb);
			sc.getStylesheets().add("styles/style.css");

			Button butt = new Button("Start");
			butt.getStyleClass().add("button");

			startGame(butt, gp);

			sm.setGrid();
			createGrid();

			vb.getChildren().addAll(title, gp, butt);

			System.out.println(sm.coords[2][3].getValue());
			foolController();

			primaryStage.setScene(sc);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createGrid() {
		for (row = 0; row < 20; row++)
			for (col = 0; col < 20; col++) {

				Label l = new Label();

				char cords = sm.coords[row][col].getValue();

				if (cords == 'S') {
					l.setText("Start");
					l.getStyleClass().add("startOrFinish");

				} else if (cords == 'E') {
					l.setText("Finish");
					l.getStyleClass().add("startOrFinish");
				} else if (cords == 'W') {
					l.getStyleClass().add("walls");
				} else if (cords == ' ') {
					l.getStyleClass().add("path");
				} else if (cords == 'P') {
					l.getStyleClass().add("player");
				} else if (cords == 'B') {
					l.getStyleClass().add("bulls");
				}

				boxChanger(l);

				gp.add(l, row, col);
			}

	}

	public void boxChanger(Label l) {
		// method that changes the boxes from either path or to wall
		l.setOnMouseClicked(e -> {
			int specCol = GridPane.getRowIndex(l);
			int specRow = GridPane.getColumnIndex(l);
			char specCords = sm.coords[specRow][specCol].getValue();

			if (specCords == 'W') {
				l.getStyleClass().removeAll("walls");
				l.getStyleClass().add("path");

				sm.coords[specRow][specCol] = new Coordinate(specRow, specCol, ' ');

			} else if (specCords == ' ') {
				l.getStyleClass().removeAll("path");
				l.getStyleClass().add("walls");

				sm.coords[specRow][specCol] = new Coordinate(specRow, specCol, 'W');
			}
		});
	}

	public void startGame(Button butt, GridPane gp) {
		// When the start button is pressed the player is added to the grid
		// and can be controlled by the method called later on
		butt.setOnMouseClicked(e -> {
			turnCount = 0;
			System.out.println(fu.getTurns());
			if (gameOver = true) {
				sm.setGrid();
				createGrid();
				gameOver = false;
			}

			JOptionPane.showMessageDialog(null, "Game Start!");
			fool.getStyleClass().add("player");

			// added the fool to the coordinate class
			sm.coords[foolRow][foolCol].setValue('P');

			// gp.add(fool, foolCol, foolRow);
		});
	}

	public void foolController() {
		// this method moves the fool according to where the user designates
		vb.setOnKeyPressed(e -> {
			int currentRow = 0, currentCol = 0;
			for (int i = 0; i < 20; i++)
				for (int j = 0; j < 20; j++) {
					if (sm.coords[i][j].getValue() == 'P') {
						currentRow = i;
						currentCol = j;
					}
				}
			if (e.getCode() == KeyCode.RIGHT) {
				if (sm.coords[currentRow + 1][currentCol].getValue() == ' ') {
					sm.coords[currentRow][currentCol].setValue(' ');
					sm.coords[currentRow + 1][currentCol].setValue('P');
					turnCount++;
					fu.setCol(currentCol);
					fu.setRow(currentRow + 1);
					System.out.println(sm.coords[2][3].getValue());
				} else if (sm.coords[currentRow + 1][currentCol].getValue() == 'E') {
					JOptionPane.showMessageDialog(null, "You Win!!!!!");
					gameOver = true;
				}
			} else if (e.getCode() == KeyCode.LEFT) {
				if (sm.coords[currentRow - 1][currentCol].getValue() == ' ') {
					sm.coords[currentRow][currentCol].setValue(' ');
					sm.coords[currentRow - 1][currentCol].setValue('P');
					turnCount++;
					fu.setCol(currentCol);
					fu.setRow(currentRow - 1);

				}
			} else if (e.getCode() == KeyCode.DOWN) {
				if (sm.coords[currentRow][currentCol + 1].getValue() == ' ') {
					sm.coords[currentRow][currentCol].setValue(' ');
					sm.coords[currentRow][currentCol + 1].setValue('P');
					turnCount++;
					fu.setCol(currentCol + 1);
					fu.setRow(currentRow);
				}
			} else if (e.getCode() == KeyCode.UP) {
				if (sm.coords[currentRow][currentCol - 1].getValue() == ' ') {
					sm.coords[currentRow][currentCol].setValue(' ');
					sm.coords[currentRow][currentCol - 1].setValue('P');
					turnCount++;
					fu.setCol(currentCol - 1);
					fu.setRow(currentRow);
				}
			}
			// updates the grid to show where the fool actually is
			fu.setTurns(turnCount);
			addBull();
			System.out.println(fu.getTurns());
			if (fu.getTurns() == 3) {
				bull.foolChase(sm);
			}
			createGrid();
		});
	}

	public void addBull() {
		if (fu.getTurns() % 3 == 0)
			sm.coords[1][1].setValue('B');
	}

	public static void main(String[] args) {
		launch(args);
	}
}
