package core;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		
		MineField minefield = new MineField(16, 16);
		
		Text txt = new Text("   Welcome to Minesweeper");
		txt.setFont(new Font(20));
		minefield.getGridPane().add(txt, 17, 2);
		WinText.winTxt.setFont(new Font(20));
		minefield.getGridPane().add(WinText.winTxt, 17, 12);
		
		
		Scene sc = new Scene(minefield.getGridPane());
		
		stage.setScene(sc);
		
		

		//set stage properties
		stage.show();
		stage.setWidth(750);
		stage.setHeight(460);
		stage.setTitle("Minesweeper");
		stage.centerOnScreen();
		stage.setResizable(false);
	}

}
