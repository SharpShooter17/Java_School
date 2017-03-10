package Main;

import javax.swing.JFrame;

public class Tetris extends JFrame {
	private Menu menu;
	private static Model model = new Model();
	
	public Tetris(){
		menu = new Menu();
	}
}
