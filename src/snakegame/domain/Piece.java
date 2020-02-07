package exercise49.wormgame.domain;

public class Piece {
	protected int x;
	protected int y;
	
	public Piece(int x, int y){
		this.x  = x;
		this.y = y;
	}
	
	public boolean runsInto(Piece piece){
		return piece.getX() == this.x && piece.getY() == this.y;
	}
	
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public String toString(){
		return "(" + this.x + "," + this.y + ")";
	}
}
