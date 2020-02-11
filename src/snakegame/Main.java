package snakegame;

import javax.swing.SwingUtilities;

import snakegame.game.SnakeGame;
import snakegame.gui.UserInterface;

public class Main {
	public static void main(String[] args) {

		SnakeGame game = new SnakeGame(700, 700);
		UserInterface ui = new UserInterface(game, 800, 50);
		SwingUtilities.invokeLater(ui);
		
		while(ui.getUpdatable() == null){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("The drawing board hasn't been created yet.");
			}
		}
		
		game.setUpdatable(ui.getUpdatable());
		game.start();

	}
}
