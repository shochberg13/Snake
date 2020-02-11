package snakegame.domain;

import java.util.ArrayList;
import java.util.List;

import snakegame.Direction;

public class Snake {
	private Direction direction;
	private List<SnakePart> pieceList;
	
	public Snake(int originalX, int originalY, Direction originalDirection){
		this.direction = originalDirection;
		this.pieceList = new ArrayList<SnakePart>();
		pieceList.add(new SnakePart(originalX, originalY));
	}
	
	// Adds a piece to the front of the snake, but the end of pieceList
	public void grow(){
		int leadX = pieceList.get(pieceList.size() - 1).getX();
		int leadY = pieceList.get(pieceList.size() - 1).getY();
		
		if (this.getDirection() == Direction.LEFT){
			this.pieceList.add(new SnakePart(leadX - 50, leadY));
			return;
		}
		if (this.getDirection() == Direction.UP){
			this.pieceList.add(new SnakePart(leadX, leadY - 50));
			return;
		}
		if (this.getDirection() == Direction.RIGHT){
			this.pieceList.add(new SnakePart(leadX + 50, leadY));
			return;
		}
		if (this.getDirection() == Direction.DOWN){
			this.pieceList.add(new SnakePart(leadX, leadY + 50));
			return;
		}
	}
	
	// When the snake moves, it simultaneously grows 1 part in front and looses 1 part in back 
	public void move(){
		this.grow();
		if (this.pieceList.size() > 3){
			this.pieceList.remove(0);
		}
		
	}
	
	// Return true if the snake head runs into the apple
	public boolean runsInto(Apple apple){
		
		// Need to check every piece because we don't want the apple to randomly land
		// on any part of the snake when a new one is generated
		for (SnakePart part : this.getPieces()){
			if (part.getX() <= apple.getX() + apple.getSize() && part.getX() + part.getSize() >= apple.getX()){
				if (part.getY() <= apple.getY() + apple.getSize() && part.getY() + part.getSize() >= apple.getY()){
					return true;
				}
			}
		}
		return false;
	}
	
	// Return true if the snake head runs into any other part of the snake
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
	
	public int getPieceSize(){
		return this.getPieces().get(0).getSize();
	}
	
	public List<SnakePart> getPieces(){
		return this.pieceList;
	}
}
