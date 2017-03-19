package Main;

import java.awt.BorderLayout;
import java.awt.Color;
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
		new JFrame("Tetris game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(512, 960);
		setLocation(0, 0);
		
		backgroundImage = Model.getModel().getImage(IMAGES.BACKGROUND);	
		backgroundImage.setSize(512, 256);
		
		settingsMenu = new Settings(this);
		mainMenu = new MainMenu(this);

		layout = new BorderLayout(3,1);
		setLayout(layout);	
		
		add(backgroundImage);
		add(mainMenu);
		
		layout.addLayoutComponent(backgroundImage, BorderLayout.NORTH);
		layout.addLayoutComponent(mainMenu, BorderLayout.CENTER);
		
		setBackground(Color.BLACK);
		
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
						
		Game game = new Game();
		addKeyListener( game );

		add(game.getBoard());
		layout.addLayoutComponent(game.getBoard(), BorderLayout.CENTER);
		setSize(1024, 960);
		
		setVisible(true);
		repaint();
	}
}
