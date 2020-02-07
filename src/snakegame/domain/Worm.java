package exercise49.wormgame.domain;

import java.util.ArrayList;
import java.util.List;

import exercise49.wormgame.Direction;

public class Worm {
	private Direction direction;
	private List<Piece> pieceList;
	
	public Worm(int originalX, int originalY, Direction originalDirection){
		this.direction = originalDirection;
		this.pieceList = new ArrayList<Piece>();
		pieceList.add(new Piece(originalX, originalY));
	}
	
	public void grow(){
		int leadX = pieceList.get(pieceList.size() - 1).getX();
		int leadY = pieceList.get(pieceList.size() - 1).getY();
		
		if (this.getDirection() == Direction.LEFT){
			this.pieceList.add(new Piece(leadX - 50, leadY));
			return;
		}
		if (this.getDirection() == Direction.UP){
			this.pieceList.add(new Piece(leadX, leadY - 50));
			return;
		}
		if (this.getDirection() == Direction.RIGHT){
			this.pieceList.add(new Piece(leadX + 50, leadY));
			return;
		}
		if (this.getDirection() == Direction.DOWN){
			this.pieceList.add(new Piece(leadX, leadY + 50));
			return;
		}
	}
	
	public void move(){
		this.grow();
		if (this.pieceList.size() > 3){
			this.pieceList.remove(0);
		}
		
	}
	
	public boolean runsInto(Piece piece){
		for (Piece wormPart : this.pieceList){
			if (wormPart.getX() <= piece.getX() + 15 && wormPart.getX() >= piece.getX() - 15){
				if (wormPart.getY() <= piece.getY() + 15 && wormPart.getY() >= piece.getY() - 15){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean runsIntoItself(){
		int leadX = pieceList.get(pieceList.size() - 1).getX();
		int leadY = pieceList.get(pieceList.size() - 1).getY();
		
		for (int i = pieceList.size() - 2; i >= 0; i--){
			if (pieceList.get(i).getX() == leadX && pieceList.get(i).getY() == leadY){
				return true;
			}
		}
		return false;
	}
	
	public Direction getDirection(){
		return this.direction;
	}
	
	public void setDirection(Direction dir){
		this.direction = dir;
	}
	
	public int getLength(){
		return this.getPieces().size();
	}
	
	public List<Piece> getPieces(){
		return this.pieceList;
	}
}
