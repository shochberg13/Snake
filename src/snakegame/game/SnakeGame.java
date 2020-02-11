package snakegame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import snakegame.Direction;
import snakegame.Updatable;
import snakegame.domain.Apple;
import snakegame.domain.Snake;
import snakegame.domain.SnakePart;


public class SnakeGame extends Timer implements ActionListener{
	private Snake snake;
	private Apple apple;
	private int boardWidth;
	private int boardHeight;
	private boolean gameContinues;
	private Updatable updatable;
	
	
	public SnakeGame(int boardWidth, int boardHeight){
		super(1000, null);
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.gameContinues = true;
		this.snake = new Snake(boardWidth / 2, boardHeight / 2, Direction.DOWN);
		generateNewApple();
		
		addActionListener(this);
		setInitialDelay(2000);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(!gameContinues){
			return;
		}
		
		this.snake.move();
		
		if(this.snake.runsInto(this.apple)){
			this.snake.grow();
			generateNewApple();
		}
		
		if (this.snake.runsIntoItself() || snakeHitsBorder()){
			gameContinues = false;
		}
		
		// Repaints + updates the drawing board
		updatable.update();
		
		// Speeds up every time the snake eats an apple (and gets longer)
		setDelay(1000 / snake.getLength());
	}

	public void generateNewApple(){
		// Apple location is in increments of 50 (the snake width)
		// Need to repeat this process if new apple is generated on top of the snake
		do {
			this.apple = new Apple(new Random().nextInt(14) * 50, new Random().nextInt(14) * 50);
		} while (this.snake.runsInto(apple));
	}
	
	public boolean snakeHitsBorder(){
		SnakePart snakeHead = this.snake.getPieces().get(this.snake.getLength() - 1);
		if (snakeHead.getY() > this.boardHeight || snakeHead.getX() > this.boardWidth ||
			snakeHead.getY() < 0 || snakeHead.getX() < 0){
			return true;
		}
		return false;
	}
	
	public Snake getSnake(){
		return this.snake;
	}
	
	public void setSnake(Snake snake){
		this.snake = snake;
	}
	
	public Apple getApple(){
		return this.apple;
	}

	public void setApple(Apple apple){
		this.apple = apple;
	}
	
	public void setUpdatable(Updatable updatable){
		this.updatable = updatable;
	}
}
