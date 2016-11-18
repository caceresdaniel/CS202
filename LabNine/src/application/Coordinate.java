package application;

public class Coordinate {
	private int col;
	private int row;
	private char valOfCord;
	
	public Coordinate(){}
	public Coordinate(int rowIn, int colIn, char valIn){
			row = rowIn;
			col = colIn;
			valOfCord = valIn;
	}
	
	public int getRow(){
		return row;
	}
	
	public void setRow(int row){
		this.row = row;
	}
	
	public int getCol(){
		return col;
	}
	
	public void setCol(int col){
		this.col = col;
	}
	
	public char getValue(){
		return valOfCord;
	}
	
	public void setValue(char valOfCord){
		this.valOfCord = valOfCord;
	}
}
