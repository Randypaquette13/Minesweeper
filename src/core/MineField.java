package core;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MineField {
	
	GridPane gp = new GridPane();
	static Text winText = new Text();//will either be a :l face or a :) or a :( just like actual minesweeper
	
	private static int numBombs = 0;
	private static int numMines = 0;
	
	public MineField(int rows, int colums){
		Mine[][] field = new Mine[rows][colums];
		numMines = rows * colums;
		numBombs = 1;//(int) (numMines * 0.15625);//a number such that 256 mines will have 40 bombs
		
		gp.setVgap(0);
		gp.setHgap(0);
		
		for(int i = 0; i < rows; i++){//create mines and add them to a minefield
			for(int j = 0; j < colums; j++){
				field[i][j] = new Mine(i, j, field);
				gp.add(field[i][j], j, i);
			}	
		}
		//randomly distribute bombs
		int i = 0;
		while (i < numBombs){
			int index = (int) (numMines * Math.random());
			int r = index / rows;
			int c = index % colums;
			
			if (!field[r][c].getHasBomb()){//if it doesnt have a bomb give it one
				field[r][c].giveBomb();
				i++;
			}
		}
		
	}
	
	public GridPane getGridPane(){
		return gp;
	}

	public static int getNumBombs() {
		return numBombs;
	}

	public static int getNumMines() {
		return numMines;
	}

}
