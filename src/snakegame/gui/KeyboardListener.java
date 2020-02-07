package exercise49.wormgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import exercise49.wormgame.Direction;
import exercise49.wormgame.domain.Worm;

public class KeyboardListener implements KeyListener{
	private Worm worm;
	
	public KeyboardListener(Worm worm){
		this.worm = worm;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			this.worm.setDirection(Direction.LEFT);
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.worm.setDirection(Direction.RIGHT);
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			this.worm.setDirection(Direction.UP);
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			this.worm.setDirection(Direction.DOWN);
			return;
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
