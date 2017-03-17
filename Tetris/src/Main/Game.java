package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Game implements ActionListener, KeyListener {
	
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
		} else if (state == STATE.PAUSE){
			timer.stop();
			
		}else if (isBlock == false){
			board.setCurentShape(Shape.getShape(Shape.randomShape()));
			isBlock = true;
		} else if (state == STATE.IN_GAME) {
			board.downCurrentBlock();
			isBlock = !board.isColision();
			if (!isBlock){
				board.writeCurrentShapeToBoard();
			}
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

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 'A':
		case 'a': board.leftCurrentBlock();	
			break;
		case 'D':
		case 'd': board.rightCurrentBlock();
			break;
		case 'S':
		case 's': board.downCurrentBlock();
			break;
		default:
			break;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
