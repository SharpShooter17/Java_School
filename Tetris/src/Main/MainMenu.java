package Main;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends Container {
	MainMenu(){
		setLayout(new GridLayout(4, 1));		
		
		add(new JButton("Play"));
		add(new JButton("Settings"));
		add(new JButton("Top 10"));
		add(new JButton("Exit"));
	}
}
