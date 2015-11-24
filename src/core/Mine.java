package core;

import java.awt.Insets;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Mine extends Button {
	private int rowIndex   = 0;
	private int columIndex = 0;
	
	private static int numBombs = 0;
	private static int numMines = 0;
	
	
	public Mine(int rowIndex, int columIndex){
		setCursor(Cursor.HAND);
		this.rowIndex   = rowIndex;
		this.columIndex = columIndex;
		numBombs++;
		numMines++;
		
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, 
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e){//if pressed do a thing
						setCursor(Cursor.DEFAULT);
						setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					}
		});
	}


	public int getRowIndex() {
		return rowIndex;
	}

	public int getColumIndex() {
		return columIndex;
	}

	public static int getNumBombs() {
		return numBombs;
	}

	public static int getNumMines() {
		return numMines;
	}
	
	//public Image evaluateMine()      //call this if the mine has been clicked or if adjacent mine and this mine are blank. if bomb then out. if num then do nothing. if blank then peekAdjacentMines()
	//public void  peekAdjacentMines() //gets the value of the nearby uncovered mines. if num or bomb do nothing. if blank then evaluateMine()

}
