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
	
	private int xCur, yCur;
	
	Board(int w, int h){
		
//		Model.getModel().getImage(IMAGES.TLO_INKSCAPE).paintComponent(getGraphics());
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
            for (int j = 0; j < board[i].length; ++j) {
            	if (board[i][j] == TILE.EMPTY){
            		g2d.clearRect(j*tileSize, i*tileSize, tileSize, tileSize);
            		continue;
            	}
            	
            	Image img = Model.getModel().getImage(board[i][j].toImage());
            	g2d.drawImage(	img.getImage().getScaledInstance(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB), 
            					j*tileSize, i*tileSize, this); 
            }
        }	
		
		if (!(curentShape instanceof TILE [][])){
			System.out.println("NULL");
			return;
		}
		
		for (int i = 0; i < curentShape.length; i++) {
            for (int j = 0; j < curentShape[i].length; j++) {
            	if (curentShape[i][j] == TILE.EMPTY){
            		continue;
            	}
            	
            	Image img = Model.getModel().getImage(curentShape[i][j].toImage());
            	g2d.drawImage(	img.getImage().getScaledInstance(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB), 
            					(j + xCur)*tileSize, (i + yCur)*tileSize, this); 
            }
        }
	}
	
	public void downCurrentBlock(){
		if ( ((yCur + 1 + Shape.getHeightCurBlock(curentShape)) >= Height) || isColision() ){
			return;
		}
		this.yCur++;
	}
	
	public void leftCurrentBlock(){
		if (this.xCur == 0){
			return;
		}
		this.xCur--;
		if (isColisionAfterTranslation()){
			this.xCur++;
		}
	}
	
	public void rightCurrentBlock(){
		if ((this.xCur + Shape.getWidthCurBlock(curentShape)) == Width){
			return;
		}
		this.xCur++;
		
		if (isColisionAfterTranslation()){
			this.xCur--;
		}
	}	

	public void rotateCurrentShape(){
		curentShape = Shape.rotate(curentShape);
	}
	
	public TILE [][] getCurentShape() {
		return curentShape;
	}

	public void setCurentShape(final TILE [][] curentShape) {
		this.curentShape = curentShape;
		this.xCur = Width/2;
		this.yCur = 0;
	}
	
	public boolean isColision(){
		if ((yCur + 1 + Shape.getHeightCurBlock(curentShape)) >= Height){
			return true;
		}
		for (int i = 0; i < curentShape.length; i++){
			for (int j = 0; j < curentShape[i].length; j++){
				if ( curentShape[i][j] == TILE.EMPTY ){
					continue;
				}
				
				if ((yCur + i + 1) >= Height){
					return true;
				}
				
				if ( board[yCur + i + 1][xCur + j] != TILE.EMPTY ){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isColisionAfterTranslation(){
		for (int i = 0; i < curentShape.length; i++){
			for (int j = 0; j < curentShape[i].length; j++){
				if ( curentShape[i][j] == TILE.EMPTY ){
					continue;
				}
				if ( board[yCur + i][xCur + j] != TILE.EMPTY ){
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	public void writeCurrentShapeToBoard(){
		for (int i = 0; i < curentShape.length; i++){
			for (int j = 0; j < curentShape[i].length; j++){
				if ( curentShape[i][j] == TILE.EMPTY ){
					continue;
				}
				board[i + yCur][j+xCur] = curentShape[i][j];
			}
		}
	}
}
