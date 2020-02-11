package snakegame.domain;

public class Apple{

	private int x;
	private int y;
	private int size;
	
	public Apple(int x, int y){
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
