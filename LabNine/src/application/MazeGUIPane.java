package application;

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
	int row, col;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Lab 9");

			VBox vb = new VBox();
			vb.getStyleClass().add("vbox");

			Label title = new Label("Map of Pamplona");
			title.getStyleClass().add("title");

			Scene sc = new Scene(vb);
			sc.getStylesheets().add("styles/style.css");
			
			
			Button butt = new Button("Start");
			butt.getStyleClass().add("button");

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

		l.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
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
			}
		});
	}

	public void foolController(Label l) {
		int specRow = GridPane.getRowIndex(l);
		int specCol = GridPane.getColumnIndex(l);
		char specCords = sm.coords[specRow][specCol].getValue();

		l.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {

				} else if (event.getCode() == KeyCode.RIGHT) {

				} else if (event.getCode() == KeyCode.DOWN) {
					
				} else if (event.getCode() == KeyCode.UP){
					
				}

			}

		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
