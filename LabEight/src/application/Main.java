package application;

import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	public int row;
	public int col;
	public Label lbl = new Label();

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Lab 8");

			BorderPane bp = new BorderPane();
			bp.getStyleClass().add("grid");

			Scene sc = new Scene(bp, 835, 905);
			sc.getStylesheets().add("styles/style.css");
			
			GridPane gp = new GridPane();

			Label title = new Label("Reverse Multiplication Table");
			title.getStyleClass().add("mainTitle");

			Label askAnswerLabel = new Label("Enter Answer: ");
			askAnswerLabel.getStyleClass().add("answerLabel");

			Button butt = new Button("Find Problems");

			final TextField userInput = new TextField();
			//userInput.getStyleClass().add("inputBar");
			//userInput.setMaxWidth(100);

			VBox vb = new VBox();

			HBox hb = new HBox();
			hb.getStyleClass().add("horizontal");


			for (row = 0; row < 11; row++)
				for (col = 0; col < 11; col++) {

					Rectangle rect = new Rectangle();
					// Label lbl = new Label();

					
					//Creating the labels and adding the styles for boxes and text
					if (row == 0 || col == 0) {
						if (row == 0 && col != 0)
							lbl = new Label("    " + String.valueOf(col));
						else if (col == 0 && row != 0)
							lbl = new Label("    " + String.valueOf(row));
						else
							lbl = new Label("    0");

						rect.getStyleClass().add("borders");
						lbl.getStyleClass().add("textStyleBorder");
					} else {
						lbl = new Label("   " + row + " * " + col);

						rect.getStyleClass().add("otherBoxes");
						lbl.getStyleClass().add("textStyleOther");
						
						// Start of Event Handler
						butt.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {
								List<Integer> numbs = new ArrayList<Integer>();
								List<Integer> listOfCol = new ArrayList<Integer>();
								List<Integer> listOfRow = new ArrayList<Integer>();

								rect.getStyleClass().add("otherBoxes");
								lbl.getStyleClass().add("textStyleOther");

								int userNum = Integer.parseInt(userInput.getText());

								for (int i = 1; i < 11; i++) {
									if (userNum % i == 0) {
										numbs.add(i);
									}
								}
								for (int i = 0; i < numbs.size(); i++)
									for (int j = 0; j < numbs.size(); j++) {
										if (numbs.get(i) * numbs.get(j) == userNum) {
											// col = numbs.get(i);
											// row = numbs.get(j);
											// rect.getStyleClass().add("answerLightUp");
											// gp.add(rect, col, row);
											// lbl.getStyleClass().add("answerText");
											// gp.add(lbl, col, row);
											listOfCol.add(numbs.get(i));
											listOfRow.add(numbs.get(j));
										}
									}
								int count = 0;
								do {
									for (int i = 0; i < listOfCol.size(); i++)
										for (int j = 0; j < listOfRow.size(); j++) {

										}

									count++;
								} while (count < listOfCol.size());
							}

						});
						// End of Event Handler
					}

					// rect.getStyleClass().add("rectDimensions");
					// Style class does not let me make the dimensions for some
					// reason
					rect.setWidth(75);
					rect.setHeight(75);
					gp.add(rect, col, row);
					gp.add(lbl, col, row);

				}
			//adding elements the the horizontal box
			hb.getChildren().addAll(askAnswerLabel, userInput, butt);
			//combining the horizontal box & the grid pane into a vertical box
			vb.getChildren().addAll(hb, gp);
			
			bp.setTop(title);
			bp.setBottom(vb);

			primaryStage.setScene(sc);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
