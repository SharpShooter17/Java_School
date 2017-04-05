package Main;

public enum TILE {
	RED(IMAGES.RED),
	GREEN(IMAGES.GREEN), 
	BLUE(IMAGES.BLUE), 
	YELLOW(IMAGES.YELLOW), 
	BROWN(IMAGES.BROWN),
	ORANGE(IMAGES.ORANGE),
	PURPLE(IMAGES.PURPLE),
	TORQUISE(IMAGES.TORQUISE),
	EMPTY(IMAGES.PAUSE);
		 
	private final IMAGES image;

    private TILE(IMAGES image) {
        this.image = image;
    }

    public IMAGES toImage() {
        return image;
    }
	 
}
