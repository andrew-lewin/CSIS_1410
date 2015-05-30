package pacman;
/*
 * @authors Andrew Lewin & Joshua Hardesty
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Ghost implements ActionListener {
	private JLabel ghost;
	private int location, moveDown;
	private JLabel nextLabel;
	private int iteration = 0;
	private Timer timer;
	private int rows;
	private static List<Timer> activeGhosts = new ArrayList<>();
	
	public Ghost(int location, int moveDown, int rows){
		ghost = new JLabel(Images.BLACKGHOST.getIcon());
		this.location = location - moveDown;
		this.moveDown = moveDown;
		this.rows = rows;
		attack();
	}
	
	public void attack() {
		timer = new Timer(250, this);
		activeGhosts.add(timer);
		timer.start();
	}
	
	public static void stopAllAttack() {
		for (Timer timer : activeGhosts) {
			timer.stop();
		}
		activeGhosts.clear();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (iteration != rows) {
			if (iteration != 0){
				PacmanApp.setJLabels(nextLabel, location);
			}
			nextLabel = (JLabel) PacmanApp.getJLabels()[location + moveDown];
			if (nextLabel.getIcon() == Images.FOOD.getIcon() || nextLabel.getIcon() == null) {
				ghost.setIcon(Images.WHITEGHOST.getIcon());
			} else {
				ghost.setIcon(Images.BLACKGHOST.getIcon());
			}
			PacmanApp.setJLabels(ghost, location + moveDown);
			iteration++;
			location += moveDown;
			if (location == Pacman.getLocation()) {
				PacmanApp.setDidWin(false);
			}
		} else {
			PacmanApp.setJLabels(nextLabel, location);
			activeGhosts.remove(0).stop();
		}
	}
}
