package demoGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyFirstGUI extends JFrame {
	
	private JLabel mainLabel;

	public static void main(String[] args) {
		MyFirstGUI myGUI = new MyFirstGUI();
		myGUI.setBounds(200, 100, 400, 500);
		myGUI.setVisible(true);
		myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public MyFirstGUI() {
		
		mainLabel = new JLabel("Hi");
		mainLabel.setFont(new Font(null, Font.BOLD, 77));
		mainLabel.setBackground(Color.RED);
		mainLabel.setForeground(Color.BLACK);
		mainLabel.setHorizontalAlignment(JLabel.CENTER); //JLabel is a Swing Constant
		mainLabel.setOpaque(true);
		this.add(mainLabel);
		
		JLabel titleLabel = new JLabel("MY FIRST GUI");
		titleLabel.setFont(new Font("Papyrus", Font.BOLD, 30));
		titleLabel.setBackground(Color.GREEN);
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setOpaque(isOpaque());
		this.add(titleLabel, BorderLayout.NORTH);
		
		JButton westButton = new JButton("WEST");
		this.add(westButton, BorderLayout.WEST);
		
		JPanel southPanel = new JPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		
		JLabel southLabel = new JLabel("Name:");
		southLabel.setBackground(Color.BLUE);
		southLabel.setForeground(Color.BLACK);
		southLabel.setFont(new Font("Papyrus", Font.BOLD, 20));
		southPanel.add(southLabel);
		
		JTextField textBox = new JTextField(15);
		textBox.setFont(new Font(null, Font.BOLD, 16));
		ActionListener textBoxEventListener = new TextBoxEventHandler();
		textBox.addActionListener(textBoxEventListener);
		southPanel.add(textBox);
		
	}

	private class TextBoxEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField tField = (JTextField)e.getSource();
			mainLabel.setText(tField.getText());
			tField.setText("");
			
		}
		
	}
}
