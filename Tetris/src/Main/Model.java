package Main;

public class Model {
	
	private Image [] Images;
	private static Model model;
	
	private Model(){
		System.out.println("Images Loading...");
		
		String [] pathImage = { "./images/background.jpg",
								"./images/blue.png",
								"./images/brown.png",
								"./images/green.png",
								"./images/orange.png",
								"./images/pause.png",
								"./images/purple.png",
								"./images/red.png",
								"./images/tlo_inkspace.png",
								"./images/torquise.png",
								"./images/yellow.png" };
		Images = new Image[pathImage.length];
		for(int i = 0; i < pathImage.length; i++)
			Images[i] = new Image(pathImage[i]);		
	}
	
	static Model getModel(){
		if (!(model instanceof Model)){
			model = new Model();
		}
		return model;
	}
	
	public Image getImage(IMAGES image) {
		return Images[image.denomValue()];
	}
}

