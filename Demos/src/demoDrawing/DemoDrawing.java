package demoDrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DemoDrawing extends JPanel {
	private final Color[] colors = {Color.WHITE, Color.ORANGE, Color.YELLOW};
	private final Random rand = new Random();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
//		g.setColor(Color.RED);
//		g.fillRect(100, 100, 400, 100);
//		
//		g.setColor(Color.BLUE);
//		g.fillOval(250, 200, 100, 100);
		
		g.setColor(Color.ORANGE);
		for(int i = 0; i < 5 ;i++){
			g.setColor(colors[rand.nextInt(colors.length)]);
			g.drawOval(100 + i*70, 100, 100, 100);
		}
		
		
	}

}
