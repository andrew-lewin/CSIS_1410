package pacman;
/*
 * @authors Andrew Lewin & Joshua Hardesty
 */
import javax.swing.ImageIcon;


public class Pacman {
	private static ImageIcon pacmanImage;
	private static int location;
	
	public Pacman(){
		pacmanImage = Images.PACKMANSTART.getIcon();
		location = 149;
	}
	
	public void setLocation(int direction){
		location = direction;
	}
	
	public static int getLocation(){
		return location;
	}
	
	public ImageIcon getImage() {
		return pacmanImage;
	}

	public void setImage(ImageIcon newImage) {
		pacmanImage = newImage;
	}
	
	public static void reset() {
		pacmanImage = Images.PACKMANSTART.getIcon();
		location = 149;
	}

}
