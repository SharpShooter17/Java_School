package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Game implements ActionListener {
	
	enum STATE {IN_GAME, PAUSE, GAME_OVER };
	STATE state;
	
	private boolean isBlock;
	private Timer timer;
	private Board board;
	
	
	Game(){
		state = STATE.IN_GAME;
		timer = new Timer(400, this);
		board = new Board(16, 30);
		isBlock = false;
		timer.start();
	}
	
	private void loop(){
		if (state == STATE.GAME_OVER){
			return;
		}
		
		if (state == STATE.PAUSE){
			timer.stop();
		}
		
		if (isBlock == false){
			board.setCurentShape(Shape.getShape(Shape.randomShape()));
			isBlock = true;
			return;
		} else {
			//przesun w dó³
		}
		
		board.repaint();		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		loop();
	}
	
	Board getBoard(){
		return board;
	}
}
