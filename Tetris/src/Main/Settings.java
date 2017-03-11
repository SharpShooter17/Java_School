package Main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Settings extends Container implements ActionListener {
	Menu menu;
	JButton BOpcja1;
	JButton BBack;
	JTextField nickName;
	
	Settings(Menu menu){
		this.menu = menu;
		
		GridLayout layout = new GridLayout(3,1);
		setLayout(layout);
		
		JPanel Name = new JPanel();
		Name.setLayout(new FlowLayout());
		Name.add(new JLabel("Nick name:", JLabel.CENTER));
		Name.add(nickName = new JTextField(31));
		
		add(Name);
		add(BOpcja1 = new JButton("Opcja 1"));
		add(BBack = new JButton("Back to main menu"));
		
		BOpcja1.addActionListener(this);
		BBack.addActionListener(this);		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == BOpcja1);
		else if(source == BBack)
			this.menu.setMainMenu(this);
	}

}
