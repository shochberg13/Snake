package snakegame.gui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import snakegame.Updatable;
import snakegame.game.SnakeGame;

public class UserInterface implements Runnable{
	private JFrame frame;
	private SnakeGame game;
	private int size;
	private DrawingBoard db;
	
	public UserInterface(SnakeGame game, int size, int pieceSize){
		this.game = game;
		this.size = size;
		this.db = new DrawingBoard(this.game, pieceSize);
	}
	
	@Override
	public void run() {
		frame = new JFrame("Worm Game");
		frame.setPreferredSize(new Dimension(this.size - 30, this.size));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void createComponents(Container container){
		container.add(this.db);
		frame.addKeyListener(new KeyboardListener(this.game.getSnake()));
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public Updatable getUpdatable(){
		return this.db;
	}
}
