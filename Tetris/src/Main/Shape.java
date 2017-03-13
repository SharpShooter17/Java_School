package Main;

import java.util.Random;

public class Shape {
	
	static final TILE [][][] shapes = {
			{
				{ TILE.BLUE },	//Najd³u¿szy bloczek 	*
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
			System.out.println("Wyrzuæ wyj¹tek!");
		}
		return shapes[index];
	}
}
