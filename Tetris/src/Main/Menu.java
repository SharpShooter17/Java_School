package Main;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Menu extends JFrame {
	Menu(){
		super("Tetris game");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(512, 1024);
		setLocation(0, 0);
		
		setLayout(new GridLayout(5, 1));	
		
		JPanel backgroundImage = new Image("./images/background.jpg");
		
		add(backgroundImage);
		add(new JButton("Play"));
		add(new JButton("Settings"));
		add(new JButton("Top 10"));
		add(new JButton("Exit"));
		
		pack();
		
		setVisible(true);
	}
}
