package exercise49.wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import exercise49.wormgame.Direction;
import exercise49.wormgame.domain.Apple;
import exercise49.wormgame.domain.Piece;
import exercise49.wormgame.domain.Worm;
import exercise49.wormgame.Updatable;

public class WormGame extends Timer implements ActionListener{
	private Worm worm;
	private Apple apple;
	private int width;
	private int height;
	private boolean continues;
	private Updatable updatable;
	
	
	public WormGame(int width, int height){
		super(1000, null);
		this.width = width;
		this.height = height;
		this.continues = true;
		this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
		generateNewApple();
		
		while(worm.runsInto(apple)){
			generateNewApple();
		}
		
		addActionListener(this);
		setInitialDelay(2000);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(!continues){
			return;
		}
		
		this.worm.move();
		
		if(this.worm.runsInto(this.apple)){
			this.worm.grow();
			generateNewApple();
		}
		
		if (this.worm.runsIntoItself() || wormHitsBorder()){
			continues = false;
		}
		
		updatable.update();
		
		setDelay(1000 / worm.getLength());
	}

	public boolean wormHitsBorder(){
		for (Piece p : this.worm.getPieces()){
			if (p.getY() == this.height || p.getX() == this.width ||
				p.getY() == -1 || p.getY() == - 1){
				return true;
			}
		}
		return false;
	}
	
	public void setUpdatable(Updatable updatable){
		this.updatable = updatable;
	}
	
	public void generateNewApple(){
		this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
	}
	
	public Worm getWorm(){
		return this.worm;
	}
	
	public void setWorm(Worm worm){
		this.worm = worm;
	}
	
	public Apple getApple(){
		return this.apple;
	}

	public void setApple(Apple apple){
		this.apple = apple;
	}
}
