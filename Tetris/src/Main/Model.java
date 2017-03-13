package Main;

public class Model {
	
	static private Image [] Images;
	
	{
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
	
	static public Image getImage(IMAGES image) {
		return Images[image.denomValue()];
	}
}

