package core;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		
		MineField minefield = new MineField(7, 2);
		
		/*
		//booton tyme
		Mine b1 = new Mine(0, 0);
		//b1.setCursor(Cursor.HAND);
		Mine b2 = new Mine(0, 0);
		Mine b3 = new Mine(0, 0);
		Mine b4 = new Mine(0, 0);
		Mine b5 = new Mine(0, 0);
		Mine b6 = new Mine(0, 0);
		

		GridPane gp = new GridPane();
		gp.setVgap(0);
		gp.setHgap(0);
		
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 0, 1);
		gp.add(b4, 1, 1);
		gp.add(b5, 0, 2);
		gp.add(b6, 1, 2);
		*/
		
		
		Scene sc = new Scene(minefield.getGridPane());
		
		stage.setScene(sc);
		
		

		//set stage properties
		stage.show();
		stage.setWidth(450);
		stage.setHeight(350);
		stage.setTitle("mer stagemenstien");
		stage.centerOnScreen();
		stage.setResizable(false);
	}

}
