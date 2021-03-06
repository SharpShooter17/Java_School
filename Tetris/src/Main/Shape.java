package Main;

import java.util.Random;

public class Shape {
	
	static final TILE [][][] shapes = {
			{
				{ TILE.BLUE },	//Najd�u�szy bloczek 	*
				{ TILE.BLUE },						// 	*
				{ TILE.BLUE },						//	*
				{ TILE.BLUE }						//	*
			},
			{
				{ TILE.GREEN, TILE.GREEN },						//**
				{ TILE.EMPTY, TILE.GREEN, TILE.GREEN }			// **
			},
			{
				{ TILE.BROWN },						//*
				{ TILE.BROWN, TILE.BROWN },			//**
				{ TILE.EMPTY, TILE.BROWN}			// *
			},
			{
				{TILE.ORANGE, TILE.ORANGE},			//**
				{TILE.ORANGE, TILE.ORANGE}			//**
			},
			{
				{ TILE.EMPTY, TILE.TORQUISE, TILE.EMPTY },			// *
				{ TILE.TORQUISE, TILE.TORQUISE, TILE.TORQUISE }		//***
			},
			{
				{ TILE.YELLOW },									//*
				{ TILE.YELLOW },									//*
				{ TILE.YELLOW, TILE.YELLOW }						//**
			},
			{
				{ TILE.PURPLE, TILE.PURPLE },						//**
				{ TILE.EMPTY, TILE.PURPLE },						// *
				{ TILE.EMPTY, TILE.PURPLE }							// *
			}
	};
		
	static int randomShape(){
		Random generator = new Random();
		return generator.nextInt(shapes.length);
	}
	
	static final TILE [][] getShape(int index){
		if (index < 0 || index >= shapes.length) {
			System.out.println("Wyrzu� wyj�tek!");
		}
		return shapes[index];
	}
	
	static TILE[][] rotate( TILE[][] shape ){	
		final int M = shape.length;
	    final int N = getWidthCurBlock(shape);
	    TILE[][] ret = new TILE[N][M];
	    for (int r = 0; r < M; r++) {
	        for (int c = 0; c < N; c++) {
	        	if ( shape[r].length < c ){
	        		ret[c][M - 1 - r] = shape[r][c];
	        	}
	        }
	    }
	    return ret;
	}
	
	static int getWidthCurBlock(TILE [][] shape) {
		if (!(shape instanceof TILE[][])){
			return 0;
		}
		
		int result = shape[0].length;
		
		for (int i = 1; i < shape.length; i++){
			if ( shape[i].length > result ){
				result = shape[i].length;
			}
		}
		return result;
	}
	
	static int getHeightCurBlock(TILE [][] shape){
		if (shape instanceof TILE[][] ){
			return shape.length;
		}
		return 0;
	}
}
