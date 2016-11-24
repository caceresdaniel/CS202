package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MazeGUIPane extends Application {

	SelectionScreen menu = new SelectionScreen();
	List<Bull> bull = new ArrayList<Bull>();
	Label winston = new Label("You Lose!");
	Label mccree = new Label("You Win!");
	Coordinate c = new Coordinate();
	StreetMap sm = new StreetMap();
	GridPane gp = new GridPane();
	Label fool = new Label();
	Boolean bullOut = false;
	Fool foo = new Fool();
	VBox vb = new VBox();
	HBox hb = new HBox();
	int turnCount = 0;
	int row, col;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Lab 9");

			vb.getStyleClass().add("vbox");

			Label title = new Label("Escape From The Winston's!");
			title.getStyleClass().add("title");

			mccree.getStyleClass().add("winLoseLabel");
			winston.getStyleClass().add("winLoseLabel");

			Scene sc = new Scene(vb);
			sc.getStylesheets().add("styles/style.css");

			Button butt = new Button("Start");
			butt.getStyleClass().add("button");

			startButton(butt, gp);

			sm.setGrid();
			createGrid();

			hb.getChildren().addAll(butt);
			hb.getStyleClass().add("hbox");

			if (foo.getMcCreeGameOver() == true) {
				hb.getChildren().addAll(mccree);
			} else if (foo.getWinstonGameOver() == true) {
				hb.getChildren().addAll(winston);
			}

			vb.getChildren().addAll(title, gp, hb);

			System.out.println(sm.coords[2][3].getValue());

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

	public void startButton(Button butt, GridPane gp) {
		butt.setOnMouseClicked(e -> {

			menu.selectionMenu();
			
			turnCount = 0;
			if (foo.getMcCreeGameOver() == true || foo.getWinstonGameOver() == true) {
				sm.setGrid();
				createGrid();
				foo.setMcCreeGameOver(false);
				foo.setWinstonGameOver(false);
				bull.clear();
				hb.getChildren().remove(mccree);
				hb.getChildren().remove(winston);
			}

			JOptionPane.showMessageDialog(null, "Game Start!");

			foolController();

			sm.coords[1][1].setValue('P');
			createGrid();
		});
	}

	public void foolController() {

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
					foo.setCol(currentRow + 1);
					foo.setRow(currentCol);
				} else if (sm.coords[currentRow + 1][currentCol].getValue() == 'E') {
					JOptionPane.showMessageDialog(null, "You Win!!!!!");
					foo.setMcCreeGameOver(true);
				}
			} else if (e.getCode() == KeyCode.LEFT) {
				if (sm.coords[currentRow - 1][currentCol].getValue() == ' ') {
					sm.coords[currentRow][currentCol].setValue(' ');
					sm.coords[currentRow - 1][currentCol].setValue('P');
					turnCount++;
					foo.setCol(currentRow - 1);
					foo.setRow(currentCol);

				}
			} else if (e.getCode() == KeyCode.DOWN) {
				if (sm.coords[currentRow][currentCol + 1].getValue() == ' ') {
					sm.coords[currentRow][currentCol].setValue(' ');
					sm.coords[currentRow][currentCol + 1].setValue('P');
					turnCount++;
					foo.setCol(currentRow);
					foo.setRow(currentCol + 1);
				}
			} else if (e.getCode() == KeyCode.UP) {
				if (sm.coords[currentRow][currentCol - 1].getValue() == ' ') {
					sm.coords[currentRow][currentCol].setValue(' ');
					sm.coords[currentRow][currentCol - 1].setValue('P');
					turnCount++;
					foo.setCol(currentRow);
					foo.setRow(currentCol - 1);
				}
			}

			foo.setTurns(turnCount);
			createBull();

			int count = 0;
			if (foo.getTurns() % 1 == 0 && bullOut == true) {
				do {
					for (int i = 0; i < bull.size(); i++) {
						bull.get(i).foolChase(sm, foo, bull.get(i).getRow(), bull.get(i).getCol());
					}
					createGrid();
					count++;
				} while (count < menu.getTurnsToMove());
			}
			checkIfGameOver();
			if (foo.getWinstonGameOver() == true) {
				JOptionPane.showMessageDialog(null, "Game Over! Winston caught McCree!");
			}

			createGrid();

			if (foo.getMcCreeGameOver() == true) {
				hb.getChildren().addAll(mccree);

			} else if (foo.getWinstonGameOver() == true) {
				hb.getChildren().addAll(winston);
			}
		});

	}

	public void createBull() {
		for (int i = menu.getTurnsToComeOut(); i < menu.getHowManyWins(); i++)
			if (foo.getTurns() == i) {
				sm.coords[1][1].setValue('B');
				bull.add(new Bull(1, 1));
				bullOut = true;
			}
	}

	public void checkIfGameOver() {

		if (sm.coords[foo.getCol()][foo.getRow()].getValue() != 'P') {
			foo.setWinstonGameOver(true);
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}