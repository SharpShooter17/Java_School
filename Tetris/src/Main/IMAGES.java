package Main;

public enum IMAGES {
	BACKGROUND(0),
	BLUE(1),
	BROWN(2), 
	GREEN(3), 
	ORANGE(4),
	PAUSE(5),
	PURPLE(6),
	RED(7),
	TLO_INKSCAPE(8),
	TORQUISE(9),
	YELLOW(10);
	
	 private final int denomValue;
	 
	 IMAGES(int denomValue){ 
		 this.denomValue = denomValue;  
	 }  
	 public int denomValue() {  
		 return denomValue;  
	 }  
}
