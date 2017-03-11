package Main;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Settings extends Container {
	Settings(){
		setLayout(new GridLayout(1, 1));		
		add(new JButton("Opcja 1"));
	}

}
