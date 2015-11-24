package core;

import javafx.scene.layout.GridPane;

public class MineField {
	
	GridPane gp = new GridPane();
	
	
	
	public MineField(int rows, int colums){
		Mine[][] field = new Mine[rows][colums];
		
		gp.setVgap(0);
		gp.setHgap(0);
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < colums; j++){
				field[i][j] = new Mine(i, j);
				gp.add(field[i][j], j, i);
			}
				
		}
	}
	
	public GridPane getGridPane(){
		return gp;
	}

}
