package Main;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainMenu extends Container implements ActionListener {
	private JButton BPlay;
	private JButton BSettings;
	private JButton BTop10;
	private JButton BExit;
	
	private Menu menu;
	
	MainMenu(Menu menu){
		setLayout(new GridLayout(4, 1));		
		
		this.menu = menu;
		
		BPlay = new JButton("Play");
		BSettings = new JButton("Settings");
		BTop10 = new JButton("Top 10");
		BExit = new JButton("Exit");
		
		BPlay.addActionListener(this);
		BSettings.addActionListener(this);
		BTop10.addActionListener(this);
		BExit.addActionListener(this);
		
		add(BPlay);
		add(BSettings);
		add(BTop10);
		add(BExit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == BPlay)
			this.menu.runGame();
		else if(source == BSettings)
			this.menu.setSettings(this);
		else if(source == BTop10);
		else if(source == BExit)
			System.exit(0);
	}
}
