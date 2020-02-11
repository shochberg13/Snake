package snakegame;

import javax.swing.SwingUtilities;

import snakegame.game.WormGame;
import snakegame.gui.UserInterface;

public class Main {
	public static void main(String[] args) {

		WormGame game = new WormGame(800, 800);
		UserInterface ui = new UserInterface(game, 800);
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
