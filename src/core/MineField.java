package core;

import javafx.scene.layout.GridPane;

public class MineField {
	
	GridPane gp = new GridPane();
	
	private static int numBombs = 0;
	private static int numMines = 0;
	
	public MineField(int rows, int colums){
		Mine[][] field = new Mine[rows][colums];
		numMines = rows * colums;
		numBombs = (int) (numMines * 0.15625);//a number such that 256 mines will have 40 bombs and 64 mines will have 10 bombs
		
		gp.setVgap(0);
		gp.setHgap(0);
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < colums; j++){
				field[i][j] = new Mine(i, j, field);
				gp.add(field[i][j], j, i);
			}
				
		}
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

}
