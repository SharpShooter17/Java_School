package Main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame {
	JFrame Window;
	MainMenu mainMenu;
	Settings settingsMenu;
	private JPanel backgroundImage;
	
	Menu(){
		new JFrame("Tetris game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(512, 1024);
		setLocation(0, 0);
		
		backgroundImage = Model.getImage(IMAGES.BACKGROUND);		
		backgroundImage.setSize(512, 256);
		
		settingsMenu = new Settings();
		mainMenu = new MainMenu();

		BorderLayout layout = new BorderLayout(3,1);
		setLayout(layout);	
		
		add(backgroundImage);
		add(mainMenu);
		
		layout.addLayoutComponent(backgroundImage, BorderLayout.NORTH);
		layout.addLayoutComponent(mainMenu, BorderLayout.CENTER);
		
		
		
		setVisible(true);
	}
}
