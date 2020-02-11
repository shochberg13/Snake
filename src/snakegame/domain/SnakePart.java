package snakegame.domain;

public class SnakePart{
	protected int x;
	protected int y;
	protected int size;
	
	public SnakePart(int x, int y){
		this.x  = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getSize(){
		return this.size;
	}
}
