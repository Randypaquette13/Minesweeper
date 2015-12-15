package core;

import java.text.DateFormat;
import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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
		
		GlobalData.winTxt.setFont(new Font(20));
		minefield.getGridPane().add(GlobalData.winTxt, 17, 12);
		
		Text timeText = new Text(" Time:");
		timeText.setFont(new Font(20));
		minefield.getGridPane().add(timeText, 17, 9);
		 
		GlobalData.clock.setFont(new Font(16));
		GlobalData.clock.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		GlobalData.timeline.setCycleCount(Animation.INDEFINITE);  
		GlobalData.timeline.play(); 
		
		minefield.getGridPane().add(GlobalData.clock, 17, 10);
		
		Scene sc = new Scene(minefield.getGridPane());
		
		stage.setScene(sc);
		
		

		//set stage properties
		stage.show();
		stage.setWidth(700);
		stage.setHeight(460);
		stage.setTitle("Minesweeper");
		stage.centerOnScreen();
		stage.setResizable(false);
	}

}
