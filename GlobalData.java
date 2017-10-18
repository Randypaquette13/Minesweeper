package core;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GlobalData {

	/*
	 * This is just a global variable.
	 * 
	 */
	
	//will either be a :l face or a :) or a :( just like actual minesweeper
	public static Text winTxt = new Text("	:1");
	
	public static long time = System.currentTimeMillis();
	public static Label clock = new Label(); 
	public static long timePast = 0;
	
	
	public static Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
		clock.setText("        " + (((System.currentTimeMillis() - time)/1000) - timePast));
	}));
	
	/*
	clock.setFont(new Font(16));
	clock.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {  
			clock.setText("		" + ((System.currentTimeMillis() - time)/1000));  
	  
	}));  
	
	timeline.setCycleCount(Animation.INDEFINITE);  
	timeline.play(); 
	*/

}
