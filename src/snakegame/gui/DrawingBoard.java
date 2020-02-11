package snakegame.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import snakegame.Updatable;
import snakegame.domain.SnakePart;
import snakegame.game.SnakeGame;

public class DrawingBoard extends JPanel implements Updatable{
	private SnakeGame game;
	private int pieceLength;
	
	public DrawingBoard(SnakeGame game, int pieceLength){
		super.setBackground(Color.GRAY);
		this.game = game;
		this.pieceLength = pieceLength;
	}

	@Override
	protected void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		// Draw worm
		graphics.setColor(Color.BLACK);
		for (SnakePart snakePart : this.game.getSnake().getPieces()){
			graphics.fill3DRect(snakePart.getX(), snakePart.getY(), this.pieceLength, this.pieceLength, true);
		}
		
		// Draw apple
		graphics.setColor(Color.RED);
		graphics.fillOval(this.game.getApple().getX(), this.game.getApple().getY(), this.pieceLength, this.pieceLength);
		
	}

	public void update() {
		super.repaint();
	}
}
