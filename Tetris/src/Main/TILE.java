package Main;

public enum TILE {
	RED(0),
	GREEN(1), 
	BLUE(2), 
	YELLOW(3), 
	BROWN(4),
	ORANGE(5),
	PURPLE(6),
	TORQUISE(7),
	EMPTY(8);
	
	private final int denomValue;
	 
	TILE(int denomValue){ 
		 this.denomValue = denomValue;  
	 }  
	 public int denomValue() {  
		 return denomValue;  
	 } 
}
