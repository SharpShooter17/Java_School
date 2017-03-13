package Main;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame {
	JFrame Window;
	MainMenu mainMenu;
	Settings settingsMenu;
	
	private JPanel backgroundImage;
	private BorderLayout layout; 
	
	Menu(){
		new Model();
		new JFrame("Tetris game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(512, 960);
		setLocation(0, 0);
		
		backgroundImage = Model.getImage(IMAGES.BACKGROUND);	
		backgroundImage.setSize(512, 256);
		
		settingsMenu = new Settings(this);
		mainMenu = new MainMenu(this);

		layout = new BorderLayout(3,1);
		setLayout(layout);	
		
		add(backgroundImage);
		add(mainMenu);
		
		layout.addLayoutComponent(backgroundImage, BorderLayout.NORTH);
		layout.addLayoutComponent(mainMenu, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	void setSettings(Container container){
		remove(container);
		layout.removeLayoutComponent(container);
		add(settingsMenu);
		layout.addLayoutComponent(settingsMenu, BorderLayout.CENTER);
		setVisible(true);
		repaint();
	}
	
	void setMainMenu(Container container){
		remove(container);
		layout.removeLayoutComponent(container);
		add(mainMenu);
		layout.addLayoutComponent(mainMenu, BorderLayout.CENTER);
		setVisible(true);
		repaint();
	}
	
	void runGame(){
		remove(mainMenu);
		remove(backgroundImage);
		layout.removeLayoutComponent(mainMenu);
		layout.removeLayoutComponent(backgroundImage);
		//add(gameWindow);
		//layout.addLayoutComponent(gameWindow, BorderLayout.CENTER);
		//gameWindow.startGame();
		setVisible(true);
		repaint();
	}
	
}
