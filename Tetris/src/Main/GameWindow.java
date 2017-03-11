package Main;

import java.awt.Container;

public class GameWindow extends Container {
	Menu menu;
	
	GameWindow(Menu menu) {
		this.menu = menu;
	}
	
	void startGame(){
		menu.setSize(1024, 1024);
	}
	
}
