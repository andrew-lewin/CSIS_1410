package pacman;
/*
 * @authors Andrew Lewin & Joshua Hardesty
 */
import javax.swing.ImageIcon;

public enum Images {
	PACKMANSTART(new ImageIcon(Images.class.getResource("resources/pacmanStart.png"))),
	PACKMANLEFT(new ImageIcon(Images.class.getResource("resources/pacmanLeft.gif"))),
	PACKMANUP(new ImageIcon(Images.class.getResource("resources/pacmanUp.gif"))),
	PACKMANRIGHT(new ImageIcon(Images.class.getResource("resources/pacmanRight.gif"))),
	PACKMANDOWN(new ImageIcon(Images.class.getResource("resources/pacmanDown.gif"))),
	WALL(new ImageIcon(Images.class.getResource("resources/wall.png"))), 
	FOOD(new ImageIcon(Images.class.getResource("resources/egg.png"))), 
	WHITEGHOST(new ImageIcon(Images.class.getResource("resources/ghostWhiteBG.gif"))), 
	BLACKGHOST(new ImageIcon(Images.class.getResource("resources/ghostBlackBG.gif"))),
	GAMEOVERPACMAN(new ImageIcon(Images.class.getResource("resources/pacmanBlackBGRight.gif"))),
	GAMEOVERGHOST(new ImageIcon(Images.class.getResource("resources/ghostBlackBGGameOver.gif")));
	
	private final ImageIcon icon;
	
	Images(ImageIcon icon){
		this.icon = icon;
	}

	public ImageIcon getIcon() {
		return icon;
	}
}
