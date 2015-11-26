package core;

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
	private boolean hasBomb = false;
	private boolean gameStatus = true;
	private Mine[][] field;
	private boolean evaluated = false;
	
	
	public Mine(int rowIndex, int columIndex, Mine[][] field){
		super("  ");//makes the button more square
		setCursor(Cursor.HAND);
		this.rowIndex   = rowIndex;
		this.columIndex = columIndex;
		this.field = field;
		
		this.setWidth(50);
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, 
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e){//if pressed do a thing
						setCursor(Cursor.DEFAULT);
						if(hasBomb){
							setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
							gameStatus = false;
						}else{
							showMine(evaluateMine());
						
						}
					}
		});
	}


	public int getRowIndex() {
		return rowIndex;
	}

	public int getColumIndex() {
		return columIndex;
	}
	
	public void giveBomb() {
		hasBomb = true;
	}

	public boolean getHasBomb() {
		return hasBomb;
	}
	
	public boolean getGameStatus(){
		return gameStatus;
	}
	
	public boolean isEvaluated(){
		return evaluated;
	}
	
	public int evaluateMine(){      //call this if the mine has been clicked or if adjacent mine and this mine are blank. if bomb then out. if num then do nothing. if blank then peekAdjacentMines()
		evaluated = true;
		setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		
		int numAdjBombs = 0;
		//adjacent bomb logic. should be 8
		try{
			if(field[rowIndex - 1][columIndex - 1].hasBomb) numAdjBombs++;//top three
			if(field[rowIndex - 1][columIndex    ].hasBomb) numAdjBombs++;
			if(field[rowIndex - 1][columIndex + 1].hasBomb) numAdjBombs++;
		
			if(field[rowIndex    ][columIndex - 1].hasBomb) numAdjBombs++;//middle three
			//middlebomb would be here
			if(field[rowIndex    ][columIndex + 1].hasBomb) numAdjBombs++;
		
			if(field[rowIndex + 1][columIndex - 1].hasBomb) numAdjBombs++;//bottom three
			if(field[rowIndex + 1][columIndex    ].hasBomb) numAdjBombs++;
			if(field[rowIndex + 1][columIndex + 1].hasBomb) numAdjBombs++;
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		
		return numAdjBombs;
	}
	
	public void  peekAdjacentMines(){ //gets the value of the nearby uncovered mines. shows them if they are equal to 0
		try{
			if(field[this.rowIndex - 1][this.columIndex - 1].evaluateMine() == 0 && field[this.rowIndex - 1][this.columIndex - 1].isEvaluated() == false) field[this.rowIndex - 1][this.columIndex - 1].showMine(field[this.rowIndex - 1][this.columIndex - 1].evaluateMine());//top three
			if(field[this.rowIndex - 1][this.columIndex    ].evaluateMine() == 0 && field[this.rowIndex - 1][this.columIndex    ].isEvaluated() == false) field[this.rowIndex - 1][this.columIndex    ].showMine(field[this.rowIndex - 1][this.columIndex    ].evaluateMine());
			if(field[this.rowIndex - 1][this.columIndex + 1].evaluateMine() == 0 && field[this.rowIndex - 1][this.columIndex + 1].isEvaluated() == false) field[this.rowIndex - 1][this.columIndex + 1].showMine(field[this.rowIndex - 1][this.columIndex + 1].evaluateMine());
		
			if(field[this.rowIndex    ][this.columIndex - 1].evaluateMine() == 0 && field[this.rowIndex    ][this.columIndex - 1].isEvaluated() == false) field[this.rowIndex    ][this.columIndex - 1].showMine(field[this.rowIndex    ][this.columIndex - 1].evaluateMine());//middle three
			//middlebomb would be here
			if(field[this.rowIndex    ][this.columIndex + 1].evaluateMine() == 0 && field[this.rowIndex    ][this.columIndex + 1].isEvaluated() == false) field[this.rowIndex    ][this.columIndex + 1].showMine(field[this.rowIndex    ][this.columIndex + 1].evaluateMine());
		
			if(field[this.rowIndex + 1][this.columIndex - 1].evaluateMine() == 0 && field[this.rowIndex + 1][this.columIndex - 1].isEvaluated() == false) field[this.rowIndex + 1][this.columIndex - 1].showMine(field[this.rowIndex + 1][this.columIndex - 1].evaluateMine());//bottom three
			if(field[this.rowIndex + 1][this.columIndex    ].evaluateMine() == 0 && field[this.rowIndex + 1][this.columIndex    ].isEvaluated() == false) field[this.rowIndex + 1][this.columIndex    ].showMine(field[this.rowIndex + 1][this.columIndex    ].evaluateMine());
			if(field[this.rowIndex + 1][this.columIndex + 1].evaluateMine() == 0 && field[this.rowIndex + 1][this.columIndex + 1].isEvaluated() == false) field[this.rowIndex + 1][this.columIndex + 1].showMine(field[this.rowIndex + 1][this.columIndex + 1].evaluateMine());
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
	}
	
	public void showMine(int numAdjBombs){
		if(numAdjBombs == 0){
			setText("  ");
			this.peekAdjacentMines();
		}else{
			setText("" + numAdjBombs);
		}	
	}

}
