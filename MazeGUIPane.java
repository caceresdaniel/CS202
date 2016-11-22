package application;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MazeGUIPane extends Application {
	Boolean clicked = false;
	GridPane gp = new GridPane();
	StreetMap sm = new StreetMap();
	Coordinate c = new Coordinate();

	VBox vb = new VBox();
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
				}

				boxChanger(l);

				gp.add(l, row, col);
			}
	}

	public void boxChanger(Label l) {
		// method that changes the boxes from either path or to wall
		l.setOnMouseClicked(e -> {
			int specRow = GridPane.getRowIndex(l);
			int specCol = GridPane.getColumnIndex(l);
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
			JOptionPane.showMessageDialog(null, "Game Start!");
			Label fool = new Label();
			fool.getStyleClass().add("player");

			sm.setGrid();
			createGrid();

			// added the fool to the coordinate class
			sm.coords[foolRow][foolCol].setValue('P');

			foolController(fool, foolRow, foolCol);

			gp.add(fool, foolCol, foolRow);

		});
	}

	public void foolController(Label fool, int foolRow, int foolCol) {
		// this method moves the fool according to where the user designates
		vb.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.RIGHT) {
				// JOptionPane.showMessageDialog(null, "Moving Right");
				if (sm.coords[foolRow][foolCol + 1].getValue() == ' ') {
					sm.coords[foolRow][foolCol].setValue(' ');
					sm.coords[foolRow][foolCol + 1].setValue('P');
					fool.getStyleClass().add("player");
				} else if (sm.coords[foolRow][foolCol + 1].getValue() == 'W') {
					JOptionPane.showMessageDialog(null, "Can't Move this way!");
				}

			} else if (e.getCode() == KeyCode.LEFT) {
				// JOptionPane.showMessageDialog(null, "Moving Left");
				if (sm.coords[foolRow][foolCol - 1].getValue() == ' ') {
				}
			} else if (e.getCode() == KeyCode.DOWN) {
				// JOptionPane.showMessageDialog(null, "Moving Down");
				if (sm.coords[foolRow + 1][foolCol].getValue() == ' ') {
				}
			} else if (e.getCode() == KeyCode.UP) {
			}

		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}