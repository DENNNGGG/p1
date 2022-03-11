package P1;

import java.util.ArrayList;

public class Coordinate {
	String type;
	int row;
	int col;
	boolean visited;
	
	public Coordinate() {
		type = "";
		row = 0;
		col = 0;
		visited = false; 
	}
	
	public Coordinate(ArrayList<String> entry, int i) {
		type = entry.get(i).substring(0, 1);
		row = Integer.parseInt(entry.get(i).substring(2,3));
		col = Integer.parseInt(entry.get(i).substring(4,5));
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public void setVisited(boolean setter) {
		visited = setter;
	}
	
	public void setType(String typer) {
		type = typer;
	}
}
