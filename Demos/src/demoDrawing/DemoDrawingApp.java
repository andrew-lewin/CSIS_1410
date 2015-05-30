package demoDrawing;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DemoDrawingApp extends JFrame {

	public static void main(String[] args) {
		new DemoDrawingApp().run();
	}
	
	public void run() {
		setBounds(100, 10, 600, 400);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    add(new DemoDrawing());
	    setVisible(true);
	}

}
