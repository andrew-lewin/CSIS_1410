package buildingWithGuiDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Building extends JPanel {
	private final Color[] colors = {Color.YELLOW, Color.BLACK};
	private final Random rand = new Random();
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.CYAN);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 600, 400, 100);
		g.setColor(Color.YELLOW);
		g.fillOval(340, 10, 50, 50);
		g.setColor(Color.GRAY);
		g.fillRect(100, 100, 200, 550);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(175, 575, 50, 75);
		
		g.setColor(Color.CYAN);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 4 ;j++){
				g.setColor(colors[rand.nextInt(colors.length)]);
				
				g.fillRect(63 + (j+1)*50, 63 + (i+1)*50, 25, 25);
				g.setColor(Color.DARK_GRAY);
				g.fillRect(75 + (j+1)*50, 63 + (i+1)*50, 2, 25);
				g.fillRect(63 + (j+1)*50, 75 + (i+1)*50, 25, 2);
			}
		}
		
	}

}
