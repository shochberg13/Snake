package snakegame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import snakegame.Direction;
import snakegame.domain.Snake;


public class KeyboardListener implements KeyListener{
	private Snake snake;
	
	public KeyboardListener(Snake snake){
		this.snake = snake;
	}
	
	// Will change direction according to the key pressed
	
	// If you press a key in the opposite direction of the current direction
	// (eg press UP when going DOWN) then nothing will happen
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if (this.snake.getDirection() == Direction.RIGHT) return;
			this.snake.setDirection(Direction.LEFT);
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if (this.snake.getDirection() == Direction.LEFT) return;
			this.snake.setDirection(Direction.RIGHT);
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			if (this.snake.getDirection() == Direction.DOWN) return;
			this.snake.setDirection(Direction.UP);
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if (this.snake.getDirection() == Direction.UP) return;
			this.snake.setDirection(Direction.DOWN);
			return;
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

}
