package imageButton;

import javax.swing.JFrame;

public class imageButtonApp {
	public static void main(String[] args) {
		
		ImageButton imageButton = new ImageButton();
		imageButton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageButton.setBounds(100, 100, 660, 660);
		imageButton.setVisible(true);

	}

}
