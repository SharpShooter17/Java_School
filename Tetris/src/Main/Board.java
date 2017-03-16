package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Board extends JPanel {

	final int Width;
	final int Height;
	final int tileSize;
	
	private TILE [][] board;
	private TILE [][] curentShape;
	
	Board(int w, int h){
		
		//Model.getModel().getImage(IMAGES.TLO_INKSCAPE).paintComponent(getGraphics());
		this.Width = w;
		this.Height = h;
		this.tileSize = 512/w;
		board = new TILE[h][w];
		
		
		for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[j].length; ++j)
            		board[i][j] = TILE.EMPTY;
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d=(Graphics2D)g; 
		for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[j].length; ++j) {
            	if (board[i][j] == TILE.EMPTY){
            		continue;
            	}
            	
            	Image img = Model.getModel().getImage(board[i][j].toImage());
            	g2d.drawImage(	img.getImage().getScaledInstance(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB), 
            					j*tileSize, i*tileSize, this); 
            }
        }	
		
		for (int i = 0; i < curentShape.length; ++i) {
            for (int j = 0; j < curentShape[j].length; ++j) {
            	if (curentShape[i][j] == TILE.EMPTY){
            		continue;
            	}
            	
            	Image img = Model.getModel().getImage(curentShape[i][j].toImage());
            	g2d.drawImage(	img.getImage().getScaledInstance(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB), 
            					j*tileSize, i*tileSize, this); 
            }
        }	
		
	}

	public TILE [][] getCurentShape() {
		return curentShape;
	}

	public void setCurentShape(TILE [][] curentShape) {
		this.curentShape = curentShape;
	}

}
