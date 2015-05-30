package demoGUI;

import javax.swing.JOptionPane;

public class DemoJDialogue {
	
	public static void main(String[] args){
		String userInput = JOptionPane.showInputDialog("Yo dawg, plz 2 entr msg dats pos num");
		int intUserInput = Integer.parseInt(userInput);
		
		if (intUserInput >= 0){
			JOptionPane.showMessageDialog(null, "The number " + intUserInput + " is " + ((intUserInput % 2 == 0) ? "even." : "odd."), null, JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "That's not greater than 0", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
