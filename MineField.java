package core;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MineField {
	/*
	 * Class designed to: - distribute Mines into a GridPane
	 * 					  - distribute bombs randomly into the mine
	 * 					  - give the Mines information about where they are and how many total mines/bombs exist on the board
	 */
	
	GridPane gp = new GridPane();
	
	private static int numBombs = 0;
	private static int numMines = 0;
	
	public MineField(int rows, int colums){
		Mine[][] field = new Mine[rows][colums];
		numMines = rows * colums;
		numBombs = (int) (numMines * 0.15625);//a number such that 256 mines will have 40 bombs
		
		gp.setVgap(0);
		gp.setHgap(0);
		
		for(int i = 0; i < rows; i++){//create mines and add them to a gridpane at the index that theyre at in the 2d array of mines for simplicity
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
			
			if (!field[r][c].getHasBomb()){//if it doesn't have a bomb give it one
				field[r][c].giveBomb();
				i++;
			}
		}
		
	}
	
	public GridPane getGridPane(){//used to pass the gridpane onto main
		return gp;
	}

	public static int getNumBombs() {
		return numBombs;
	}

	public static int getNumMines() {
		return numMines;
	}

}
