package core;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
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
	private int numAdjBombs = 0;
	
	
	public Mine(int rowIndex, int columIndex, Mine[][] field){
		super("  ");//makes the button more square
		setCursor(Cursor.HAND);
		this.rowIndex   = rowIndex;
		this.columIndex = columIndex;
		this.field = field;
		
		
		this.setWidth(50);
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		System.out.println(getBackground().getFills().get(0).getFill());
		System.out.println("  s");
		System.out.println(Color.GRAY);
		System.out.println(getBackground().getFills().get(0).getFill().equals(Color.GRAY));
		
		
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, 
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e){//if left clicked evaluate
						setCursor(Cursor.DEFAULT);
						
						if(e.getButton() == MouseButton.PRIMARY){
						
							if(hasBomb){
								setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
								gameStatus = false;
							}else{
									showMine(evaluateMine());
							}
						
							if(e.getButton() == MouseButton.SECONDARY){
								toggleFoundBomb();
							}
						}
						if(e.getButton() == MouseButton.SECONDARY){
							toggleFoundBomb();
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

	public void toggleFoundBomb(){
		if(getBackground().getFills().get(0).getFill().equals(Color.GRAY)){
			setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		}else if(getBackground().getFills().get(0).getFill().equals(Color.GREENYELLOW)){
			setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		}
	}
	
	public int evaluateMine(){      //call this if the mine has been clicked or if adjacent mine is blank. if bomb then out. if num then do nothing. if blank then peekAdjacentMines()
		
		setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		numAdjBombs = 0;
		
		//adjacent bomb logic
//top		
		try{
			if(field[rowIndex - 1][columIndex - 1].hasBomb) numAdjBombs++;//top three
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(field[rowIndex - 1][columIndex    ].hasBomb) numAdjBombs++;
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(field[rowIndex - 1][columIndex + 1].hasBomb) numAdjBombs++;
		}catch(ArrayIndexOutOfBoundsException e){}
//middle		
		try{
			if(field[rowIndex    ][columIndex - 1].hasBomb) numAdjBombs++;//middle three
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(field[rowIndex    ][columIndex + 1].hasBomb) numAdjBombs++;
		}catch(ArrayIndexOutOfBoundsException e){}
//bottom		
		try{
			if(field[rowIndex + 1][columIndex - 1].hasBomb) numAdjBombs++;//bottom three
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(field[rowIndex + 1][columIndex    ].hasBomb) numAdjBombs++;
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(field[rowIndex + 1][columIndex + 1].hasBomb) numAdjBombs++;
		}catch(ArrayIndexOutOfBoundsException e){}

		
		return numAdjBombs;
	}
	

	public void  peekAdjacentMines(){ //gets the value of the nearby uncovered mines.
//top
		try{
			if(field[this.rowIndex - 1][this.columIndex - 1].isEvaluated() == false){
				field[this.rowIndex - 1][this.columIndex - 1].showMine(field[this.rowIndex - 1][this.columIndex - 1].evaluateMine());//top three
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(field[this.rowIndex - 1][this.columIndex    ].isEvaluated() == false){
				field[this.rowIndex - 1][this.columIndex    ].showMine(field[this.rowIndex - 1][this.columIndex    ].evaluateMine());
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(field[this.rowIndex - 1][this.columIndex + 1].isEvaluated() == false){
				field[this.rowIndex - 1][this.columIndex + 1].showMine(field[this.rowIndex - 1][this.columIndex + 1].evaluateMine());
			}
		}catch(ArrayIndexOutOfBoundsException e){}
//middle		
		try{
			if(field[this.rowIndex    ][this.columIndex - 1].isEvaluated() == false){
				field[this.rowIndex    ][this.columIndex - 1].showMine(field[this.rowIndex    ][this.columIndex - 1].evaluateMine());
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		//middlebomb would be here
		try{
			if(field[this.rowIndex    ][this.columIndex + 1].isEvaluated() == false){
				field[this.rowIndex    ][this.columIndex + 1].showMine(field[this.rowIndex    ][this.columIndex + 1].evaluateMine());
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		
//bottom		
		try{
			if(field[this.rowIndex + 1][this.columIndex - 1].isEvaluated() == false){
				field[this.rowIndex + 1][this.columIndex - 1].showMine(field[this.rowIndex + 1][this.columIndex - 1].evaluateMine());
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			
			if(field[this.rowIndex + 1][this.columIndex    ].isEvaluated() == false){
				field[this.rowIndex + 1][this.columIndex    ].showMine(field[this.rowIndex + 1][this.columIndex    ].evaluateMine());
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		
		try{
		
			if(field[this.rowIndex + 1][this.columIndex - 1].isEvaluated() == false){
				field[this.rowIndex + 1][this.columIndex - 1].showMine(field[this.rowIndex + 1][this.columIndex - 1].evaluateMine());
			}
		}catch(ArrayIndexOutOfBoundsException e){}
	}

	
	public void showMine(int numAdjBombs){//shows the user the value of the mine
		if(numAdjBombs == 0){
			setText("  ");
			evaluated = true;
			this.peekAdjacentMines();
		}else{
			setText("" + numAdjBombs);
			evaluated = true;
		}	
	}

}
