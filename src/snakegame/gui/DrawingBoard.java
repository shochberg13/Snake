package exercise49.wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import exercise49.wormgame.domain.Piece;
import exercise49.wormgame.Updatable;
import exercise49.wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable{
	private WormGame wg;
	private int pieceLength;
	
	public DrawingBoard(WormGame wg, int pieceLength){
		super.setBackground(Color.WHITE);
		this.wg = wg;
		this.pieceLength = pieceLength;
	}

	@Override
	protected void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		// Draw worm
		graphics.setColor(Color.BLACK);
		for (Piece piece : this.wg.getWorm().getPieces()){
			graphics.fill3DRect(piece.getX(), piece.getY(), this.pieceLength, this.pieceLength, true);
		}
		
		// Draw apple
		graphics.setColor(Color.RED);
		graphics.fillOval(this.wg.getApple().getX(), this.wg.getApple().getY(), this.pieceLength, this.pieceLength);
		
	}

	public void update() {
		super.repaint();
	}
}
