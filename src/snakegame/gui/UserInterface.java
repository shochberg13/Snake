package snakegame.gui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import snakegame.Updatable;
import snakegame.game.WormGame;


public class UserInterface implements Runnable{
	private JFrame frame;
	private WormGame wg;
	private int size;
	private DrawingBoard db;
	
	public UserInterface(WormGame wg, int size){
		this.wg = wg;
		this.size = size;
		this.db = new DrawingBoard(this.wg, 50);
	}
	
	@Override
	public void run() {
		frame = new JFrame("Worm Game");
		frame.setPreferredSize(new Dimension(this.size, this.size));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void createComponents(Container container){
		container.add(this.db);
		frame.addKeyListener(new KeyboardListener(this.wg.getWorm()));
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public Updatable getUpdatable(){
		return this.db;
	}
}
