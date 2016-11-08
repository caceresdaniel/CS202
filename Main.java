package application;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	Label[][] lbl;
	GridPane gp = new GridPane();
	Button butt = new Button("Find Problems");
	TextField userInput = new TextField();

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Lab 8");

			BorderPane bp = new BorderPane();
			bp.getStyleClass().add("grid");

			Scene sc = new Scene(bp);
			sc.getStylesheets().add("styles/style.css");

			Label title = new Label("Reverse Multiplication Table");
			title.getStyleClass().add("mainTitle");

			Label askAnswerLabel = new Label("Enter Answer: ");
			askAnswerLabel.getStyleClass().add("askAnswerLabel");

			VBox vb = new VBox();

			HBox hb = new HBox();
			hb.getStyleClass().add("horizontal");

			// call the grid making method here
			setLabels();

			// adding elements the the horizontal box
			hb.getChildren().addAll(askAnswerLabel, userInput, butt);
			// combining the horizontal box & the grid pane into a vertical box
			vb.getChildren().addAll(hb, gp);

			bp.setTop(title);
			bp.setBottom(vb);

			primaryStage.setScene(sc);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLabels() {
		lbl = new Label[11][11];
		//creating labels and setting the rows and col to the label
		for (int row = 0; row < 11; row++) {
			for (int col = 0; col < 11; col++) {
				Label l = new Label();
				setGrid(l, row, col);
				lbl[row][col] = l;
				gp.add(l, col, row);
			}
		}
	}

	public void setGrid(final Label l, final int row, final int col) {
		l.setPrefHeight(75);
		l.setPrefWidth(75);
		// populating the grid and creating the labels and setting the specific
		// style class to where i want them
		if (row == 0 || col == 0) {
			l.getStyleClass().add("labelBorder");
			if (col == 0) l.setText(String.valueOf(row));
			else if (row == 0) l.setText(String.valueOf(col));
			else l.setText("0");
		} else {
			l.setText(String.valueOf(row) + " * " + String.valueOf(col));
			l.getStyleClass().add("labelOther");
		}
		try{
		// Start of Event Handler
		butt.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				int userNum = Integer.parseInt(userInput.getText());
				
				
				setLabels();

				for (int i = 0; i < 11; i++) {
					for (int j = 0; j < 11; j++) {
						if (i * j == userNum) {
							gp.getChildren().remove(lbl[i][j]);
							gp.getChildren().add(lbl[i][j]);
							lbl[i][j].getStyleClass().add("labelAnswer");
						}
					}
				}
			}

		});
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No Input Detected!");
		}
		// End of event handler
	}

	public static void main(String[] args) {
		launch(args);
	}
}
